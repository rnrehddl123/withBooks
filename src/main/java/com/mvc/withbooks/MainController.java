package com.mvc.withbooks;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.BoardDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.AdminSlideMapper;
import com.mvc.withbooks.service.AdminSuggestMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NovelMapper;

@Controller
public class MainController {
	
	@Autowired
	private AdminSlideMapper adminSlideMapper;
	@Autowired
	private AdminSuggestMapper adminSuggestMapper;
	@Autowired
	private NovelMapper novelMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	
	
	@RequestMapping("/main")
	public String main(HttpServletRequest req) {
		List<AdminSlideDTO> list = adminSlideMapper.listSlide();
		req.setAttribute("listSlide", list);
		List<AdminSuggestDTO> slist = adminSuggestMapper.listAdminSuggestMain();
		req.setAttribute("listAdminSuggestMain", slist);
		List<NovelDTO> nlist = novelMapper.listNovel();
		req.setAttribute("listNovel", nlist);
		List<List<AdminSuggestDTO>> sslist = new ArrayList<List<AdminSuggestDTO>>();
		List<AdminSuggestDTO> cslist = new ArrayList<AdminSuggestDTO>();
		int count=0;
		for(AdminSuggestDTO dto : slist) {
			count++;
			cslist.add(dto);
			if(count==4) {
				count=0;
				sslist.add(cslist);
				cslist=new ArrayList<AdminSuggestDTO>();
			}
		}
		req.setAttribute("sslist", sslist);
		return "/main/main";
	}
	
	@RequestMapping("/searchMain")
	public String searchMain(HttpServletRequest req, String searchString) {
		int novelPageSize = 5;
		String novelPageNum = req.getParameter("novelPageNum");
		if (novelPageNum==null){
			novelPageNum = "1";
		}
		int novelCurrentPage = Integer.parseInt(novelPageNum);
		int novelStartRow = (novelCurrentPage-1) * novelPageSize + 1;
		int novelEndRow = novelStartRow + novelPageSize -1;
		int novelRowCount = novelMapper.getNovelCountMain(searchString);
		if (novelEndRow > novelRowCount) novelEndRow = novelRowCount;
		List<NovelDTO> nlist = null;
		int novelNum = 0;
		if (novelRowCount>0){
			nlist = novelMapper.findNovelMain(searchString, novelStartRow, novelEndRow);
			novelNum = novelRowCount - (novelStartRow - 1);
			if (novelRowCount>0) {
				int novelPageCount = novelRowCount/novelPageSize + (novelRowCount%novelPageSize==0 ? 0 : 1);
				int novelPageBlock = 3;
				int novelStartPage = (novelCurrentPage - 1)/novelPageBlock  * novelPageBlock + 1;
				int novelEndPage = novelStartPage + novelPageBlock - 1;
				if (novelEndPage > novelPageCount) novelEndPage = novelPageCount;
				req.setAttribute("novelPageCount", novelPageCount);
				req.setAttribute("novelStartPage", novelStartPage);
				req.setAttribute("novelEndPage", novelEndPage);
			}
		}
		req.setAttribute("novelRowCount", novelRowCount);
		req.setAttribute("novelNum", novelNum);
		req.setAttribute("listNovel", nlist);
		req.setAttribute("searchString", searchString);
		
		int writerPageSize = 5;
		String writerPageNum = req.getParameter("writerPageNum");
		if (writerPageNum==null){
			writerPageNum = "1";
		}
		int writerCurrentPage = Integer.parseInt(writerPageNum);
		int writerStartRow = (writerCurrentPage-1) * writerPageSize + 1;
		int writerEndRow = writerStartRow + writerPageSize -1;
		int writerRowCount = novelMapper.getWriterCountMain(searchString);
		if (writerEndRow > writerRowCount) writerEndRow = writerRowCount;
		List<NovelDTO> mlist = null;
		int writerNum = 0;
		if (writerRowCount>0){
			mlist = novelMapper.findWriterMain(searchString, writerStartRow, writerEndRow);
			System.out.println(mlist.size());
			writerNum = writerRowCount - (writerStartRow - 1);
			if (writerRowCount>0) {
				int writerPageCount = writerRowCount/writerPageSize + (writerRowCount%writerPageSize==0 ? 0 : 1);
				int writerPageBlock = 3;
				int writerStartPage = (writerCurrentPage - 1)/writerPageBlock  * writerPageBlock + 1;
				int writerEndPage = writerStartPage + writerPageBlock - 1;
				if (writerEndPage > writerPageCount) writerEndPage = writerPageCount;
				req.setAttribute("writerPageCount", writerPageCount);
				req.setAttribute("writerStartPage", writerStartPage);
				req.setAttribute("writerEndPage", writerEndPage);
			}
		}
		req.setAttribute("writerRowCount", writerRowCount);
		req.setAttribute("writerNum", writerNum);
		req.setAttribute("listWriter", mlist);
		return "/main/search";
	}
	
	@RequestMapping("/searchWriterNovelList")
	public String searchWriterNovelList(HttpServletRequest req, int mnum, String novel_memberName) {
		req.setAttribute("novel_memberName", novel_memberName);
		List<NovelDTO> list = novelMapper.searchmemberNovel(novel_memberName);
		req.setAttribute("listmemberNovel", list);
		return "/writer/writerPage/writerSubject/searchWriterNovelList";
	}
	
	@RequestMapping("/login")
	public String Login() {
		return "/main/login";
	}
	
	@RequestMapping("/findId")
	public String findId() {
		return "/main/findId";
	}
	
	@RequestMapping("/findPassword")
	public String findPassword() {
		return "/main/findPassword";
	}
}
