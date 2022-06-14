package com.mvc.withbooks.dto;

public class EpisodeDTO {
	private int Epnum;
	private String Epi_subject;
	private String Epi_content;
	private String Epi_date;
	private int Epi_recommand;
	private int Epi_readcount;
	private NovelDTO novelDTO;
	
	public int getEpnum() {
		return Epnum;
	}
	public void setEpnum(int epnum) {
		Epnum = epnum;
	}
	public String getEpi_subject() {
		return Epi_subject;
	}
	public void setEpi_subject(String epi_subject) {
		Epi_subject = epi_subject;
	}
	public String getEpi_content() {
		return Epi_content;
	}
	public void setEpi_content(String epi_content) {
		Epi_content = epi_content;
	}
	public String getEpi_date() {
		return Epi_date;
	}
	public void setEpi_date(String epi_date) {
		Epi_date = epi_date;
	}
	public int getEpi_recommand() {
		return Epi_recommand;
	}
	public void setEpi_recommand(int epi_recommand) {
		Epi_recommand = epi_recommand;
	}
	public int getEpi_readcount() {
		return Epi_readcount;
	}
	public void setEpi_readcount(int epi_readcount) {
		Epi_readcount = epi_readcount;
	}
	public NovelDTO getNovelDTO() {
		return novelDTO;
	}
	public void setNovelDTO(NovelDTO novelDTO) {
		this.novelDTO = novelDTO;
	}
	
}
