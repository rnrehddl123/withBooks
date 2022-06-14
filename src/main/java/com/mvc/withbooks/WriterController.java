package com.mvc.withbooks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.service.EpisodeMapper;


@Controller
public class WriterController {
	
	@Autowired
	private EpisodeMapper episodeMapper;
	
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
	
	//에피소드 작성 페이지
	@RequestMapping("/writerEpisode")
	public String WriterEpisode() {
		return "writer/writerPage/writerSubject/writerEpisode";
	}
	
	//에피소드 추가
	@RequestMapping(value="/insertEpisode", method=RequestMethod.GET)
	public String insertEpisode() {
		return "main/main";
	}
	
	@RequestMapping(value="/insertEpisode", method=RequestMethod.POST)
	public ModelAndView insertEpisode(@ModelAttribute EpisodeDTO dto, int Nnum) {
		System.out.println(dto.getEpi_subject()+"asdasdasdas");
		int res = episodeMapper.insertEpisode(dto, Nnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 등록 성공, 에피소드 페이지로 이동합니다.";
			url = "writer/writerPage/writerSubject/writerEpisode";
		}else {
			msg = "에피소드 등록 실패!!, 에피소드 페이지로 이동합니다.";
			url = "writer/writerPage/writerSubject/writerEpisode";
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	//에피소드 삭제
	@RequestMapping(value="/deleteEpisode", method=RequestMethod.GET)
	public String deleteEpisode() {
		return "main/main";
	}
	
	@RequestMapping(value="/deleteEpisode", method=RequestMethod.POST)
	public ModelAndView deleteEpisode(@RequestParam int epnum) {
		int res = episodeMapper.deleteEpisode(epnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 삭제 성공, 에피소드 페이지로 이동합니다.";
			url = "writer/writerPage/writerSubject/writerEpisode";
		}else {
			msg = "에피소드 삭제 실패!!, 에피소드 페이지로 이동합니다.";
			url = "writer/writerPage/writerSubject/writerEpisode";
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	//에피소드 수정
	@RequestMapping(value="/updateEpisode", method=RequestMethod.GET)
	public String WriterEpisodeUpdate() {
		return "main/main";
	}
	
	//에피소드 목록
	@RequestMapping("/writerEpisodeList")
	public String WriterEpisodeList() {
		return "writer/writerPage/writerSubject/writerEpisodeList";
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
