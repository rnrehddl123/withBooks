package com.mvc.withbooks;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.mvc.withbooks.dto.PayDTO;
import com.mvc.withbooks.dto.RequestWriterDTO;
import com.mvc.withbooks.service.AdminSlideMapper;
import com.mvc.withbooks.service.AdminSuggestMapper;
import com.mvc.withbooks.service.BoardMapper;
import com.mvc.withbooks.service.CategoryMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeMapper;
import com.mvc.withbooks.service.NovelMapper;
import com.mvc.withbooks.service.PayMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;
import com.mvc.withbooks.service.RequestWriterMapper;

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
	@Autowired
	private RequestWriterMapper requestWriterMapper;
	@Autowired
	private PayMapper payMapper;
	@Autowired
	private PurchaseHistoryMapper purchaseHistoryMapper;
	
	@Resource(name="slideUploadPath")
	private String uploadPath;
	
	@RequestMapping("/homepage")//어드민 페이지 이동
	public String homepage(HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			return "homepage/homepage";	
		} else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping(value="/adminLogin", method=RequestMethod.GET)//어드민 로그인 페이지 이동
	public String adminLogin() {
		return "homepage/adminLogin";
	}
	
	@RequestMapping(value="/adminLogin", method=RequestMethod.POST)//어드민 로그인 페이지 이동
	public String adminPostLogin(String Admin_id,String Admin_passwd,HttpSession session) {
		if(Admin_id.equals("admin")&&Admin_passwd.equals("qwe")) {
			session.setAttribute("admin", "admin");
			System.out.println("asas");
			return "redirect:/homepage";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/message")//메세지 페이지 이동
	public String message() {
		return "homepage/message";
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.GET)//슬라이드 페이지 이동
	public String slide(HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			return "homepage/admin/banerManage/slide";
		}else {
			return "redirect:/adminLogin";
		}
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
	
	@RequestMapping("/listSuggest")//추천작 리스트 페이지 이동
	public String listSuggest(HttpServletRequest req, @RequestParam(required = false) String mode, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			String searchString = req.getParameter("searchString");
			int pageSize = 20;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = 0;
			if (mode == null)
				rowCount = adminSuggestMapper.getSuggestCount();
			else
				rowCount = adminSuggestMapper.getSuggestSearchCount("suggestNovel", searchString);
			if (endRow > rowCount)
				endRow = rowCount;
			List<AdminSuggestDTO> list = null;
			int suggestNum = 0;
			if (rowCount > 0) {
				if (mode == null) {
					list = adminSuggestMapper.listAdminSuggest(startRow, endRow);
					suggestNum = rowCount - (startRow - 1);
					if (rowCount > 0) {
						int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
						int pageBlock = 3;
						int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
						int endPage = startPage + pageBlock - 1;
						if (endPage > pageCount)
							endPage = pageCount;
						req.setAttribute("pageCount", pageCount);
						req.setAttribute("startPage", startPage);
						req.setAttribute("endPage", endPage);
					}
				} else {
					list = adminSuggestMapper.findAdminSuggest("suggestNovel", searchString);
				}
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("suggestNum", suggestNum);
			req.setAttribute("listAdminSuggest", list);
			return "homepage/admin/banerManage/suggestList";
		}else {
			return "redirect:/adminLogin";
		}	
	}
	
	@RequestMapping("/insertSuggest")//추천작 추가 페이지 이동
	public String insertSuggest(HttpServletRequest req, @RequestParam(required = false) String mode, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			String search = req.getParameter("search");
			String searchString = req.getParameter("searchString");
			int pageSize = 20;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = 0;
			if (mode == null)
				rowCount = adminSuggestMapper.getNovelCount();
			else
				rowCount = adminSuggestMapper.getNovelSearchCount(search, searchString);
			if (endRow > rowCount)
				endRow = rowCount;
			List<NovelDTO> list = null;
			int novelNum = 0;
			if (rowCount > 0) {
				if (mode == null) {
					list = adminSuggestMapper.listNovel(startRow, endRow);
					novelNum = rowCount - (startRow - 1);
					if (rowCount > 0) {
						int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
						int pageBlock = 3;
						int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
						int endPage = startPage + pageBlock - 1;
						if (endPage > pageCount)
							endPage = pageCount;
						req.setAttribute("pageCount", pageCount);
						req.setAttribute("startPage", startPage);
						req.setAttribute("endPage", endPage);
					}
				} else {
					list = adminSuggestMapper.findNovelAdmin(search, searchString);
				}
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("novelNum", novelNum);
			req.setAttribute("listNovel", list);
			return "homepage/admin/banerManage/suggestInsert";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/insertSuggestOk")//추천작 추가 기능
	public String insertSuggest(HttpServletRequest req, @ModelAttribute AdminSuggestDTO dto, int nnum) {
		int res = adminSuggestMapper.insertAdminSuggest(dto, nnum);
		String msg = null, url = null;
		if (res>0) {
			msg = "추천작 추가 성공";
			url = "insertSuggest";
		}else {
			msg = "추천작 추가 실패";
			url = "insertSuggest";
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
			url = "listSuggest";
		}else {
			msg = "추천작 삭제 실패";
			url = "listSuggest";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping(value="/insertCate", method=RequestMethod.GET)//카테고리 페이지 이동
	public String cateInsert(HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			return "homepage/admin/cateManage/cateInsert";
		}else {
			return "redirect:/adminLogin";
		}	
	}
	
	@RequestMapping(value="/insertCate", method=RequestMethod.POST)//카테고리 등록
	public String cateInsert(HttpServletRequest req, @ModelAttribute CategoryDTO dto) {
		CategoryDTO dto1 = categoryMapper.getCategory(dto.getCate_name());
		String msg = null, url = null;
		if(dto1==null) {
			int res = categoryMapper.insertCategory(dto);
			if (res > 0) {
				msg = "카테고리 입력 성공";
				url = "listCate";
			} else {
				msg = "카테고리 입력 실패";
				url = "insertCate";
			}
		}else {
			msg = "이미 있는 카테고리입니다";
			url = "insertCate";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/listCate")//카테고리 리스트 페이지 이동
	public String cateList(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			List<CategoryDTO> list = categoryMapper.listCategory();
			req.setAttribute("listCategory", list);
			return "homepage/admin/cateManage/cateList";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/contentBoardAdmin")
	public String boardContent(HttpServletRequest req, int bnum) {
		BoardDTO dto = boardMapper.getBoard(bnum, "admin");
		req.setAttribute("getBoard", dto);
		return "homepage/admin/boardManage/boardContent";
	}
	
	@RequestMapping("/listBoardAdmin")
	public String boardManageList(HttpServletRequest req, @RequestParam(required = false) String mode,HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			int pageSize = 5;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = boardMapper.getBoardCount();
			if (endRow > rowCount)
				endRow = rowCount;
			List<BoardDTO> list = null;
			int boardNum = 0;
			if (rowCount > 0) {
				if (mode == null) {
					list = boardMapper.listBoardAdmin(startRow, endRow);
					boardNum = rowCount - (startRow - 1);
					if (rowCount > 0) {
						int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
						int pageBlock = 3;
						int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
						int endPage = startPage + pageBlock - 1;
						if (endPage > pageCount)
							endPage = pageCount;
						req.setAttribute("pageCount", pageCount);
						req.setAttribute("startPage", startPage);
						req.setAttribute("endPage", endPage);
					}
				} else {
					String search = req.getParameter("search");
					String searchString = req.getParameter("searchString");
					rowCount = boardMapper.getBoardSearchCount(search, searchString);
					list = boardMapper.findBoard(search, searchString);
				}
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("boardNum", boardNum);
			req.setAttribute("listBoard", list);
			return "homepage/admin/boardManage/boardList";
		} else {
			return "redirect:/adminLogin";
		}
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
	public String noticeList(HttpServletRequest req, @RequestParam(required = false) String mode, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			int pageSize = 5;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = noticeMapper.getNoticeCount();
			if (endRow > rowCount)
				endRow = rowCount;
			List<NoticeDTO> list = null;
			int noticeNum = 0;
			if (rowCount > 0) {
				if (mode == null) {
					list = noticeMapper.listNotice(startRow, endRow);
					noticeNum = rowCount - (startRow - 1);
					if (rowCount > 0) {
						int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
						int pageBlock = 3;
						int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
						int endPage = startPage + pageBlock - 1;
						if (endPage > pageCount)
							endPage = pageCount;
						req.setAttribute("pageCount", pageCount);
						req.setAttribute("startPage", startPage);
						req.setAttribute("endPage", endPage);
					}
				} else {
					String searchString = req.getParameter("searchString");
					list = noticeMapper.findNotice("Notice_title", searchString);
				}
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("noticeNum", noticeNum);
			req.setAttribute("listNotice", list);
			return "homepage/admin/noticeManage/noticeList";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping(value="/insertNotice", method=RequestMethod.GET)
	public String noticeInsert(HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			return "homepage/admin/noticeManage/noticeInsert";
		}else {
			return "redirect:/adminLogin";
		}
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
	public String noticeUpdate(HttpServletRequest req, int nonum, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			NoticeDTO dto = noticeMapper.getNotice(nonum, "update");
			req.setAttribute("getNotice", dto);
			return "homepage/admin/noticeManage/noticeUpdate";
		} else {
			return "redirect:/adminLogin";
		}
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
	public String listClient(HttpServletRequest req,@RequestParam(required = false) String mode, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")){
			String search = req.getParameter("search");
			String searchString = req.getParameter("searchString");
			int pageSize = 20;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = memberMapper.getMemberCount();
			if (endRow > rowCount)
				endRow = rowCount;
			List<MemberDTO> list = null;
			if (rowCount > 0) {
				if (mode == null) {
					list = memberMapper.listMember(startRow, endRow);
				} else {
					rowCount = memberMapper.getMemberSearchCount(search, searchString);
					list = memberMapper.findMember(search, searchString);
				}
			}
			int memberNum = 0;
			if (rowCount > 0) {
				int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
				int pageBlock = 3;
				int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount)
					endPage = pageCount;
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("startPage", startPage);
				req.setAttribute("endPage", endPage);
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("memberNum", memberNum);
			req.setAttribute("listMember", list);
			return "homepage/admin/memberManage/clientList";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/listWriter")
	public String listWriter(HttpServletRequest req,@RequestParam(required = false) String mode, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")){
			String search = req.getParameter("search");
			String searchString = req.getParameter("searchString");
			int pageSize = 15;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = memberMapper.getWriterCount();
			if (endRow > rowCount)
				endRow = rowCount;
			List<MemberDTO> list = null;
			if (rowCount > 0) {
				if (mode == null) {
					list = memberMapper.listWriter(startRow, endRow);
				} else {
					rowCount = memberMapper.getWriterSearchCount(search, searchString);
					list = memberMapper.findMember(search, searchString);
				}
			}
			int writerNum = 0;
			if (rowCount > 0) {
				int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
				int pageBlock = 3;
				int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount)
					endPage = pageCount;
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("startPage", startPage);
				req.setAttribute("endPage", endPage);
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("writerNum", writerNum);
			req.setAttribute("listWriter", list);
			return "homepage/admin/memberManage/writerList";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	/*회원삭제기능 없애기로 함*/
	/*@RequestMapping("/deleteMember")
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
	}*/
	
	//작가강등
	@RequestMapping("/downgradeWriter") 
	public String downgradeWriter(HttpServletRequest req, int mnum) {
		
		int res= memberMapper.downgradeWriter(mnum);
		
		String msg = null, url = null;
		if (res>0) {
			msg = "해당 작가회원이 일반회원으로 강등되었습니다.";
			url = "listWriter";
		}else {
			msg = "작가 강등을 실패했습니다.";
			url = "listWriter";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}

	@RequestMapping("/listUpgradeClient")
	public String clientUpgrade(HttpServletRequest req, @RequestParam(required = false) String mode,HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			int pageSize = 5;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = 0;
			if (mode == null) {
				rowCount = requestWriterMapper.getRequestWriterCount();
			} else {
				String search = req.getParameter("search");
				String searchString = req.getParameter("searchString");
				rowCount = requestWriterMapper.getRequestWriterSearchCount(search, searchString);
			}
			if (endRow > rowCount)
				endRow = rowCount;
			List<RequestWriterDTO> list = null;
			if (rowCount > 0) {
				if (mode == null) {
					list = requestWriterMapper.listRequestWriter(startRow, endRow);
				} else {
					String search = req.getParameter("search");
					String searchString = req.getParameter("searchString");
					list = requestWriterMapper.findRequestWriter(search, searchString, startRow, endRow);
				}
			}
			int writerNum = 0;
			if (rowCount > 0) {
				int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
				int pageBlock = 3;
				int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount)
					endPage = pageCount;
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("startPage", startPage);
				req.setAttribute("endPage", endPage);
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("writerNum", writerNum);
			req.setAttribute("listClientUpgrade", list);
			return "homepage/admin/memberManage/clientUpgrade";
		}else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/upgradeClientContent")
	public String contentRequestWriter(HttpServletRequest req, int rwnum) {
		RequestWriterDTO dto = requestWriterMapper.getRequestWriter(rwnum);
		req.setAttribute("getRequestWriter", dto);
		return "homepage/admin/memberManage/clientUpgradeContent";
	}
	
	@RequestMapping("/upgradeClientOk")
	public String upgradeClientOk(HttpServletRequest req, int mnum, int rwnum, String state) {
		int res1 = memberMapper.upgradeClientOk(mnum);
		int res2 = requestWriterMapper.upgradeClientState(rwnum, state);
		String msg = null, url = null;
		if (res1>0 && res2>0) {
			msg = "작가 등록 성공";
			url = "listWriter";
		}else {
			msg = "작가 등록 실패";
			url = "listUpgradeClient";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/upgradeClientRefuse")
	public String upgradeClientRefuse(HttpServletRequest req, int rwnum, String state) {
		int res = requestWriterMapper.upgradeClientState(rwnum, state);
		String msg = null, url = null;
		if (res>0) {
			msg = "작가 등록 신청 거절 성공";
			url = "listUpgradeClient";
		}else {
			msg = "작가 등록 신청 거절 실패";
			url = "listUpgradeClient";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "forward:message";
	}
	
	@RequestMapping("/saleManageClient")
	public String saleManageClient(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			List<Map<String, String>> list=purchaseHistoryMapper.saleManageClient();
			req.setAttribute("list",list);
			return "homepage/admin/saleManage/saleManageClient";
		} else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/saleManageWriter")
	public String saleManageWriter(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			List<Map<String, String>> list = purchaseHistoryMapper.saleManageWriter();
			req.setAttribute("list", list);
			return "homepage/admin/saleManage/saleManageWriter";
		} else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/saleTotal")
	public String saleTotal(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			List<Map<String, String>> list = purchaseHistoryMapper.saleTotal();
			req.setAttribute("list", list);
			return "homepage/admin/saleManage/saleTotal";
		} else {
			return "redirect:/adminLogin";
		}
	}
	
	@RequestMapping("/listPay")
	public String listPay(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("admin").equals("admin")) {
			int pageSize = 5;
			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int rowCount = payMapper.getPayCount();
			if (endRow > rowCount)
				endRow = rowCount;
			List<PayDTO> list = null;
			if (rowCount > 0) {
				list = payMapper.listPay(startRow, endRow);
			}
			int payNum = rowCount - (startRow - 1);
			if (rowCount > 0) {
				int pageCount = rowCount / pageSize + (rowCount % pageSize == 0 ? 0 : 1);
				int pageBlock = 3;
				int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount)
					endPage = pageCount;
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("startPage", startPage);
				req.setAttribute("endPage", endPage);
			}
			req.setAttribute("rowCount", rowCount);
			req.setAttribute("payNum", payNum);
			req.setAttribute("listPay", list);
			return "homepage/admin/saleManage/payList";
		}else {
			return "redirect:/adminLogin";
		}
	}

}
