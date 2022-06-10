package com.mvc.withbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WriterController {
	
	
	@RequestMapping("/writerOrderList")
	public String WriterOrderList() {
		return "writer/writerPage/writerOrderList";
	}
	
	
	@RequestMapping("/writerNovelEpisode")
	public String WriterNovelEpisode() {
		return "writer/writerPage/writerOrderList/writerNovelEpisode";
	}
	
	@RequestMapping("/writerNovelSubject")
	public String WriterNovelSubject() {
		return "writer/writerPage/writerOrderList/writerNovelSubject";
	}
	
	@RequestMapping("/writerEpisode")
	public String WriterEpisode() {
		return "writer/writerPage/writerSubject/writerEpisode";
	}
	
	@RequestMapping("/writerEpisodeList")
	public String WriterEpisodeLIst() {
		return "writer/writerPage/writerSubject/writerEpisodeList";
	}
	
	@RequestMapping("/writerEpisodeUpdate")
	public String WriterEpisodeUpdate() {
		return "writer/writerPage/writerSubject/writerEpisodeUpdate";
	}
	
	@RequestMapping("/writerNovel")
	public String WriterNovel() {
		return "writer/writerPage/writerSubject/writerNovel";
	}
	
	@RequestMapping("/writerNovelList")
	public String WriterNovelList() {
		return "writer/writerPage/writerSubject/writerNovelList";
	}
	
	@RequestMapping("/writerNovelUpdate")
	public String WriterNovelUpdate() {
		return "writer/writerPage/writerSubject/writerNovelUpdate";
	}
	
	@RequestMapping("/writerChart")
	public String WriterChart() {
		return "writer/writerPage/writerChart";
	}
	
	@RequestMapping("/writerLibrary")
	public String WriterLibrary() {
		return "writer/writerPage/writerLibrary";
	}
	
	@RequestMapping("/writerPay")
	public String WriterPay() {
		return "writer/writerPage/writerPay";
	}
	
	@RequestMapping("/writerUpdate")
	public String WriterUpdate() {
		return "writer/writerPage/writerUpdate";
	}
	
	@RequestMapping("/writerSubject")
	public String WriterSubject() {
		return "writer/writerPage/writerSubject";
	}
}
