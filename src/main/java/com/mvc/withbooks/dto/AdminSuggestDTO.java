package com.mvc.withbooks.dto;

public class AdminSuggestDTO {
	
	private int sunum;
	private String SuggestNovel;
	private NovelDTO novelDTO; //foreign key
	
	
	public int getSunum() {
		return sunum;
	}
	public void setSunum(int sunum) {
		this.sunum = sunum;
	}
	public String getSuggestNovel() {
		return SuggestNovel;
	}
	public void setSuggestNovel(String suggestNovel) {
		SuggestNovel = suggestNovel;
	}
	public NovelDTO getNovelDTO() {
		return novelDTO;
	}
	public void setNovelDTO(NovelDTO novelDTO) {
		this.novelDTO = novelDTO;
	}

	
	
}
