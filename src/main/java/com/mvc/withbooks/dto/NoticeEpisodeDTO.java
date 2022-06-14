package com.mvc.withbooks.dto;

public class NoticeEpisodeDTO {
	private int Nenum;
	private String SendTime;
	private String ReadTime;
	private EpisodeDTO episodeDTO;
	private MemberDTO memberDTO;
	
	public int getNenum() {
		return Nenum;
	}
	public void setNenum(int nenum) {
		Nenum = nenum;
	}
	public String getSendTime() {
		return SendTime;
	}
	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}
	public String getReadTime() {
		return ReadTime;
	}
	public void setReadTime(String readTime) {
		ReadTime = readTime;
	}
	public EpisodeDTO getEpisodeDTO() {
		return episodeDTO;
	}
	public void setEpisodeDTO(EpisodeDTO episodeDTO) {
		this.episodeDTO = episodeDTO;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
}
