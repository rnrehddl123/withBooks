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
import com.mvc.withbooks.service.NovelMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;
import com.mvc.withbooks.service.ReviewMapper;


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
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private NovelMapper novelMapper;
	
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
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		params.put("mnum", String.valueOf(login.getMnum()));
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
		if(checkList.contains(Integer.parseInt(params.get("epnum")))) {
			params.put("Purchase_price", "0");
		}else {
			params.put("Purchase_price", "100");
		}
		if(login.getCash()<100) {
			req.setAttribute("msg", "보유 포인트가 부족합니다. 포인트 충전 사이트로 이동합니다.");
			req.setAttribute("url", "clientPay");
			return "message";
		}
		Map<String, String> epmap = episodeMapper.contentNoEpisode(Integer.parseInt(params.get("epnum")));
		int res = memberMapper.purchaseCash(params);
		params.put("nnum", String.valueOf(epmap.get("NNUM")));
		params.put("epnum", String.valueOf(epmap.get("EPNUM")));		
		if(checkList.contains(Integer.parseInt(params.get("epnum")))) {
			req.setAttribute("msg", "구매하신 회차입니다. 에피소드 목록으로 돌아갑니다.");
			req.setAttribute("url", "clientNovelInfo?nnum=" + Integer.parseInt(params.get("nnum")));
			login.setCash(login.getCash());
		}else if(res>0) {
			int res2 = purchaseHistoryMapper.insertPurchase(params);
			req.setAttribute("msg", "에피소드 구매성공.");
			req.setAttribute("url", "clientViewer?epnum=" + Integer.parseInt(params.get("epnum")));
			if(login.getCash()>100){
				login.setCash(login.getCash() - Integer.parseInt(params.get("Purchase_price")));
				checkList.add(Integer.parseInt(params.get("epnum")));
				session.setAttribute("checkList", checkList);
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
		Gson gson = new Gson();
		List<EpisodeDTO> elist=(List<EpisodeDTO>) session.getAttribute("eplist");
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
		Map<String, String> mapdata=new HashMap<String, String>();
		int count=-1;
		for(EpisodeDTO dto : elist) {
			count++;
			if (dto.getEpnum()==Integer.parseInt(data)) {
				break;
			}
		}
		try {
			elist.get(count+1).getEpnum();
		} catch (Exception e) {
			mapdata.put("type", "noepi");
			String javadata = gson.toJson(mapdata);
			return javadata;
		}
		mapdata.put("epnum",String.valueOf(elist.get(count+1).getEpnum()));
		if (!checkList.contains(elist.get(count+1).getEpnum())) {
			mapdata.put("type", "Purchase");
			String javadata = gson.toJson(mapdata);
			return javadata;
		}
		mapdata.put("type", "go");
		String javadata = gson.toJson(mapdata);
		return javadata;
	}
	
	@RequestMapping("/checkPrevEpi")
	@ResponseBody
	public String checkPrevEpi(@RequestBody String data,HttpSession session){
		Gson gson = new Gson();
		List<EpisodeDTO> elist=(List<EpisodeDTO>) session.getAttribute("eplist");
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
		Map<String, String> mapdata=new HashMap<String, String>();
		int count=-1;
		for(EpisodeDTO dto : elist) {
			count++;
			if (dto.getEpnum()==Integer.parseInt(data)) {
				break;
			}
		}
		try {
			elist.get(count-1).getEpnum();
		} catch (Exception e) {
			mapdata.put("type", "noepi");
			String javadata = gson.toJson(mapdata);
			return javadata;
		}
		mapdata.put("epnum",String.valueOf(elist.get(count-1).getEpnum()));
		if (!checkList.contains(elist.get(count-1).getEpnum())) {
			mapdata.put("type", "Purchase");
			String javadata = gson.toJson(mapdata);
			return javadata;
		}
		mapdata.put("type", "go");
		String javadata = gson.toJson(mapdata);
		return javadata;
	}
	
	
	@RequestMapping("/selectEpi")
	@ResponseBody
	public String selectEpi(@RequestBody String data,HttpSession session){
		Gson gson = new Gson();
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
		Map<String, String> mapdata=new HashMap<String, String>();
		Map<String, Double> params = gson.fromJson(data, Map.class);
		int epnum=(int)Math.round(params.get("epnum"));
		if(checkList.contains(epnum)) {
			mapdata.put("type", "go");
		}else {
			mapdata.put("type", "Purchase");
		}
		String javadata = gson.toJson(mapdata);
		return javadata;
	}
	
	
	@RequestMapping("/insertReview")
	@ResponseBody
	public String insertReview(@RequestBody String data,HttpSession session){
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		Gson gson = new Gson();
		Map<String, Object> params = gson.fromJson(data, Map.class);
		params.put("mnum",login.getMnum());
		if(reviewMapper.getreview(params)==null) {
			reviewMapper.insertReview(params);
			return "test";
		}
		return "overap";
	}
	
	@RequestMapping("/updateReview")
	@ResponseBody
	public String updateReview(@RequestBody String data,HttpSession session){
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		Gson gson = new Gson();
		Map<String, Object> params = gson.fromJson(data, Map.class);
		params.put("mnum",login.getMnum());
		if(reviewMapper.getreview(params)!=null) {
			params.put("mnum",login.getMnum());
			reviewMapper.updateReview(params);
			return "test";
		}
		return "overap";
	}
	
	
	@RequestMapping("/checkNovelMemberName")
	@ResponseBody
	public String checkNovelMemberName(@RequestBody String data,HttpSession session){
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		Map<String, String> params=new HashMap<String, String>();
		System.out.println(data);
		params.put("Novel_memberName", data);
		params.put("Mnum",String.valueOf(login.getMnum()));
		if(novelMapper.checkNovelMemberName(params)==null) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/idCheck")
	@ResponseBody
	public String idCheck(@RequestBody String member_id){
		int result = memberMapper.idCheck(member_id);
		if(result==1) {
			return "false";
		}
		return "true";
	}
}

