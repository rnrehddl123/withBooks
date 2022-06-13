package com.mvc.withbooks;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.CategoryDTO;
import com.mvc.withbooks.service.CategoryMapper;

@Controller
public class AdminPageController {
	
	@Autowired
	private CategoryMapper categoryMapper;

	@RequestMapping("/homepage")
	public String homepage() {
		return "homepage/homepage";
	}
	
	@RequestMapping("/message")
	public String message() {
		return "homepage/message";
	}
	
	@RequestMapping("/slide")
	public String slide() {
		return "homepage/admin/banerManage/slide";
	}
	
	@RequestMapping("/suggest")
	public String suggest() {
		return "homepage/admin/banerManage/suggest";
	}
	
	@RequestMapping(value="/cateInsert", method=RequestMethod.GET)
	public String cateInsert() {
		return "homepage/admin/cateManage/cateInsert";
	}
	
	@RequestMapping(value="/cateInsert", method=RequestMethod.POST)
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
	
	@RequestMapping("/cateList")
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
