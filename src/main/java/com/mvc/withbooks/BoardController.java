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
	
	// �Խ��� ��� 
	@RequestMapping("/listBoard")
	public String listBoard(HttpServletRequest req) {
		List<BoardDTO> list = boardMapper.listBoard();
		req.setAttribute("listBoard", list);
		return "board/list";
	}
	
	// �Խ��� �ۼ� (������ �̵�)
	@RequestMapping(value="/writeBoard", method=RequestMethod.GET)
	public String writeFormBoard() {
		return "board/writeForm";
	}
	
	// �Խ��� �۵� Ȯ��&�޼���
	@RequestMapping(value="/writeBoard", method=RequestMethod.POST)
	public String writeProBoard(HttpServletRequest req, BoardDTO dto) {
		int res = boardMapper.insertBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "�Խñ� ��� ����! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "listBoard");
		}else {
			req.setAttribute("msg", "�Խñ� ��� ����! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "writeBoard");
		}
		return "message.jsp";
	}
	
	// �Խ��� ��� ������ �ش� �ۼ������� �̵�
	@RequestMapping("/contentBoard")
	public String contentBoard(HttpServletRequest req, @RequestParam int Bnum) {
		BoardDTO dto = boardMapper.getBoard(Bnum, "content");
		req.setAttribute("getBoard", dto);
		return "board/content";
	}
	
	//�Խ��� ������Ʈ
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
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "listBoard");
		}else if (res < 0) {
			req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���.");
			req.setAttribute("url", "updateBoard?Bnum=" + dto.getBnum());
		}else {
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ������������ �̵��մϴ�.");
			req.setAttribute("url", "contentBoard?Bnum=" + dto.getBnum());
		}
		return "message.jsp";
	}
	
	//�Խ��� ����
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
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ����������� �̵��մϴ�.");
			req.setAttribute("url", "listBoard");
		}else if (res < 0) {
			req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���.");
			req.setAttribute("url", "deleteBoard?Bnum=" + Bnum);
		}else {
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ������������ �̵��մϴ�.");
			req.setAttribute("url", "contentBoard?Bnum=" + Bnum);
		}
		return "message.jsp";
	}
}
