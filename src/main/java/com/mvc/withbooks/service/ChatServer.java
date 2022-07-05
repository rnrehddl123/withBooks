package com.mvc.withbooks.service;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.socket.WebSocketSession;

import com.mvc.withbooks.dto.MemberDTO;

@ServerEndpoint(value = "/chatserver",configurator = HttpSessionConfigurator.class)
public class ChatServer {
	private Map<Object, Object> configs = Collections.synchronizedMap(new HashMap<>());
	private static List<Session> list = new ArrayList<Session>();
	private String userId;
	
	@OnOpen
	public void handleOpen(Session userSession, EndpointConfig config) throws IOException {
		configs.containsKey(userSession);
		HttpSession session = (HttpSession) config.getUserProperties().get(HttpSessionConfigurator.Session);
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		System.out.println(login.getMnum());
		System.out.println(list.size());
		if(session.getAttribute("admin")!=null) {
			list.clear();
			list.add(userSession);
			System.out.println("어드민 로그인");
			userSession.getOpenSessions();
		}else {
			userId=login.getMember_id();
			if(list.size()==1) {
				list.add(userSession);
				userSession.getBasicRemote().sendText(userId+"님 상담이 시작되었습니다.");
			}else {
				userSession.getBasicRemote().sendText(userId+"님현재 상담이 불가능합니다. 잠시후에 이용해주세요.");
			}
		}
	}
	
	@OnMessage
	public void handleMessage(String msg, Session userSession) throws IOException {
		if(list.get(0)==userSession) {
			list.get(1).getBasicRemote().sendText("관리자 : "+msg);
		}else {
			list.get(0).getBasicRemote().sendText(userId+" : "+msg);
		}
	}
	
	@OnClose
	public void handleClose() {
		System.out.println("테스트 닫힘");
	}
	
	@OnError
	public void handleError(Throwable t) {
		
	}

}