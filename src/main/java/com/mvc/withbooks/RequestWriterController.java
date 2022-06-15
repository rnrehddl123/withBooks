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
	
	//신청 목록
	@RequestMapping("/listRequestWriter")
	public String listRequestWrinte(HttpServletRequest req) {
		List<RequestWriterDTO> list = requestWriterMapper.listRequestWriter();
		req.setAttribute("listRequestWriter", list);
		return "requestWriter/listRequestWriter";
	}
	
	//신청 작성
	@RequestMapping(value = "/writeRequestWriter", method=RequestMethod.GET)
	public String writeFormRequestWriter() {
		return "requestWriter/writeFormRequestWriter";
	}
	
	@RequestMapping(value = "/writeRequestWriter", method=RequestMethod.POST)
	public String writeProRequestWriter(HttpServletRequest req,RequestWriterDTO dto) {
		int res = requestWriterMapper.insertRequestWriter(dto);
		if(res>0) {
			req.setAttribute("msg", "작가 신청 성공! 목록페이지로 이동합니다.");
			req.setAttribute("url", "listRequestWriter");
		}else {
			req.setAttribute("msg", "작가 신청 실패! 신청페이지로 이동합니다.");
			req.setAttribute("url", "writeRequestWriter");
		}
		return "message";
	}
	
	// 신청내용 확인
	@RequestMapping("/contentRequestWriter")
	public String contentRequestWriter(HttpServletRequest req, int Rwnum) {
		RequestWriterDTO dto = requestWriterMapper.getRequestWriter(Rwnum);
		req.setAttribute("getRequestWriter", dto);
		return "requestWriter/contentRequestWriter";
	}
	
	// 신청내용 수정
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
			req.setAttribute("msg", "수정 성공! 목록페이지로 이동합니다.");
			req.setAttribute("url", "listRequestWriter");
		}else {
			req.setAttribute("msg", "수정 실패! 내용 보기 페이지로 이동합니다.");
			req.setAttribute("url", "contentRequestWriter?Rwnum" + dto.getRwnum());
		}
		return "message";
	}
	
	//신청내용 삭제
	
}
