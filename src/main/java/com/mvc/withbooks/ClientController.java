package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	
	@RequestMapping("/ClientMyPage")//����������
	public String ClientmyPage() {
		return "/test/login/client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//������������
	public String ClientUpdate() {
		return "/test/login/client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLibrary")//�� ����
	public String ClientLibrary() {
		return "/test/login/client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//��ٱ���
	public String ClientCart() {
		return "/test/login/client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//�ֹ��ϱ�
	public String ClientOrder() {
		return "/test/login/client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//���ų���
	public String ClientOrderList() {
		return "/test/login/client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientNovelSubject")//�Ҽ�����
	public String ClientNovelSubject() {
		return "/test/login/client/clientMypage/clientOrderList/clientNovelSubject";
	}
	
	@RequestMapping("/clientNovelEpi")//���Ǽҵ庸��
	public String ClientNovelEpi() {
		return "/test/login/client/clientMypage/clientOrderList/clientNovelEpi";
	}
	
	@RequestMapping("/clientRequest")//�۰� ��û
	public String ClientNovelRequest() {
		return "/test/login/client/clientMypage/clientRequest";
	}
	
	@RequestMapping("/clientPay")//�����ϱ�
	public String ClientPay() {
		return "/test/login/client/clientMypage/clientPay";
	}
	
	@RequestMapping("/clientNovelInfo")//�Ҽ� ���
	public String ClientNovelInfo() {
		return "/test/login/client/clientNovelInfo";
	}
	
	@RequestMapping("/clientNotice")//��������
	public String ClientNotice() {
		return "/test/login/client/clientNotice";
	}
	
	@RequestMapping("/clientBoard")//�����Խ���
	public String ClientBoard() {
		return "/test/login/client/clientBoard";
	}
}
