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
	
	@RequestMapping("/cateInsert")
	public String cateInsert() {
		return "homepage/admin/cateManage/cateInsert";
	}
	
	@RequestMapping("/cateUpdate")
	public String cateUpdate() {
		return "homepage/admin/cateManage/cateUpdate";
	}
	
	@RequestMapping("/cateList")
	public String cateList() {
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
