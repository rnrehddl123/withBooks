package com.mvc.withbooks;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/cateManage.do")
	public String cateManage() {
		return "admin/cateManage";
	}
	
	@RequestMapping("/notice.do")
	public String notice() {
		return "admin/notice";
	}
	
	@RequestMapping("/list_board.do")
	public String list_board() {
		return "board/list";
	}
	
	@RequestMapping("/clientManage.do")
	public String clientManage() {
		return "admin/clientManage";
	}
	
	@RequestMapping("/writerManage.do")
	public String writerManage() {
		return "admin/writerManage";
	}
	
	@RequestMapping("/novelManage.do")
	public String novelManage() {
		return "admin/novelManage";
	}
	
	@RequestMapping("/saleManage.do")
	public String saleManage() {
		return "admin/saleManage";
	}

}
