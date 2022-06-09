package com.mvc.withbooks;

<<<<<<< HEAD

=======
>>>>>>> WJ
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
	
<<<<<<< HEAD
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
=======
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
>>>>>>> WJ
	public String clientManage() {
		return "homepage/admin/memberManage/clientList";
	}
	
<<<<<<< HEAD
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
=======
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
>>>>>>> WJ
	}
	
	@RequestMapping("/saleTotal")
	public String saleTotal() {
		return "homepage/admin/saleManage/saleTotal";
	}

}
