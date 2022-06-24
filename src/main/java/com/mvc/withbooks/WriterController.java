package com.mvc.withbooks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
	
	@RequestMapping("/writerOrderList")
	public String WriterOrderList() {
		return "writer/writerPage/writerOrderList";
	}
	
	
	@RequestMapping("/writerNovelEpisode")
	public String WriterNovelEpisode(HttpServletRequest req, @RequestParam int epnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		EpisodeDTO dto = episodeMapper.getEpisode(epnum, "view");
		req.setAttribute("getEpisode", dto);
		req.setAttribute("epnum", epnum);
		return "writer/writerPage/writerOrderList/writerNovelEpisode";
	}
	
	@RequestMapping("/writerNovelSubject")
	public String WriterNovelSubject() {
		return "writer/writerPage/writerOrderList/writerNovelSubject";
	}
	
	@RequestMapping("/writerEpisodeList")
	public String WriterEpisodeLIst(HttpServletRequest req, int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		NovelDTO dto = novelMapper.getNovel(nnum);
		req.setAttribute("getNovel", dto);
		List<Map<String, String>> list = episodeMapper.listEpisodeCount(nnum);
		int pageSize = 40;
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
			list = episodeMapper.episodeCountList(params);
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
		return "writer/writerPage/writerSubject/writerEpisodeList";
	}
		
	//에피소드 작성 페이지
	@RequestMapping("/writerEpisode")
	public String WriterEpisode(HttpServletRequest req, int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		req.setAttribute("nnum", nnum);
		return "writer/writerPage/writerSubject/writerEpisode";
	}
	
	//에피소드 추가
	
	@RequestMapping("/insertEpisode")
	public String insertEpisode(HttpServletRequest req, @ModelAttribute EpisodeDTO dto, int nnum, HttpSession session, @RequestParam Map<String, String> params) {
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
	
	//에피소드 삭제
	@RequestMapping("/writerEpisodeDelete")
	public String WriterEpisodeDelete(HttpServletRequest req, @RequestParam int epnum, @RequestParam int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = episodeMapper.deleteEpisode(epnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 삭제 성공, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList?nnum=" + nnum;
		}else {
			msg = "에피소드 삭제 실패!!, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList?nnum" + nnum;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	//에피소드 수정
	
	@RequestMapping(value="writerEpisodeUpdate", method=RequestMethod.GET)
	public String WriterEpisodeUpdateForm(HttpServletRequest req, @RequestParam int epnum, @RequestParam int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		EpisodeDTO dto = episodeMapper.getEpisode(epnum, "update");
		req.setAttribute("getEpisode", dto);
		req.setAttribute("nnum", nnum);
		return "writer/writerPage/writerSubject/writerEpisodeUpdate";
	}
	
	@RequestMapping(value="writerEpisodeUpdate", method=RequestMethod.POST)
	public String WriterEpisodeUpdate(HttpServletRequest req, @ModelAttribute EpisodeDTO dto, @RequestParam int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
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
	
	@RequestMapping(value="writerNovel", method=RequestMethod.GET)
	public String WriterNovelForm(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		List<CategoryDTO> list = categoryMapper.listCategory();
		req.setAttribute("listCategory", list);
		return "writer/writerPage/writerSubject/writerNovel";
	}
	
	@RequestMapping(value="writerNovel", method=RequestMethod.POST)
	public String WriterNovel(HttpServletRequest req, HttpSession session, @ModelAttribute NovelDTO dto, @RequestParam int mnum,BindingResult result){
		if(session.getAttribute("login")==null){
			return "/main/login";
		}  
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
	
	@RequestMapping("/writerNovelList")
	public String WriterNovelList(HttpServletRequest req, HttpSession session, int mnum) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "/main/login";
		}
		if(login.getMnum()==mnum) {
			MemberDTO dto = memberMapper.getMember(login.getMnum());
			req.setAttribute("getMember", dto);
			List<Map<String, String>> list = novelMapper.listEpisodeCount(login.getMnum());
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
		}else {
			return "/main/main";
		}
	}
	
	@RequestMapping(value="writerNovelUpdate", method=RequestMethod.GET)
	public String WriterNovelUpdateForm(HttpServletRequest req, @RequestParam int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		NovelDTO dto = novelMapper.getNovel(nnum);
		req.setAttribute("getNovel", dto);
		return "writer/writerPage/writerSubject/writerNovelUpdate";
	}
	
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
	
	@RequestMapping("/writerNoveldelete")
	public String writerNoveldelete(HttpServletRequest req, @RequestParam int nnum, HttpSession session, @RequestParam int mnum) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = novelMapper.deleteNovel(nnum);
		String msg = null, url = null;
		if(res>0) {
			msg = "소설이 삭제 되었습니다.";
			url = "writerNovelList?mnum=" + mnum;
		}else {
			msg = "소설 삭제에 실패하였습니다.";
			url = "writerNovelList?mnum=" + mnum;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@RequestMapping("/writerChart")
	public String WriterChart() {
		return "writer/writerPage/writerChart";
	}
	
	@RequestMapping("/writerPay")
	public String WriterPay() {
		return "writer/writerPage/writerPay";
	}
	
	@RequestMapping("/writerUpdate")
	public String WriterUpdate() {
		return "writer/writerPage/writerUpdate";
	}
	
}
