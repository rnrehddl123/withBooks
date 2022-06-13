package com.mvc.withbooks.dto;

public class NovelDTO {
	private int Nnum;
	private String Novel_subject;
	private String Novel_memberName;
	private String Novel_image;
	private String Novel_cate;
	private String Novel_summary;
	private int Novel_recommand;
	private MemberDTO memberDTO;
	
	public int getNnum() {
		return Nnum;
	}
	public void setNnum(int nnum) {
		Nnum = nnum;
	}
	public String getNovel_subject() {
		return Novel_subject;
	}
	public void setNovel_subject(String novel_subject) {
		Novel_subject = novel_subject;
	}
	public String getNovel_memberName() {
		return Novel_memberName;
	}
	public void setNovel_memberName(String novel_memberName) {
		Novel_memberName = novel_memberName;
	}
	public String getNovel_image() {
		return Novel_image;
	}
	public void setNovel_image(String novel_image) {
		Novel_image = novel_image;
	}
	public String getNovel_cate() {
		return Novel_cate;
	}
	public void setNovel_cate(String novel_cate) {
		Novel_cate = novel_cate;
	}
	public String getNovel_summary() {
		return Novel_summary;
	}
	public void setNovel_summary(String novel_summary) {
		Novel_summary = novel_summary;
	}
	public int getNovel_recommand() {
		return Novel_recommand;
	}
	public void setNovel_recommand(int novel_recommand) {
		Novel_recommand = novel_recommand;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	
	
}
