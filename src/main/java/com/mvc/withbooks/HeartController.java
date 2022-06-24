package com.mvc.withbooks;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvc.withbooks.service.HeartMapper;
import com.mvc.withbooks.service.MemberMapper;

@Controller
public class HeartController {
	
	@Autowired
	private HeartMapper heartMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	@RequestMapping("/setHeart")
	@ResponseBody
	public int SetHeart(@RequestBody String data){
		Gson gson = new Gson();
		Map<String, Integer> params = gson.fromJson(data, Map.class);
		int res=heartMapper.insertHeart(params);
		return res;
	}
	
	@RequestMapping("/deleteHeart")
	@ResponseBody
	public int deleteHeart(@RequestBody String data){
		Gson gson = new Gson();
		Map<String, Integer> params = gson.fromJson(data, Map.class);
		int res=heartMapper.deleteHeart(params);
		return res;
	}
}
