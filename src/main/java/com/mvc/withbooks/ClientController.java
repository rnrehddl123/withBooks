package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	
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
}
