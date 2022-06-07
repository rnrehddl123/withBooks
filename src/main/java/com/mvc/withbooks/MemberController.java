package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	
	@RequestMapping("/login.do")
	public String message() {
		return "WEB-INF/views/member/login.jsp";
	}
	
	@RequestMapping("/signUp.do")
	public String signUp() {
		return "WEB-INF/views/member/signUp.jsp";
	}
	
	@RequestMapping("/myPage.do")
	public String myPage() {
		return "WEB-INF/views/member/myPage.jsp";
	}
	
	@RequestMapping("/informUpdate.do")
	public String informUpdate() {
		return "WEB-INF/views/member/informUpdate.jsp";
	}
	
	@RequestMapping("/productView.do")
	public String productView() {
		return "WEB-INF/views/member/productView.jsp";
	}
}
