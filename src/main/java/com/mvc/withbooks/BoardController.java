package com.mvc.withbooks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.BoardDTO;
import com.mvc.withbooks.service.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 게시판 목록 
	@RequestMapping("/listBoard")
	public String listBoard(HttpServletRequest req) {
		List<BoardDTO> list = boardMapper.listBoard();
		req.setAttribute("listBoard", list);
		return "board/list";
	}
	
	// 게시판 작성 (페이지 이동)
	@RequestMapping(value="/writeBoard", method=RequestMethod.GET)
	public String writeFormBoard() {
		return "board/writeForm";
	}
	
	// 게시판 작동 확인&메세지
	@RequestMapping(value="/writeBoard", method=RequestMethod.POST)
	public String writeProBoard(HttpServletRequest req, BoardDTO dto) {
		int res = boardMapper.insertBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "게시글 등록 성공! 게시글 목록페이지로 이동합니다.");
			req.setAttribute("url", "listBoard");
		}else {
			req.setAttribute("msg", "게시글 등록 실패! 게시글 등록페이지로 이동합니다.");
			req.setAttribute("url", "writeBoard");
		}
		return "message.jsp";
	}
	
	// 게시판 목록 누르면 해당 작성쪽으로 이동
	@RequestMapping("/contentBoard")
	public String contentBoard(HttpServletRequest req, @RequestParam int Bnum) {
		BoardDTO dto = boardMapper.getBoard(Bnum, "content");
		req.setAttribute("getBoard", dto);
		return "board/content";
	}
	
	//게시판 업데이트
	@RequestMapping(value="/updateBoard", method=RequestMethod.GET)
	public String updateFormBoard(HttpServletRequest req, @RequestParam int Bnum) {
		BoardDTO dto = boardMapper.getBoard(Bnum, "update");
		req.setAttribute("getBoard", dto);
		return "board/updateForm";
	}
	
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateProBoard(HttpServletRequest req, BoardDTO dto) {
		int res = boardMapper.updateBoard(dto);
		if (res > 0) {
			req.setAttribute("msg", "게시글 수정 성공!! 게시글 목록페이지로 이동합니다.");
			req.setAttribute("url", "listBoard");
		}else if (res < 0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요.");
			req.setAttribute("url", "updateBoard?Bnum=" + dto.getBnum());
		}else {
			req.setAttribute("msg", "게시글 수정 실패!! 게시글 보기페이지로 이동합니다.");
			req.setAttribute("url", "contentBoard?Bnum=" + dto.getBnum());
		}
		return "message.jsp";
	}
	
	//게시판 삭제
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteFormBoard(HttpServletRequest req, @RequestParam Map<String, String> params) {
		return "board/deleteForm";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteProBoard(HttpServletRequest req,@RequestParam Map<String, String> params) {
		String Bnum = params.get("Bnum");
		String passwd = params.get("passwd");
		int res = boardMapper.deleteBoard(Integer.parseInt(Bnum), passwd);
		if (res > 0) {
			req.setAttribute("msg", "게시글 삭제 성공!! 게시글 목록페이지로 이동합니다.");
			req.setAttribute("url", "listBoard");
		}else if (res < 0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요.");
			req.setAttribute("url", "deleteBoard?Bnum=" + Bnum);
		}else {
			req.setAttribute("msg", "게시글 삭제 실패!! 게시글 보기페이지로 이동합니다.");
			req.setAttribute("url", "contentBoard?Bnum=" + Bnum);
		}
		return "message.jsp";
	}
}
