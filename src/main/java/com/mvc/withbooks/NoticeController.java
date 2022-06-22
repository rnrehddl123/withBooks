package com.mvc.withbooks;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.CategoryDTO;
import com.mvc.withbooks.dto.NoticeDTO;
import com.mvc.withbooks.service.NoticeMapper;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@RequestMapping("/NlistNotice")	//footer와 연결
	public String noticeList(HttpServletRequest req, @RequestParam(required = false) String mode) {
		int pageSize = 5;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int rowCount = noticeMapper.getNoticeCount();
		if (endRow > rowCount) endRow = rowCount;
		List<NoticeDTO> list = null;
		int noticeNum = 0;
		if (rowCount>0){
			if(mode == null) {
				list = noticeMapper.listNotice(startRow, endRow);
				noticeNum = rowCount - (startRow - 1);
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
				list = noticeMapper.findNotice("Notice_title", searchString);
			}
		} 
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("noticeNum", noticeNum);
		req.setAttribute("NlistNotice", list);
		return "notice/noticeList";
	}
	
	
	@RequestMapping("/NcontentNotice") //noticeContent.jsp
	public String noticeContent(HttpServletRequest req, int nonum) {
		NoticeDTO dto = noticeMapper.getNotice(nonum, "content");
		req.setAttribute("getNotice", dto);
		return "notice/noticeContent";
	}
	
	
}
