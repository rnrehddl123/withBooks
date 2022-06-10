package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@RequestMapping("/main")
	public String main() {
		return "/main/main";
	}
	
	@RequestMapping("/login")
	public String Login() {
		return "/main/login";
	}
	
	@RequestMapping("/signUp")
	public String SignUp() {
		return "/main/signUp";
	}
}
