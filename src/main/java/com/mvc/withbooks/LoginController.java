package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/informUpdate")
	public String InFormUpdate() {
		return "/login/client/informUpdate";
	}
	
	@RequestMapping("/myLibrary")
	public String MyLibrary() {
		return "/login/client/myLibrary";
	}
	
	@RequestMapping("/ClientmyPage")
	public String ClientmyPage() {
		return "/login/client/myPage";
	}
	
	@RequestMapping("/productView")
	public String ProductView() {
		return "/login/client/productView";
	}
	
	@RequestMapping("/WritermyPage")
	public String WriteMyPage() {
		return "/login/writer/myPage";
	}
	
	@RequestMapping("/novelList")
	public String NovelList() {
		return "/login/writer/novelList";
	}
	
	@RequestMapping("/novelView")
	public String NovelView() {
		return "/login/writer/novelView";
	}
	
	@RequestMapping("/WriteEpisode")
	public String WriteEpisode() {
		return "/login/writer/writeEpisode";
	}
	
	@RequestMapping("/WriteNovel")
	public String WriteNovel() {
		return "/login/writer/Novel";
	}
	
	@RequestMapping("/login")
	public String Login() {
		return "/login/login";
	}
	
	@RequestMapping("/signUp")
	public String SignUp() {
		return "/login/signUp";
	}
}
