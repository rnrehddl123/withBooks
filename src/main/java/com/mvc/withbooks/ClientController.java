package com.mvc.withbooks;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.service.MemberMapper;

@Controller
public class ClientController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@RequestMapping("/clientMypage")//마이페이지
	public String ClientmyPage() {
		return "client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	public String ClientUpdate() {
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLibrary")//占쏙옙 占쏙옙占쏙옙
	public String ClientLibrary() {
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//占쏙옙袂占쏙옙占�
	public String ClientCart() {
		return "client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//占쌍뱄옙占싹깍옙
	public String ClientOrder() {
		return "client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//占쏙옙占신놂옙占쏙옙
	public String ClientOrderList() {
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientNovelSubject")//占쌀쇽옙占쏙옙占쏙옙
	public String ClientNovelSubject() {
		return "client/clientMypage/clientOrderList/clientNovelSubject";
	}
	
	@RequestMapping("/clientNovelEpi")//占쏙옙占실소드보占쏙옙
	public String ClientNovelEpi() {
		return "client/clientMypage/clientOrderList/clientNovelEpi";
	}
	
	@RequestMapping("/clientViewer")//占쏙옙占실소드보占쏙옙
	public String ClientViewer() {
		return "client/clientViewer";
	}
	
	
	@RequestMapping("/clientRequest")//占쌜곤옙 占쏙옙청
	public String ClientNovelRequest() {
		return "client/clientMypage/clientRequest";
	}
	
	@RequestMapping("/clientPay")//占쏙옙占쏙옙占싹깍옙
	public String ClientPay() {
		return "client/clientMypage/clientPay";
	}
	
	@RequestMapping("/clientNovelInfo")//占쌀쇽옙 占쏙옙占�
	public String ClientNovelInfo() {
		return "client/clientNovelInfo";
	}
	
	@RequestMapping("/clientNotice")//占쏙옙占쏙옙占쏙옙占쏙옙
	public String ClientNotice() {
		return "client/clientNotice";
	}
	
	@RequestMapping("/clientBoard")//占쏙옙占쏙옙占쌉쏙옙占쏙옙
	public String ClientBoard() {
		return "client/clientBoard";
	}
	
	@RequestMapping("/signUp")//회원가입 페이지
	public String SignUp() {
		return "main/signUp";
	}
	
	//회원가입
	@RequestMapping(value="/insertMember", method=RequestMethod.GET)
	public String insertMember() {
		return "main/main";
	}
	
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public ModelAndView insertMember(HttpServletRequest req,@ModelAttribute MemberDTO dto, @RequestParam Map<String, String> params,@RequestParam(required = false) String[] member_preferred){
		dto.setMember_Tel(params.get("member_tel1")+params.get("member_tel2")+params.get("member_tel3"));	
		if (member_preferred.length>0) {
			dto.setMember_preferred1(member_preferred[0]);
		}else if (member_preferred.length>1) {
			dto.setMember_preferred1(member_preferred[0]);
			dto.setMember_preferred2(member_preferred[1]);
		}else if(member_preferred.length>2) {
			dto.setMember_preferred1(member_preferred[0]);
			dto.setMember_preferred2(member_preferred[1]);
			dto.setMember_preferred3(member_preferred[2]);
		}
		int res = memberMapper.insertMember(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "회원가입 성공!! 메인 페이지로 이동합니다.";
			url = "main/main";
		}else {
			msg = "회원가입 실패!! 회원가입 페이지로 이동합니다.";
			url = "main/signUp";
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
}
