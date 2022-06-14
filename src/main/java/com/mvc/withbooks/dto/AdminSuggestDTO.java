package com.mvc.withbooks.dto;

public class AdminSuggestDTO {
	
	private int sunum;
	private String suggestNovel;
	private NovelDTO novelDTO; //foreign key
	
	
	public int getSunum() {
		return sunum;
	}
	public void setSunum(int sunum) {
		this.sunum = sunum;
	}
	public String getSuggestNovel() {
		return suggestNovel;
	}
	public void setSuggestNovel(String suggestNovel) {
		this.suggestNovel = suggestNovel;
	}
	public NovelDTO getNovelDTO() {
		return novelDTO;
	}
	public void setNovelDTO(NovelDTO novelDTO) {
		this.novelDTO = novelDTO;
	}

	
	
}
