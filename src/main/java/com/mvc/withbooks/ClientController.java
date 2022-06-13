package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	
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
	
	@RequestMapping("/clientViewer")//���Ǽҵ庸��
	public String ClientViewer() {
		return "client/clientViewer";
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
}
