package com.mvc.withbooks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvc.withbooks.service.NoticeNovelMapper;


@Controller
public class AjaxController {

	@Autowired
	NoticeNovelMapper noticeNovelMapper;
	
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
}

