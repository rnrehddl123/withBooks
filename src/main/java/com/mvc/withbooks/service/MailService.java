package com.mvc.withbooks.service;

import java.util.ArrayList;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	public void sendEmail() throws Exception {
		Email email = new SimpleEmail();
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("withbooks01@naver.com", "!Bigdata01"));
		email.setSSL(true);
		email.setFrom("withbooks01@naver.com", "withbooks01");
		email.setSubject("aaaaaa");
		email.setMsg("aaa");
		email.addTo("zip00901@naver.com", "zip00901");
		email.send();
	}
	
}
