package com.mvc.withbooks.dto;

public class BoardDTO {
	private int Bnum;
	private String Board_writer;
	private String Board_email;
	private String Board_subject;
	private String Board_passwd;
	private String Board_date;
	private int Board_readcount;
	private String Board_content;
	
	public int getBnum() {
		return Bnum;
	}
	public void setBnum(int bnum) {
		Bnum = bnum;
	}
	public String getBoard_writer() {
		return Board_writer;
	}
	public void setBoard_writer(String board_writer) {
		Board_writer = board_writer;
	}
	public String getBoard_email() {
		return Board_email;
	}
	public void setBoard_email(String board_email) {
		Board_email = board_email;
	}
	public String getBoard_subject() {
		return Board_subject;
	}
	public void setBoard_subject(String board_subject) {
		Board_subject = board_subject;
	}
	public String getBoard_passwd() {
		return Board_passwd;
	}
	public void setBoard_passwd(String board_passwd) {
		Board_passwd = board_passwd;
	}
	public String getBoard_date() {
		return Board_date;
	}
	public void setBoard_date(String board_date) {
		Board_date = board_date;
	}
	public int getBoard_readcount() {
		return Board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		Board_readcount = board_readcount;
	}
	public String getBoard_content() {
		return Board_content;
	}
	public void setBoard_content(String board_content) {
		Board_content = board_content;
	}
	
	
}
