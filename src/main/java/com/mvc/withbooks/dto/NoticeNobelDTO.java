package com.mvc.withbooks.dto;

public class NoticeNobelDTO {
	private int Nnnum;
	private NovelDTO novelDTO;
	private MemberDTO memberDTO;
	private String NoticeTime;
	
	
	public int getNnnum() {
		return Nnnum;
	}
	public void setNnnum(int nnnum) {
		Nnnum = nnnum;
	}
	public NovelDTO getNovelDTO() {
		return novelDTO;
	}
	public void setNovelDTO(NovelDTO novelDTO) {
		this.novelDTO = novelDTO;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public String getNoticeTime() {
		return NoticeTime;
	}
	public void setNoticeTime(String noticeTime) {
		NoticeTime = noticeTime;
	}
	
	
}
