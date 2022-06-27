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
	public String listBoard(HttpServletRequest req,@RequestParam(required = false) String mode) {
		int pageSize = 5;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int rowCount = boardMapper.getBoardCount();
		if (endRow > rowCount) endRow = rowCount;
		List<BoardDTO> list = null;
		int boardNum = 0;
		if (rowCount>0){
			if(mode == null) {
				list = boardMapper.listBoard(startRow, endRow);
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
				list = boardMapper.findBoard("Board_subject", searchString);
			}
		} 
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("boardNum", boardNum);
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
		return "message";
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
		return "message";
	}
	
	//�Խ��� ����
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteFormBoard(HttpServletRequest req, @RequestParam Map<String, String> params) {
		return "board/deleteForm";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteProBoard(HttpServletRequest req, @RequestParam Map<String, String> params) {
		String Bnum = params.get("bnum"); //bnum value를 넣어주어야 한다.
		String passwd = params.get("passwd");
		System.out.println("Bnum: "+Bnum);
		System.out.println("passwd: "+passwd);
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
