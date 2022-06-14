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
	
	@RequestMapping(value="writerEpisode", method=RequestMethod.GET)
	public String WriterEpisodeForm() {
		return "writer/writerPage/writerSubject/writerEpisode";
	}
	
	@RequestMapping(value="writerEpisode", method=RequestMethod.POST)
	public String WriterEpisode(HttpServletRequest req, @ModelAttribute EpisodeDTO dto) {
		int res = episodeMapper.insertEpisode(dto);
		String msg = null, url = null;
		if(res>0) {
			msg = "���Ǽҵ� ��� ����!! ���Ǽҵ� ��� �������� �̵��մϴ�.";
			url = "writerEpisodeList";
		}else {
			msg = "���Ǽҵ� ��� ���� !! ���Ǽҵ� ��� �������� �̵��մϴ�.";
			url = "writerEpisodeList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@RequestMapping("/writerEpisodeList")
	public String WriterEpisodeLIst(HttpServletRequest req) {
		List<EpisodeDTO> list = episodeMapper.listEpisode();
		req.setAttribute("listEpisode", list);
		return "writer/writerPage/writerSubject/writerEpisodeList";
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
	public String WriterNovelUpdate(HttpServletRequest req, NovelDTO dto) {
		int res = novelMapper.updateNovel(dto);
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
