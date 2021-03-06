package com.mvc.withbooks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mvc.withbooks.dto.*;
import com.mvc.withbooks.service.CategoryMapper;
import com.mvc.withbooks.service.EpisodeMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeEpisodeMapper;
import com.mvc.withbooks.service.NovelMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;

@Controller
public class WriterController {
	
	@Resource(name="novelUploadPath")
	 String novelUploadPath;
	
	@Autowired
	private NovelMapper novelMapper;
	
	@Autowired
	private EpisodeMapper episodeMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private NoticeEpisodeMapper noticeEpisodeMapper;
	
	@Autowired
	private PurchaseHistoryMapper purchaseHistoryMapper;
	
	//에피소드 리스트 이동
	@RequestMapping("/writerEpisodeList")
	public String WriterEpisodeLIst(HttpServletRequest req, int nnum,
			@RequestParam(required = false) String change, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		if(change==null) {
			change = "now";
		}
		int mnum = login.getMnum();
		NovelDTO dto = novelMapper.getNovel(nnum);
		if(dto.getMemberDTO().getMnum()!=mnum) {
			return "redirect:main";
		}
		req.setAttribute("getNovel", dto);
		List<Map<String, String>> list = episodeMapper.listEpisodeCount(nnum);
		int pageSize = 20;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		Map<String, String> params = new HashMap<String, String>();
		params.put("nnum", String.valueOf(nnum));
		params.put("startRow", String.valueOf(startRow));
		params.put("endRow", String.valueOf(endRow));
		int rowCount = episodeMapper.getEpisodeCount(nnum);
		if (endRow > rowCount) endRow = rowCount;
		list = null;
		if (rowCount>0){
			if(change.equals("past")) {
				list=episodeMapper.episodeCountListReverse(params);
			}else {
				list = episodeMapper.episodeCountList(params);
			}
		}
		int episodeNum =  rowCount - (startRow - 1);
		if (rowCount>0) {
			int pageCount = rowCount/pageSize + (rowCount%pageSize==0 ? 0 : 1);
			int pageBlock = 10;
			int startPage = (currentPage - 1)/pageBlock  * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) endPage = pageCount;
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("startPage", startPage);
			req.setAttribute("endPage", endPage);
		}
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("episodeNum", episodeNum);
		req.setAttribute("listEpisodeCount", list);
		req.setAttribute("change", change);
		return "writer/writerPage/writerSubject/writerEpisodeList";
	}
		
	//에피소드 작성 페이지 이동
	@RequestMapping("/writerEpisode")
	public String WriterEpisode(HttpServletRequest req, int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		req.setAttribute("nnum", nnum);
		return "writer/writerPage/writerSubject/writerEpisode";
	}
	
	//에피소드 작성 기능
	@RequestMapping("/insertEpisode")
	public String insertEpisode(HttpServletRequest req, @ModelAttribute EpisodeDTO dto,
			int nnum, HttpSession session, @RequestParam Map<String, String> params) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		params.put("mnum", String.valueOf(login.getMnum()));
		params.put("Purchase_price","0");
		int res = episodeMapper.insertEpisode(dto, nnum);
		int res2= noticeEpisodeMapper.sendNoticeEpisode(dto);	
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 등록 성공, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList?nnum=" + nnum;
			List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
			checkList.add(dto.getEpnum());
			session.setAttribute("checkList", checkList);
			Map<String, String> epmap = episodeMapper.contentNoEpisode(dto.getEpnum());
			params.put("nnum", String.valueOf(nnum));
			params.put("epnum", String.valueOf(dto.getEpnum()));
			int res3= purchaseHistoryMapper.insertPurchase(params);
		}else {
			msg = "에피소드 등록 실패!!, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList?nnum=" + nnum;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	
	//에피소드 수정 페이지 이동	
	@RequestMapping(value="writerEpisodeUpdate", method=RequestMethod.GET)
	public String WriterEpisodeUpdateForm(HttpServletRequest req, @RequestParam int epnum, @RequestParam int nnum, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		int mnum = login.getMnum();
		EpisodeDTO dto = episodeMapper.getEpisode(epnum, "update");
		if(dto.getNovelDTO().getMemberDTO().getMnum()!=mnum) {
			return "redirect:main";
		}
		req.setAttribute("getEpisode", dto);
		req.setAttribute("nnum", nnum);
		return "writer/writerPage/writerSubject/writerEpisodeUpdate";
	}
	
	
	//에피소드 수정 기능
	@RequestMapping(value="writerEpisodeUpdate", method=RequestMethod.POST)
	public String WriterEpisodeUpdate(HttpServletRequest req, @ModelAttribute EpisodeDTO dto, @RequestParam int nnum, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		int res = episodeMapper.updateEpisode(dto);
	      String msg = null, url = null;
	      if(res>0) {
	         msg = "에피소드가 수정되었습니다";
	         url = "writerEpisodeList?nnum=" + nnum;
	      }else {
	         msg = "에피소드를 다시 수정해주세요!";
	         url = "writerNovelList?nnum=" + nnum;
	      }
	      req.setAttribute("msg", msg);
	      req.setAttribute("url", url);
	      return "message";
	}
	
	//소설 작성 페이지 이동
	@RequestMapping(value="writerNovel", method=RequestMethod.GET)
	public String WriterNovelForm(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		List<CategoryDTO> list = categoryMapper.listCategory();
		req.setAttribute("listCategory", list);
		return "writer/writerPage/writerSubject/writerNovel";
	}
	
	
	//소설 작성 기능
	@RequestMapping(value="writerNovel", method=RequestMethod.POST)
	public String WriterNovel(HttpServletRequest req, HttpSession session, @ModelAttribute NovelDTO dto,BindingResult result){
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "/main/login";
		}  
		int mnum = login.getMnum();
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
	      MultipartFile mf = mr.getFile("file");
	      String filename = mf.getOriginalFilename();
	      UUID uuid = UUID.randomUUID();
	      filename = uuid.toString() + "_" + filename;
	      dto.setNovel_image(filename);
	      if (filename != null && !(filename.trim().equals(""))) {
	         File file = new File(novelUploadPath, filename);
	         try {
	            mf.transferTo(file);
	         }catch(IOException e) {}
	      }
	      
	      int res = novelMapper.insertNovel(dto,mnum);
	      String msg = null, url = null;
	      if(res>0) {
	         msg = "등록 성공";
	         url = "writerNovelList?mnum=" + mnum;
	      }else {
	         msg = "등록 실패";
	         url = "writerNovelList?mnum=" + mnum;
	      }
	      req.setAttribute("msg", msg);
	      req.setAttribute("url", url);
	      return "message";
	   }
	
	
	//소설 리스트
	@RequestMapping("/writerNovelList")
	public String WriterNovelList(HttpServletRequest req, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		int mnum = login.getMnum();
			MemberDTO dto = memberMapper.getMember(login.getMnum());
			req.setAttribute("getMember", dto);
			List<Map<String, String>> list = novelMapper.listNovelCount(login.getMnum());
			int pageSize = 40;
			String pageNum = req.getParameter("pageNum");
			if (pageNum==null){
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1) * pageSize + 1;
			int endRow = startRow + pageSize -1;
			Map<String, String> params = new HashMap<String, String>();
			params.put("mnum", String.valueOf(login.getMnum()));
			params.put("startRow", String.valueOf(startRow));
			params.put("endRow", String.valueOf(endRow));
			int rowCount = novelMapper.novelCount(login.getMnum());
			if (endRow > rowCount) endRow = rowCount;
			int novelNum =  rowCount - (startRow - 1);
			list = null;
			if (rowCount>0){
				list = novelMapper.novelCountList(params);
			}
			if (rowCount>0) {
				int pageCount = rowCount/pageSize + (rowCount%pageSize==0 ? 0 : 1);
				int pageBlock = 10;
				int startPage = (currentPage - 1)/pageBlock  * pageBlock + 1;
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount) endPage = pageCount;
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("startPage", startPage);
				req.setAttribute("endPage", endPage);
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("novelNum", novelNum);
			req.setAttribute("listmemberNovel", list);
			return "writer/writerPage/writerSubject/writerNovelList";
		}
	
	//소설 수정 페이지 이동
	@RequestMapping(value="writerNovelUpdate", method=RequestMethod.GET)
	public String WriterNovelUpdateForm(HttpServletRequest req, @RequestParam int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		NovelDTO dto = novelMapper.getNovel(nnum);
		req.setAttribute("getNovel", dto);
		return "writer/writerPage/writerSubject/writerNovelUpdate";
	}
	
	//소설 수정 기능
	@RequestMapping(value="writerNovelUpdate", method=RequestMethod.POST)
	public String WriterNovelUpdate(HttpServletRequest req, @ModelAttribute NovelDTO dto,		
	         @RequestParam int mnum,BindingResult result, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}  
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
	      MultipartFile mf = mr.getFile("file");
	      String filename = mf.getOriginalFilename();
	      UUID uuid = UUID.randomUUID();
	       filename = uuid.toString() + "_" + filename;
	      if (filename != null && !(filename.trim().equals(""))) {
	         File file = new File(novelUploadPath, filename);
	         try {
	            mf.transferTo(file);
	         }catch(IOException e) {}
	      }else {
	         filename = req.getParameter("file2"); 
	      }      
	      dto.setNovel_image(filename);
	      int res = novelMapper.updateNovel(dto,mnum);
	      String msg = null, url = null;
	      if(res>0) {
	         msg = "소설이 수정되었습니다.";
	         url = "writerNovelList?mnum=" + mnum;
	      }else {
	         msg = "소설 수정에 실패하였습니다.";
	         url = "writerNovelList?mnum" + mnum;
	      }
	      req.setAttribute("msg", msg);
	      req.setAttribute("url", url);
	      return "message";
	   }
	
	//에피소드별 매출 차트
	@RequestMapping("/chart")
	public String WriterChart(HttpServletRequest req, HttpSession session, int nnum) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		int mnum = login.getMnum();
		NovelDTO dto = novelMapper.getNovel(nnum);
		if(dto.getMemberDTO().getMnum()!=mnum) {
			return "redirect:main";
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("mnum", String.valueOf(login.getMnum()));
		params.put("nnum", String.valueOf(nnum));
		List<Map<String, String>> list = purchaseHistoryMapper.chart(params);
		req.setAttribute("getNovel", dto);
		req.setAttribute("chart", list);
		req.setAttribute("mnum", mnum);
		return "writer/writerPage/writerChart";
	}
	
	//날짜별 매출 차트
	@RequestMapping("/writerPay")
	public String WriterPay(HttpServletRequest req, HttpSession session, int nnum) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		int mnum = login.getMnum();
		NovelDTO dto = novelMapper.getNovel(nnum);
		if(dto.getMemberDTO().getMnum()!=mnum) {
			return "redirect:main";
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("mnum", String.valueOf(login.getMnum()));
		params.put("nnum", String.valueOf(nnum));
		List<Map<String, String>> list = purchaseHistoryMapper.writerChart(params);
		
		req.setAttribute("getNovel", dto);
		req.setAttribute("writerChart", list);
		req.setAttribute("mnum", mnum);
		return "writer/writerPage/writerPay";
	}
	
	//회원의 정산내역
	@RequestMapping("/memeberChart")
	public String MemberChart(HttpServletRequest req, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		int mnum = login.getMnum();
		MemberDTO dto = memberMapper.getMember(login.getMnum());
		if(dto.getMnum()!=mnum) {
			return "redirect:main";
		}
		List<Map<String, String>> list = purchaseHistoryMapper.memberChart(mnum);
		List<Map<String, String>> list2 = purchaseHistoryMapper.sumChart(mnum);
		req.setAttribute("memberChart", list);
		req.setAttribute("sumChart", list2);
		req.setAttribute("mnum", mnum);
		req.setAttribute("getMember", dto);
		return "writer/writerPage/memberChart";
	}
}
