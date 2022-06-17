package com.mvc.withbooks.dto;

public class PurchaseHistoryDTO {
	private int Phnum;
	private String Purchase_date;
	private int Purchase_price;
	private MemberDTO memberDTO;
	private EpisodeDTO episodeDTO;
	public int getPhnum() {
		return Phnum;
	}
	public void setPhnum(int phnum) {
		Phnum = phnum;
	}
	public String getPurchase_date() {
		return Purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		Purchase_date = purchase_date;
	}
	public int getPurchase_price() {
		return Purchase_price;
	}
	public void setPurchase_price(int purchase_price) {
		Purchase_price = purchase_price;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public EpisodeDTO getEpisodeDTO() {
		return episodeDTO;
	}
	public void setEpisodeDTO(EpisodeDTO episodeDTO) {
		this.episodeDTO = episodeDTO;
	}
	
}
