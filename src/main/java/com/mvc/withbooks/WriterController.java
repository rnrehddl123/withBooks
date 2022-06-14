package com.mvc.withbooks;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mvc.withbooks.dto.*;
import com.mvc.withbooks.service.EpisodeMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NovelMapper;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.withbooks.dto.EpisodeDTO;

@Controller
public class WriterController {
	
	@Autowired
	private NovelMapper novelMapper;
	
	@Autowired
	private EpisodeMapper episodeMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
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
	
	@RequestMapping("/writerEpisodeList")
	public String WriterEpisodeLIst(HttpServletRequest req) {
		List<EpisodeDTO> list = episodeMapper.listEpisode();
		req.setAttribute("listEpisode", list);
		return "writer/writerPage/writerSubject/writerEpisodeList";
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
	public String insertEpisode(HttpServletRequest req, @ModelAttribute EpisodeDTO dto, int Nnum) {
		System.out.println(dto.getEpi_content());
		int res = episodeMapper.insertEpisode(dto, Nnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 등록 성공, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList";
		}else {
			msg = "에피소드 등록 실패!!, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	//에피소드 삭제
	@RequestMapping("/deleteEpisode")
	public String deleteEpisode(HttpServletRequest req, @RequestParam int epnum) {
		int res = episodeMapper.deleteEpisode(epnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "에피소드 삭제 성공, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList";
		}else {
			msg = "에피소드 삭제 실패!!, 에피소드 목록 페이지로 이동합니다.";
			url = "writerEpisodeList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	//에피소드 수정
	@RequestMapping(value="/updateEpisode", method=RequestMethod.GET)
	public String WriterEpisodeUpdate() {
		return "main/main";
	}
	
	@RequestMapping(value="writerEpisodeUpdate", method=RequestMethod.GET)
	public String WriterEpisodeUpdateForm(HttpServletRequest req, @RequestParam int Epnum) {
		EpisodeDTO dto = episodeMapper.getEpisode(Epnum, "update");
		req.setAttribute("getEpisode", dto);
		return "writer/writerPage/writerSubject/writerEpisodeUpdate";
	}
	
	@RequestMapping(value="writerEpisodeUpdate", method=RequestMethod.POST)
	public String WriterEpisodeUpdate(HttpServletRequest req, @ModelAttribute EpisodeDTO dto) {
		int res = episodeMapper.updateEpisode(dto);
		if(res>0) {
			req.setAttribute("msg", "���Ǽҵ� ���� ����!! ���Ǽҵ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "writerEpisodeList");
		}else {
			req.setAttribute("msg", "���Ǽҵ� ���� ����!! ���Ǽҵ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "writerEpisodeList");
		}
		return "message";
	}
	
	@RequestMapping(value="writerNovel", method=RequestMethod.GET)
	public String WriterNovelForm() {
		return "writer/writerPage/writerSubject/writerNovel";
	}
	
	@RequestMapping(value="writerNovel", method=RequestMethod.POST)
	public String WriterNovel(HttpServletRequest req, @ModelAttribute NovelDTO dto, @RequestParam int mnum) {
		int res = novelMapper.insertNovel(dto,mnum);
		String msg = null, url = null;
		if(res>0) {
			msg = "�Ҽ� ��� ����!! �Ҽ� ��� �������� �̵��մϴ�.";
			url = "writerNovelList";
		}else {
			msg = "�Ҽ� ��� ���� !! �Ҽ� ��� �������� �̵��մϴ�.";
			url = "writerNovelList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@RequestMapping("/writerNovelList")
	public String WriterNovelList(HttpServletRequest req) {
		List<NovelDTO> list = novelMapper.listNovel();
		req.setAttribute("writerListNovel", list);
		return "writer/writerPage/writerSubject/writerNovelList";
	}
	
	@RequestMapping(value="writerNovelUpdate", method=RequestMethod.GET)
	public String WriterNovelUpdateForm(HttpServletRequest req, @RequestParam int nnum) {
		NovelDTO dto = novelMapper.getNovel(nnum);
		req.setAttribute("getNovel", dto);
		return "writer/writerPage/writerSubject/writerNovelUpdate";
	}
	
	@RequestMapping(value="writerNovelUpdate", method=RequestMethod.POST)
	public String WriterNovelUpdate(HttpServletRequest req, @ModelAttribute NovelDTO dto, @RequestParam int mnum) {
		int res = novelMapper.updateNovel(dto,mnum);
		String msg = null, url = null;
		if(res>0) {
			msg = "�Ҽ� ���� ����!! �Ҽ� ��� �������� �̵��մϴ�.";
			url = "writerNovelList";
		}else {
			msg = "�Ҽ� ���� ���� !! �Ҽ� ��� �������� �̵��մϴ�.";
			url = "writerNovelList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@RequestMapping("/writerNoveldelete")
	public String writerNoveldelete(HttpServletRequest req, @RequestParam int nnum) {
		int res = novelMapper.deleteNovel(nnum);
		String msg = null, url = null;
		if(res>0) {
			msg = "�Ҽ� ���� ����!! �Ҽ� ��� �������� �̵��մϴ�.";
			url = "writerNovelList";
		}else {
			msg = "�Ҽ� ���� ���� !! �Ҽ� ��� �������� �̵��մϴ�.";
			url = "writerNovelList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
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
	
}
