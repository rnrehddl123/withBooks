package com.mvc.withbooks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NovelMapper;

@Controller
public class AdminChartController {
	@Autowired
	private NovelMapper novelMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	
	@RequestMapping("/adminChartajax")
	@ResponseBody
	public String SetNoticeNobel(@RequestBody String data){
		System.out.println(data);
		Gson gson = new Gson();
		Map<String, String> params = gson.fromJson(data, Map.class);
		Map<String, String> mapdata=new HashMap<String, String>();
		mapdata.put("type", "go");
		mapdata.put("asd", "asd");
		String javadata = gson.toJson(mapdata);
		System.out.println(javadata);
		return javadata;
	}
	
	@RequestMapping("/adminChart")
	public String adminChart(){
		return "homepage/admin/chart";
	}
	
	@RequestMapping("/adminNoChart")
	@ResponseBody
	public String adminNoChart(){
		Gson gson = new Gson();
		List<MemberDTO> list=memberMapper.listMember(1, 40);
		String javadata=gson.toJson(list);
		System.out.println(javadata);
		return javadata;
	}
}
