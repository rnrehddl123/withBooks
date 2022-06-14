package com.mvc.withbooks;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.CategoryDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.AdminSlideMapper;
import com.mvc.withbooks.service.AdminSuggestMapper;
import com.mvc.withbooks.service.CategoryMapper;
import com.mvc.withbooks.service.NovelMapper;

@Controller
public class AdminPageController {
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private AdminSuggestMapper adminSuggestMapper;
	@Autowired
	private AdminSlideMapper adminSlideMapper;
	@Autowired
	private NovelMapper novelMapper;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	@RequestMapping("/homepage")//어드민 페이지 이동
	public String homepage() {
		return "homepage/homepage";
	}
	
	@RequestMapping("/message")//메세지 페이지 이동
	public String message() {
		return "homepage/message";
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.GET)//슬라이드 페이지 이동
	public String slide() {
		return "homepage/admin/banerManage/slide";
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.POST)//슬라이드 등록
	public String slide(HttpServletRequest req, @ModelAttribute AdminSlideDTO dto, 
			BindingResult result) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile mf = mr.getFile("slidet_image");
		String filename = mf.getOriginalFilename();
		dto.setSlidet_image(filename);
		if (filename != null && !(filename.trim().equals(""))) {
			File file = new File(uploadPath, filename);
			try {
				mf.transferTo(file);
			}catch(IOException e) {}
		}
		int res = adminSlideMapper.insertAdminSlide(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "슬라이드 등록 성공";
			url = "homepage";
		}else {
			msg = "슬라이드 등록 실패";
			url = "slide";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping(value="/suggest", method=RequestMethod.GET)//추천작 페이지 이동
	public String suggest(HttpServletRequest req) {
		List<NovelDTO> list = novelMapper.listNovel();
		req.setAttribute("listNovel", list);
		List<AdminSuggestDTO> slist = adminSuggestMapper.listAdminSuggest();
		req.setAttribute("listAdminSuggest", slist);
		return "homepage/admin/banerManage/suggest";
	}
	
	@RequestMapping(value="/suggest", method=RequestMethod.POST)//추천작 등록
	public String suggest(HttpServletRequest req, @ModelAttribute AdminSuggestDTO dto, int nnum) {
		int res = adminSuggestMapper.insertAdminSuggest(dto, nnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "추천작 입력 성공";
			url = "suggest";
		}else {
			msg = "추천작 입력 실패";
			url = "suggest";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/suggestDelete")
	public String suggestDelete(HttpServletRequest req, int sunum) {
		int res = adminSuggestMapper.deleteAdminSuggest(sunum);
		String msg = null, url = null;
		if (res>0) {
			msg = "추천작 삭제 성공";
			url = "suggest";
		}else {
			msg = "추천작 삭제 실패";
			url = "suggest";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping(value="/cateInsert", method=RequestMethod.GET)//카테고리 페이지 이동
	public String cateInsert() {
		return "homepage/admin/cateManage/cateInsert";
	}
	
	@RequestMapping(value="/cateInsert", method=RequestMethod.POST)//카테고리 등록
	public String cateInsert(HttpServletRequest req, @ModelAttribute CategoryDTO dto) {
		int res = categoryMapper.insertCategory(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "카테고리 입력 성공";
			url = "cateList";
		}else {
			msg = "카테고리 입력 실패";
			url = "cateInsert";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/cateList")//카테고리 리스트 페이지 이동
	public String cateList(HttpServletRequest req) {
		List<CategoryDTO> list = categoryMapper.listCategory();
		req.setAttribute("listCategory", list);
		return "homepage/admin/cateManage/cateList";
	}
	
	@RequestMapping("/boardList")
	public String boardManageList() {
		return "homepage/admin/boardManage/boardList";
	}
	
	@RequestMapping("/noticeList")
	public String noticeList() {
		return "homepage/admin/noticeManage/noticeList";
	}
	
	@RequestMapping("/noticeInsert")
	public String noticeInsert() {
		return "homepage/admin/noticeManage/noticeInsert";
	}
	
	@RequestMapping("/noticeUpdate")
	public String noticeUpdate() {
		return "homepage/admin/noticeManage/noticeUpdate";
	}
	
	@RequestMapping("/clientList")
	public String clientList() {
		return "homepage/admin/memberManage/clientList";
	}
	

	@RequestMapping("/clientUpgrade")
	public String clientUpgrade() {
		return "homepage/admin/memberManage/clientUpgrade";
	}
	
	@RequestMapping("/saleManageClient")
	public String saleManageClient() {
		return "homepage/admin/saleManage/saleManageClient";
	}
	
	@RequestMapping("/saleManageWriter")
	public String saleManageWriter() {
		return "homepage/admin/saleManage/saleManageWriter";
	}
	
	@RequestMapping("/saleTotal")
	public String saleTotal() {
		return "homepage/admin/saleManage/saleTotal";
	}

}
