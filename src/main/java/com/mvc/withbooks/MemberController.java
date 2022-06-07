package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	
	@RequestMapping("/login.do")
	public String message() {
		return "member/login";
	}
	
	@RequestMapping("/signUp.do")
	public String signUp() {
		return "member/signUp";
	}
	
	@RequestMapping("/myPage.do")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("/informUpdate.do")
	public String informUpdate() {
		return "member/informUpdate";
	}
	
	@RequestMapping("/productView.do")
	public String productView() {
		return "member/productView";
	}
}
