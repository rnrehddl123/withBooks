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
import com.google.gson.annotations.JsonAdapter;
import com.mvc.withbooks.dto.HeartDTO;
import com.mvc.withbooks.dto.MemberDTO;
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
		int res = heartMapper.deleteHeart(params);
		return res;
	}
	
	@RequestMapping("/deleteHeartHeart")
	@ResponseBody
	public int deleteHeartHeart(@RequestBody String data){
		Gson gson = new Gson();
		Map<String, Integer> params = gson.fromJson(data, Map.class);
		int res = heartMapper.deleteHeartHeart(params);
		return res;
	}
	
	
	@RequestMapping("/heartList")
	public String heartList(HttpServletRequest req,@RequestParam(required = false) String mode, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:login";
		}
		
		int pageSize = 15;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int rowCount = heartMapper.getHeartCount();
		if (endRow > rowCount) endRow = rowCount;
		List<HeartDTO> list = null;
		int boardNum = 0;
		if (rowCount>0){
			if(mode == null) {
				list = heartMapper.listHeart(startRow, endRow);
				boardNum = rowCount - (startRow - 1);
				if (rowCount>0) {
					int pageCount = rowCount/pageSize + (rowCount%pageSize==0 ? 0 : 1);
					int pageBlock = 3;
					int startPage = (currentPage - 1)/pageBlock  * pageBlock + 1;
					int endPage = startPage + pageBlock - 1;
					if (endPage > pageCount) endPage = pageCount;
					req.setAttribute("pageCount", pageCount);
					req.setAttribute("startPage", startPage);
					req.setAttribute("endPage", endPage);
				}
			}else {
				String searchString = req.getParameter("searchString");
				list = heartMapper.findHeart(searchString);
			}
		} 
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("boardNum", boardNum);
		req.setAttribute("listHeart", list);
		return "client/clientMypage/heartList";
	}
}
