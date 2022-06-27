package com.mvc.withbooks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.RequestWriterDTO;
import com.mvc.withbooks.service.RequestWriterMapper;

@Controller
public class RequestWriterController {
	
	@Autowired
	private RequestWriterMapper requestWriterMapper;
	
	//��û ���
	@RequestMapping("/listRequestWriter")
	public String listRequestWrinte(HttpServletRequest req,@RequestParam(required = false) String mode) {
		int pageSize = 5;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int rowCount = requestWriterMapper.getRequestWriterCount();
		if (endRow > rowCount) endRow = rowCount;
		List<RequestWriterDTO> list = null;
		int requestWriterNum = 0;
		if (rowCount>0){
			if(mode == null) {
				list = requestWriterMapper.listRequestWriter(startRow, endRow);
				requestWriterNum = rowCount - (startRow - 1);
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
				list = requestWriterMapper.findRequestWriter("RequestWriter_writer", searchString, startRow, endRow);
			}
		} 
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("requestWriterNum", requestWriterNum);
		req.setAttribute("listRequestWriter", list);
		return "requestWriter/listRequestWriter";
	}
	
	//��û �ۼ�
	@RequestMapping(value = "/writeRequestWriter", method=RequestMethod.GET)
	public String writeFormRequestWriter() {
		return "requestWriter/writeFormRequestWriter";
	}
	
	@RequestMapping(value = "/writeRequestWriter", method=RequestMethod.POST)
	public String writeProRequestWriter(HttpServletRequest req,RequestWriterDTO dto, @RequestParam int mnum) {
		int res = requestWriterMapper.insertRequestWriter(dto,mnum);
		if(res>0) {
			req.setAttribute("msg", "작가 신청 성공");
			req.setAttribute("url", "listRequestWriter");
		}else {
			req.setAttribute("msg", "작가 신청 실패");
			req.setAttribute("url", "writeRequestWriter");
		}
		return "message";
	}
	
	// ��û���� Ȯ��
	@RequestMapping("/contentRequestWriter")
	public String contentRequestWriter(HttpServletRequest req, int Rwnum) {
		RequestWriterDTO dto = requestWriterMapper.getRequestWriter(Rwnum);
		req.setAttribute("getRequestWriter", dto);
		return "requestWriter/contentRequestWriter";
	}
	
	// ��û���� ����
	@RequestMapping(value = "/updateRequestWriter", method = RequestMethod.GET)
	public String updateFormRequestWrinter(HttpServletRequest req,int Rwnum) {
		RequestWriterDTO dto = requestWriterMapper.getRequestWriter(Rwnum);
		req.setAttribute("getRequestWriter", dto);
		return "requestWriter/updateRequestWriter";
	}
	
	@RequestMapping(value = "updateRequestWriter", method = RequestMethod.POST)
	public String updateProRequestWrinter(HttpServletRequest req,RequestWriterDTO dto) {
		int res = requestWriterMapper.updateRequestWriter(dto);
		if(res>0) {
			req.setAttribute("msg", "수정 성공");
			req.setAttribute("url", "listRequestWriter");
		}else {
			req.setAttribute("msg", "수정 실패");
			req.setAttribute("url", "contentRequestWriter?Rwnum" + dto.getRwnum());
		}
		return "message";
	}
	
	//��û���� ����
	
}
