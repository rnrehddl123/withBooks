package com.mvc.withbooks.dto;

public class ReviewDTO {
	private int Rnum;
	private MemberDTO memberDTO;
	private NovelDTO novelDTO;
	private String Content;
	private int Score;
	private String Review_Date;
	
	
	public int getRnum() {
		return Rnum;
	}
	public void setRnum(int rnum) {
		Rnum = rnum;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public NovelDTO getNovelDTO() {
		return novelDTO;
	}
	public void setNovelDTO(NovelDTO novelDTO) {
		this.novelDTO = novelDTO;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public String getReview_Date() {
		return Review_Date;
	}
	public void setReview_Date(String review_Date) {
		Review_Date = review_Date;
	}
}
