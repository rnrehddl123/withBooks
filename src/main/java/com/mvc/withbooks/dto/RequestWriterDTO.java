package com.mvc.withbooks.dto;

public class RequestWriterDTO {
	private int Rwnum;
	private String Request_writer;
	private String Request_subject;
	private String Request_reg_date;
	private String Request_content;
	private MemberDTO memberDTO;
	
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public int getRwnum() {
		return Rwnum;
	}
	public void setRwnum(int rwnum) {
		Rwnum = rwnum;
	}
	public String getRequest_writer() {
		return Request_writer;
	}
	public void setRequest_writer(String request_writer) {
		Request_writer = request_writer;
	}
	public String getRequest_subject() {
		return Request_subject;
	}
	public void setRequest_subject(String request_subject) {
		Request_subject = request_subject;
	}
	public String getRequest_reg_date() {
		return Request_reg_date;
	}
	public void setRequest_reg_date(String request_reg_date) {
		Request_reg_date = request_reg_date;
	}
	public String getRequest_content() {
		return Request_content;
	}
	public void setRequest_content(String request_content) {
		Request_content = request_content;
	}
	
	
}
