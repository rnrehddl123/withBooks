package com.mvc.withbooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WriterController {
	
	@Resource(name="uploadPath")
	 String uploadPath;
	
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
	
	
	@RequestMapping("/writerOrderList")
	public String WriterOrderList() {
		return "writer/writerPage/writerOrderList";
	}
	
	
	@RequestMapping("/writerNovelEpisode")
	public String WriterNovelEpisode(HttpServletRequest req, @RequestParam int epnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		EpisodeDTO dto = episodeMapper.getEpisode(epnum, "writerNovelEpisode");
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
		List<EpisodeDTO> list = episodeMapper.listEpisode(nnum);
		req.setAttribute("listEpisode", list);
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
	public String insertEpisode(HttpServletRequest req, @ModelAttribute EpisodeDTO dto, int nnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = episodeMapper.insertEpisode(dto, nnum);
		int res2= noticeEpisodeMapper.sendNoticeEpisode(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 등록 성공, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList?nnum=" + nnum;
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
	         File file = new File(uploadPath, filename);
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
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		MemberDTO dto = memberMapper.getMember(mnum);
		req.setAttribute("getMember", dto);
		List<NovelDTO> list = novelMapper.listmemberNovel(mnum);
		req.setAttribute("listmemberNovel", list);
		return "writer/writerPage/writerSubject/writerNovelList";
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
	         File file = new File(uploadPath, filename);
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
	
	@RequestMapping("/writerLibrary")
	public String WriterLibrary() {
		return "writer/writerPage/writerLibrary";
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
