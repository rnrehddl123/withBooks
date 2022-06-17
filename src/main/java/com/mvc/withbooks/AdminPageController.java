package com.mvc.withbooks;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.BoardDTO;
import com.mvc.withbooks.dto.CategoryDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.AdminSlideMapper;
import com.mvc.withbooks.service.AdminSuggestMapper;
import com.mvc.withbooks.service.BoardMapper;
import com.mvc.withbooks.service.CategoryMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeMapper;
import com.mvc.withbooks.service.NovelMapper;

@Controller
public class AdminPageController {
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private AdminSuggestMapper adminSuggestMapper;
	@Autowired
	private AdminSlideMapper adminSlideMapper;
	@Autowired
	private NovelMapper novelMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired 
	private BoardMapper boardMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	@Resource(name="slideUploadPath")
	private String uploadPath;

	@RequestMapping("/homepage")//어드민 페이지 이동
	public String homepage() {
		return "homepage/homepage";
	}
	
	@RequestMapping("/message")//메세지 페이지 이동
	public String message() {
		return "homepage/message";
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.GET)//슬라이드 페이지 이동
	public String slide() {
		return "homepage/admin/banerManage/slide";
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.POST)//슬라이드 등록
	public String slide(HttpServletRequest req, @ModelAttribute AdminSlideDTO dto, 
			BindingResult result) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile mf = mr.getFile("slidet_image");
		String filename = mf.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
	    filename = uuid.toString() + "_" + filename;
		dto.setSlidet_image(filename);
		if (filename != null && !(filename.trim().equals(""))) {
			File file = new File(uploadPath, filename);
			try {
				mf.transferTo(file);
			}catch(IOException e) {}
		}
		int res = adminSlideMapper.insertAdminSlide(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "슬라이드 등록 성공";
			url = "homepage";
		}else {
			msg = "슬라이드 등록 실패";
			url = "slide";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/suggest")//추천작 페이지 이동
	public String suggest(HttpServletRequest req, @RequestParam(required = false) String mode) {
		List<NovelDTO> list = null;
		if(mode == null) {
			list = novelMapper.listNovel();
		}else {
			String searchString = req.getParameter("searchString");
			list = novelMapper.findNovel("Novel_subject", searchString);
		}
		req.setAttribute("listNovel", list);
		List<AdminSuggestDTO> slist = adminSuggestMapper.listAdminSuggest();
		req.setAttribute("listAdminSuggest", slist);
		return "homepage/admin/banerManage/suggest";
	}
	
	@RequestMapping("/InsertSuggest")//추천작 등록
	public String suggest(HttpServletRequest req, @ModelAttribute AdminSuggestDTO dto, int nnum) {
		int res = adminSuggestMapper.insertAdminSuggest(dto, nnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "추천작 입력 성공";
			url = "suggest";
		}else {
			msg = "추천작 입력 실패";
			url = "suggest";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/deleteSuggest")
	public String suggestDelete(HttpServletRequest req, int sunum) {
		int res = adminSuggestMapper.deleteAdminSuggest(sunum);
		String msg = null, url = null;
		if (res>0) {
			msg = "추천작 삭제 성공";
			url = "suggest";
		}else {
			msg = "추천작 삭제 실패";
			url = "suggest";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping(value="/insertCate", method=RequestMethod.GET)//카테고리 페이지 이동
	public String cateInsert() {
		return "homepage/admin/cateManage/cateInsert";
	}
	
	@RequestMapping(value="/insertCate", method=RequestMethod.POST)//카테고리 등록
	public String cateInsert(HttpServletRequest req, @ModelAttribute CategoryDTO dto) {
		int res = categoryMapper.insertCategory(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "카테고리 입력 성공";
			url = "listCate";
		}else {
			msg = "카테고리 입력 실패";
			url = "insertCate";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/listCate")//카테고리 리스트 페이지 이동
	public String cateList(HttpServletRequest req) {
		List<CategoryDTO> list = categoryMapper.listCategory();
		req.setAttribute("listCategory", list);
		return "homepage/admin/cateManage/cateList";
	}
	
	@RequestMapping("/contentBoardAdmin")
	public String boardContent(HttpServletRequest req, int bnum) {
		BoardDTO dto = boardMapper.getBoard(bnum, "admin");
		req.setAttribute("getBoard", dto);
		return "homepage/admin/boardManage/boardContent";
	}
	
	@RequestMapping("/listBoardAdmin")
	public String boardManageList(HttpServletRequest req) {
		List<BoardDTO> list = boardMapper.listBoard();
		req.setAttribute("listBoard", list);
		return "homepage/admin/boardManage/boardList";
	}
	
	@RequestMapping("/deleteBoardAdmin")
	public String adminDeleteBoard(HttpServletRequest req, int bnum) {
		int res = boardMapper.deleteBoardAdmin(bnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "게시글 삭제 성공";
			url = "listBoardAdmin";
		}else {
			msg = "게시글 삭제 실패";
			url = "listBoardAdmin";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/listNotice")
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
		req.setAttribute("listNotice", list);
		return "homepage/admin/noticeManage/noticeList";
	}
	
	@RequestMapping(value="/insertNotice", method=RequestMethod.GET)
	public String noticeInsert() {
		return "homepage/admin/noticeManage/noticeInsert";
	}
	
	@RequestMapping(value="/insertNotice", method=RequestMethod.POST)
	public String noticeInsert(HttpServletRequest req,NoticeDTO dto) {
		int res = noticeMapper.insertNotice(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "공지사항 입력 성공";
			url = "listNotice";
		}else {
			msg = "카테고리 입력 실패";
			url = "insertNotice";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.GET)
	public String noticeUpdate(HttpServletRequest req, int nonum) {
		NoticeDTO dto = noticeMapper.getNotice(nonum, "update");
		req.setAttribute("getNotice", dto);
		return "homepage/admin/noticeManage/noticeUpdate";
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.POST)
	public String noticeUpdate(HttpServletRequest req, NoticeDTO dto) {
		int res = noticeMapper.updateNotice(dto);
		if (res > 0) {
			req.setAttribute("msg", "공지사항 수정 성공");
			req.setAttribute("url", "listNotice");
		}else if (res < 0) {
			req.setAttribute("msg", "공지사항 수정 실패");
			req.setAttribute("url", "updateNotice?nonum=" + dto.getNonum());
		}else {
			req.setAttribute("msg", "공지사항 수정 실패");
			req.setAttribute("url", "contentNotice?nonum=" + dto.getNonum());
		}
		return "forward:message";
	}
	
	@RequestMapping("/deleteNotice")
	public String noticeDelete(HttpServletRequest req, int nonum) {
		int res = noticeMapper.deleteNotice(nonum);
		String msg = null, url = null;
		if (res>0) {
			msg = "공지사항 삭제 성공";
			url = "listNotice";
		}else {
			msg = "공지사항 삭제 실패";
			url = "listNotice";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/contentNotice")
	public String noticeContent(HttpServletRequest req, int nonum) {
		NoticeDTO dto = noticeMapper.getNotice(nonum, "admin");
		req.setAttribute("getNotice", dto);
		return "homepage/admin/noticeManage/noticeContent";
	}
	
	@RequestMapping("/listClient")
	public String clientList(HttpServletRequest req) {
		List<MemberDTO> list = memberMapper.listMember();
		req.setAttribute("listMember", list);
		return "homepage/admin/memberManage/clientList";
	}
	
	@RequestMapping("/deleteMember")
	public String deleteMember(HttpServletRequest req, int mnum) {
		int res = memberMapper.deleteMember(mnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "회원 삭제 성공";
			url = "listClient";
		}else {
			msg = "회원 삭제 실패";
			url = "listClient";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}

	@RequestMapping("/upgradeClient")
	public String clientUpgrade() {
		return "homepage/admin/memberManage/clientUpgrade";
	}
	
	@RequestMapping("/saleManageClient")
	public String saleManageClient() {
		return "homepage/admin/saleManage/saleManageClient";
	}
	
	@RequestMapping("/saleManageWriter")
	public String saleManageWriter() {
		return "homepage/admin/saleManage/saleManageWriter";
	}
	
	@RequestMapping("/saleTotal")
	public String saleTotal() {
		return "homepage/admin/saleManage/saleTotal";
	}

}
