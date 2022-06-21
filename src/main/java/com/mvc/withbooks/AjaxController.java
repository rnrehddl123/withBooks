package com.mvc.withbooks;

import java.util.HashMap;
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
import com.mvc.withbooks.service.NoticeEpisodeMapper;
import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.PurchaseHistoryDTO;
import com.mvc.withbooks.service.EpisodeMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeNovelMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;


@Controller
public class AjaxController {

	@Autowired
	private NoticeNovelMapper noticeNovelMapper;
	@Autowired
	private NoticeEpisodeMapper noticeEpisodeMapper;
	@Autowired
	private EpisodeMapper episodeMapper;
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
	
	@RequestMapping("/deleteNoticeEpisode")
	@ResponseBody
	public int deleteNoticeEpisode(@RequestBody String data,HttpSession session){
		Gson gson = new Gson();
		Map<String, Integer> params = gson.fromJson(data, Map.class);
		int res=noticeEpisodeMapper.deleteNoticeEpisode(params);
		List<HashMap<String, String>> list=(List<HashMap<String, String>>) session.getAttribute("noticeList");
		for(HashMap<String, String> map: list) {
			if(map.get("NENUM")!=null) {
				if ((String.valueOf(map.get("NENUM"))+".0").equals(String.valueOf(params.get("nenum")))){
					list.remove(map);
					break;
				}
			}	
		}
		session.setAttribute("noticeList", list);
		return res;
	}
	
	@RequestMapping("/EpisodeOrder")
	public String EpisodeOrder(HttpServletRequest req, @RequestParam Map<String, String> params, HttpSession session, PurchaseHistoryDTO dto) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		Map<String, String> epmap = episodeMapper.contentNoEpisode(Integer.parseInt(params.get("epnum")));
		int res = memberMapper.purchaseCash(params);
		params.put("nnum", String.valueOf(epmap.get("NNUM")));
		params.put("epnum", String.valueOf(epmap.get("EPNUM")));
		int res2 = purchaseHistoryMapper.insertPurchase(params);
		if(res>0) {
			req.setAttribute("msg", "에피소드 구매성공.");
			req.setAttribute("url", "clientViewer?epnum=" + Integer.parseInt(params.get("epnum")));
			MemberDTO login = (MemberDTO)session.getAttribute("login");
			if(login.getCash()>0){
				login.setCash(login.getCash() - Integer.parseInt(params.get("Purchase_price")));
				session.setAttribute("login", login);
			}else {
				req.setAttribute("msg", "보유 포인트가 부족합니다. 포인트 충전 사이트로 이동합니다.");
				req.setAttribute("url", "clientPay");
			}
		}else {
			req.setAttribute("msg", "에피소드 구매실패.");
			req.setAttribute("url", "writerEpisodeList?nnum=" + Integer.parseInt(params.get("nnum")));
		}
		return "message";
	}
	
	
	@RequestMapping("/checkNextEpi")
	@ResponseBody
	public String checkNextEpi(@RequestBody String data,HttpSession session){
		List<EpisodeDTO> elist=(List<EpisodeDTO>) session.getAttribute("elist");
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
//		if (!checkList.contains(data)) {
//			return "Purchase";
//		}
		int count=-1;
		for(EpisodeDTO dto : elist) {
			count++;
			if (dto.getEpnum()==Integer.parseInt(data)) {
				break;
			}
		}
		if(count<0) {
			return "noepi";
		}
		try {
			elist.get(count+1).getEpnum();
		} catch (Exception e) {
			return "noepi";
		}
		return String.valueOf(elist.get(count+1).getEpnum());
	}
	
	@RequestMapping("/checkPrevEpi")
	@ResponseBody
	public String checkPrevEpi(@RequestBody String data,HttpSession session){
		List<EpisodeDTO> elist=(List<EpisodeDTO>) session.getAttribute("elist");
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
//		if (!checkList.contains(data)) {
//			return "Purchase";
//		}
		int count=-1;
		for(EpisodeDTO dto : elist) {
			count++;
			if (dto.getEpnum()==Integer.parseInt(data)) {
				break;
			}
		}
		if(count<1) {
			return "noepi";
		}
		return String.valueOf(elist.get(count-1).getEpnum());
	}
}

