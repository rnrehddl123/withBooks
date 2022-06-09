package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
	
	@RequestMapping("/cateManage")
	public String cateManage() {
		return "admin/cateManage";
	}
	
	@RequestMapping("/notice")
	public String notice() {
		return "admin/notice";
	}
	
	@RequestMapping("/list_board")
	public String list_board() {
		return "board/list";
	}
	
	@RequestMapping("/clientManage")
	public String clientManage() {
		return "admin/clientManage";
	}
	
	@RequestMapping("/writerManage")
	public String writerManage() {
		return "admin/writerManage";
	}
	
	@RequestMapping("/novelManage")
	public String novelManage() {
		return "admin/novelManage";
	}
	
	@RequestMapping("/saleManage")
	public String saleManage() {
		return "admin/saleManage";
	}
}
