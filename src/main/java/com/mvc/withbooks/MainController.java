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
	
	@RequestMapping("/findId")
	public String findId() {
		return "/main/findId";
	}
	
	@RequestMapping("/findPassword")
	public String findPassword() {
		return "/main/findPassword";
	}
}
