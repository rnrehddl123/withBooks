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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvc.withbooks.service.NoticeEpisodeMapper;
import com.mvc.withbooks.service.NoticeNovelMapper;


@Controller
public class AjaxController {

	@Autowired
	NoticeNovelMapper noticeNovelMapper;
	@Autowired
	NoticeEpisodeMapper noticeEpisodeMapper;
	
	
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
}

