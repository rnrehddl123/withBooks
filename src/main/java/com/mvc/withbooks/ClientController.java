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
	
	@RequestMapping("/clientMypage")//����������
	public String ClientmyPage() {
		return "client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//������������
	public String ClientUpdate() {
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLibrary")//�� ����
	public String ClientLibrary() {
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//��ٱ���
	public String ClientCart() {
		return "client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//�ֹ��ϱ�
	public String ClientOrder() {
		return "client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//���ų���
	public String ClientOrderList() {
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientNovelSubject")//�Ҽ�����
	public String ClientNovelSubject() {
		return "client/clientMypage/clientOrderList/clientNovelSubject";
	}
	
	@RequestMapping("/clientNovelEpi")//���Ǽҵ庸��
	public String ClientNovelEpi() {
		return "client/clientMypage/clientOrderList/clientNovelEpi";
	}
	
	@RequestMapping("/clientRequest")//�۰� ��û
	public String ClientNovelRequest() {
		return "client/clientMypage/clientRequest";
	}
	
	@RequestMapping("/clientPay")//�����ϱ�
	public String ClientPay() {
		return "client/clientMypage/clientPay";
	}
	
	@RequestMapping("/clientNovelInfo")//�Ҽ� ���
	public String ClientNovelInfo() {
		return "client/clientNovelInfo";
	}
	
	@RequestMapping("/clientNotice")//��������
	public String ClientNotice() {
		return "client/clientNotice";
	}
	
	@RequestMapping("/clientBoard")//�����Խ���
	public String ClientBoard() {
		return "client/clientBoard";
	}
	
	@RequestMapping("/signUp")//ȸ������ ������
	public String SignUp() {
		return "main/signUp";
	}
	
	//ȸ������
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
			msg = "ȸ������ ����!! ���� �������� �̵��մϴ�.";
			url = "main/main";
		}else {
			msg = "ȸ������ ����!! ȸ������ �������� �̵��մϴ�.";
			url = "main/signUp";
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
}
