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
	public String listRequestWrinte(HttpServletRequest req) {
		List<RequestWriterDTO> list = requestWriterMapper.listRequestWriter();
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
			req.setAttribute("msg", "�۰� ��û ����! ����������� �̵��մϴ�.");
			req.setAttribute("url", "listRequestWriter");
		}else {
			req.setAttribute("msg", "�۰� ��û ����! ��û�������� �̵��մϴ�.");
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
			req.setAttribute("msg", "���� ����! ����������� �̵��մϴ�.");
			req.setAttribute("url", "listRequestWriter");
		}else {
			req.setAttribute("msg", "���� ����! ���� ���� �������� �̵��մϴ�.");
			req.setAttribute("url", "contentRequestWriter?Rwnum" + dto.getRwnum());
		}
		return "message";
	}
	
	//��û���� ����
	
}
