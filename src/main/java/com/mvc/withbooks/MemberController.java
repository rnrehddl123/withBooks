package com.mvc.withbooks;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.MemberService;



@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	@Autowired
	private MemberMapper memberMapper;

	@RequestMapping(value="kakaoLogin", method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code,HttpSession session) throws Exception {
		System.out.println("#########" + code);
		String access_Token = ms.getAccessToken(code);
		HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));

		MemberDTO login=memberMapper.loginKakao((String)userInfo.get("id"));
		
		if(login==null) {
			memberMapper.insertKakaoMember(userInfo);
		}else {
			session.setAttribute("login", login);
		}
		
		return "redirect:main";
    	}

}