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
	
	@RequestMapping("/clientMypage")//留덉씠�럹�씠吏�
	public String ClientmyPage() {
		return "client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
	public String ClientUpdate() {
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLibrary")//�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
	public String ClientLibrary() {
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//�뜝�룞�삕熬귛뜝�룞�삕�뜝占�
	public String ClientCart() {
		return "client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//�뜝�뙇諭꾩삕�뜝�떦源띿삕
	public String ClientOrder() {
		return "client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//�뜝�룞�삕�뜝�떊�냲�삕�뜝�룞�삕
	public String ClientOrderList() {
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientNovelSubject")//�뜝���눦�삕�뜝�룞�삕�뜝�룞�삕
	public String ClientNovelSubject() {
		return "client/clientMypage/clientOrderList/clientNovelSubject";
	}
	
	@RequestMapping("/clientNovelEpi")//�뜝�룞�삕�뜝�떎�냼�뱶蹂닷뜝�룞�삕
	public String ClientNovelEpi() {
		return "client/clientMypage/clientOrderList/clientNovelEpi";
	}
	
	@RequestMapping("/clientViewer")//�뜝�룞�삕�뜝�떎�냼�뱶蹂닷뜝�룞�삕
	public String ClientViewer() {
		return "client/clientViewer";
	}
	
	
	@RequestMapping("/clientRequest")//�뜝�뙗怨ㅼ삕 �뜝�룞�삕泥�
	public String ClientNovelRequest() {
		return "client/clientMypage/clientRequest";
	}
	
	@RequestMapping("/clientPay")//�뜝�룞�삕�뜝�룞�삕�뜝�떦源띿삕
	public String ClientPay() {
		return "client/clientMypage/clientPay";
	}
	
	@RequestMapping("/clientNovelInfo")//�뜝���눦�삕 �뜝�룞�삕�뜝占�
	public String ClientNovelInfo() {
		return "client/clientNovelInfo";
	}
	
	@RequestMapping("/clientNotice")//�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
	public String ClientNotice() {
		return "client/clientNotice";
	}
	
	@RequestMapping("/clientBoard")//�뜝�룞�삕�뜝�룞�삕�뜝�뙃�룞�삕�뜝�룞�삕
	public String ClientBoard() {
		return "client/clientBoard";
	}
	
	@RequestMapping("/signUp")//�쉶�썝媛��엯 �럹�씠吏�
	public String SignUp() {
		return "main/signUp";
	}
	
	//�쉶�썝媛��엯
	@RequestMapping(value="/insertMember", method=RequestMethod.GET)
	public String insertMember() {
		return "main/main";
	}
	
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public ModelAndView insertMember(HttpServletRequest req, @ModelAttribute MemberDTO dto, @RequestParam Map<String, String> params,@RequestParam(required = false) String[] member_preferred){
		dto.setMember_Tel(params.get("member_tel1")+params.get("member_tel2")+params.get("member_tel3"));	
		if (member_preferred.length>0) {
			dto.setMember_preferred1(member_preferred[0]);
		}
		if (member_preferred.length>1) {
			dto.setMember_preferred2(member_preferred[1]);
		}
		if (member_preferred.length>2) {
			dto.setMember_preferred3(member_preferred[2]);
		}
		int res = memberMapper.insertMember(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "�쉶�썝媛��엯 �꽦怨�!! 硫붿씤 �럹�씠吏�濡� �씠�룞�빀�땲�떎.";
			url = "main/main";
		}else {
			msg = "�쉶�썝媛��엯 �떎�뙣!! �쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞�빀�땲�떎.";
			url = "main/signUp";
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
}
