package com.mvc.withbooks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BoardController {

	
	@RequestMapping("/list_board.do")
	public String listBoard(HttpServletRequest req) {
		return "board/list";
	}
	
	@RequestMapping(value="write_board.do", method=RequestMethod.GET)
	public String writeFormBoard() {
		return "board/writeForm";
	}
	
	@RequestMapping(value="write_board.do", method=RequestMethod.POST)
	public String writeProBoard(HttpServletRequest req) {
		return "message.jsp";
	}
	
	@RequestMapping("/content_board.do")
	public String contentBoard(HttpServletRequest req, @RequestParam int num) {
		return "board/content";
	}
	
	@RequestMapping(value="update_board.do", method=RequestMethod.GET)
	public String updateFormBoard(HttpServletRequest req, @RequestParam int num) {
		return "board/updateForm";
	}
	
	@RequestMapping(value="update_board.do", method=RequestMethod.POST)
	public String updateProBoard(HttpServletRequest req) {
		return "message.jsp";
	}
	
	@RequestMapping(value="delete_board.do", method=RequestMethod.GET)
	public String deleteFormBoard() {
		return "board/deleteForm";
	}
	
	@RequestMapping(value="delete_board.do", method=RequestMethod.POST)
	public String deleteProBoard(HttpServletRequest req, 
								@RequestParam Map<String, String> params) {
		return "message.jsp";
	}
}
