package com.mvc.withbooks.dto;

public class HeartDTO {
	private int Hnum;
	private NovelDTO novelDTO;
	private MemberDTO memberDTO;
	private String heart_regDate;

	public int getHnum() {
		return Hnum;
	}
	public void setHnum(int hnum) {
		Hnum = hnum;
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
	public String getHeart_regDate() {
		return heart_regDate;
	}
	public void setHeart_regDate(String heart_regDate) {
		this.heart_regDate = heart_regDate;
	}
	
	
	
	
	
}
