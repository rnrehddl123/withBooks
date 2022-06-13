package com.mvc.withbooks;

import java.util.Map;

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
	
	@RequestMapping("/clientUpdate")//개인정보수정
	public String ClientUpdate() {
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLibrary")//내 서재
	public String ClientLibrary() {
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//장바구니
	public String ClientCart() {
		return "client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//주문하기
	public String ClientOrder() {
		return "client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//구매내역
	public String ClientOrderList() {
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientNovelSubject")//소설보기
	public String ClientNovelSubject() {
		return "client/clientMypage/clientOrderList/clientNovelSubject";
	}
	
	@RequestMapping("/clientNovelEpi")//에피소드보기
	public String ClientNovelEpi() {
		return "client/clientMypage/clientOrderList/clientNovelEpi";
	}
	
	@RequestMapping("/clientRequest")//작가 신청
	public String ClientNovelRequest() {
		return "client/clientMypage/clientRequest";
	}
	
	@RequestMapping("/clientPay")//충전하기
	public String ClientPay() {
		return "client/clientMypage/clientPay";
	}
	
	@RequestMapping("/clientNovelInfo")//소설 요약
	public String ClientNovelInfo() {
		return "client/clientNovelInfo";
	}
	
	@RequestMapping("/clientNotice")//공지사항
	public String ClientNotice() {
		return "client/clientNotice";
	}
	
	@RequestMapping("/clientBoard")//자유게시판
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
	public ModelAndView insertMember(@ModelAttribute MemberDTO dto, @RequestParam Map<String, String> params,String[] member_preferred) {
		dto.setMember_Tel(params.get("member_tel1")+params.get("member_tel2")+params.get("member_tel3"));
		if(member_preferred[0] != null) {
			dto.setMember_preferred1(member_preferred[0]);
		}
		if(member_preferred[1] != null) {
			dto.setMember_preferred2(member_preferred[1]);
		}
		if(member_preferred[2] != null) {
			dto.setMember_preferred3(member_preferred[2]);
		}
		System.out.println(dto.getMember_name());
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
