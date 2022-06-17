package com.mvc.withbooks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.PurchaseHistoryDTO;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeNovelMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;


@Controller
public class AjaxController {

	@Autowired
	NoticeNovelMapper noticeNovelMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PurchaseHistoryMapper purchaseHistoryMapper;
	
	@RequestMapping("/setNoticeNovel")
	@ResponseBody
	public int SetNoticeNobel(@RequestBody String data){
		Gson gson = new Gson();
		Map<String, Integer> params = gson.fromJson(data, Map.class);
		int res=noticeNovelMapper.insertNoticeNovel(params);
		return res;
	}
	  
	@RequestMapping("/deleteNoticeNovel")
	@ResponseBody
	public int deleteNoticeNovel(@RequestBody String data){
		Gson gson = new Gson();
		Map<String, Integer> params = gson.fromJson(data, Map.class);
		int res=noticeNovelMapper.deleteNoticeNovel(params);
		return res;
	}
	
	@RequestMapping("/EpisodeOrder")
	public String EpisodeOrder(HttpServletRequest req, @RequestParam Map<String, String> params, HttpSession session, PurchaseHistoryDTO dto) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = memberMapper.purchaseCash(params);
		int res2 = purchaseHistoryMapper.insertPurchase(dto, Integer.parseInt(params.get("mnum")));
		if(res>0) {
			req.setAttribute("msg", "에피소드 구매성공.");
			req.setAttribute("url", "writerEpisodeList?nnum=" + Integer.parseInt(params.get("nnum")));
			MemberDTO login = (MemberDTO)session.getAttribute("login");
			login.setCash(login.getCash() - Integer.parseInt(params.get("cash")));
			session.setAttribute("login", login);
		}else {
			req.setAttribute("msg", "에피소드 구매실패.");
			req.setAttribute("url", "writerEpisodeList?nnum=" + Integer.parseInt(params.get("nnum")));
		}
		return "message";
	}
}

