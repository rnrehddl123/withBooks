package com.mvc.withbooks;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
	
	@RequestMapping("/homepage")
	public String homepage() {
		return "homepage/homepage";
	}
	
	@RequestMapping("/slide")
	public String slide() {
		return "homepage/admin/banerManage/slide";
	}
	
	@RequestMapping("/suggest")
	public String suggest() {
		return "homepage/admin/banerManage/suggest";
	}
	
	@RequestMapping("/cateManage")
	public String cateManage() {
		return "homepage/admin/cateManage/cateManage";
	}
	
	@RequestMapping("/boardManageList")
	public String boardManageList() {
		return "homepage/admin/boardManage/boardManageList";
	}
	
	@RequestMapping("/noticeList")
	public String noticeList() {
		return "homepage/admin/noticeManage/noticeList";
	}
	
	@RequestMapping("/noticeWriteform")
	public String noticeWriteform() {
		return "homepage/admin/noticeManage/noticeWriteform";
	}
	
	@RequestMapping("/clientManage")
	public String clientManage() {
		return "homepage/admin/memberManage/clientManage";
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
