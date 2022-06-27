package com.mvc.withbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.mvc.withbooks.dto.CategoryDTO;
import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.dto.HeartDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.dto.NoticeNovelDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.dto.ReviewDTO;
import com.mvc.withbooks.dto.PurchaseHistoryDTO;
import com.mvc.withbooks.service.CategoryMapper;
import com.mvc.withbooks.service.EpisodeMapper;
import com.mvc.withbooks.service.HeartMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeEpisodeMapper;
import com.mvc.withbooks.service.NoticeNovelMapper;
import com.mvc.withbooks.service.NovelMapper;
import com.mvc.withbooks.service.PayMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;
import com.mvc.withbooks.service.ReviewMapper;

@Controller
public class ClientController {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private NoticeEpisodeMapper noticeEpisodeMapper;
	@Autowired
	private NovelMapper novelMapper;
	@Autowired
	private NoticeNovelMapper noticeNovelMapper;
	@Autowired
	private EpisodeMapper episodeMapper;
	@Autowired
	private PurchaseHistoryMapper purchaseHistoryMapper;
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private PayMapper payMapper;
	@Autowired
	private HeartMapper heartMapper;

	@RequestMapping("/clientNovelListForCate")//일반회원 카테고리별 소설목록 페이지
	public String ClientNovelListForCate(HttpServletRequest req) {
		List<CategoryDTO> listCategory = categoryMapper.listCategory();
		req.setAttribute("listCategory", listCategory);
		return "client/clientNovelListForCate";
	}
	
	@RequestMapping(value="/clientNovelListForCateGET", method=RequestMethod.GET)
	public String ClientNovelListForCateGET(HttpSession session, HttpServletRequest req,
			@RequestParam int cnum) {
		List<CategoryDTO> listCategory = categoryMapper.listCategory();
		req.setAttribute("listCategory", listCategory);
		List<NovelDTO> listNovel = novelMapper.listNovel();
		req.setAttribute("listNovel", listNovel);
		String selectCate = categoryMapper.selectCate(cnum);
		List<NovelDTO> listForCate = novelMapper.listForCate(selectCate);
		req.setAttribute("listForCate", listForCate);
		if(!listForCate.isEmpty()) {
			req.setAttribute("selectCateName", listForCate.get(0).getNovel_cate());
		}
		return "client/clientNovelListForCate";
	}



	
	@RequestMapping("/clientMypage")//일반회원 마이 페이지
	public String ClientmyPage(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//일반회원 수정 페이지
	public String ClientUpdate(HttpSession session, HttpServletRequest req, @RequestParam Map<String, String> params, String[] member_preferred) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		String[] tel = login.getMember_Tel().split("-");
		req.setAttribute("tel1", tel[0]);
		req.setAttribute("tel2", tel[1]);
		req.setAttribute("tel3", tel[2]);
		List<CategoryDTO> list = categoryMapper.listCategory();
		req.setAttribute("categoryList", list);
		req.setAttribute("member_preferred", member_preferred);
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLeave")//회원탈퇴 페이지
	public String ClientLeave(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage/clientLeave";
	}
	
	@RequestMapping("/clientLibrary")//일반회원 내 서재
	public String ClientLibrary(HttpSession session, HttpServletRequest req) {
		if(session.getAttribute("login")==null){
			return "redirect:login";
		}
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		int mnum = login.getMnum();
		List<Integer> list = purchaseHistoryMapper.purchaseLibrary(mnum);
		List<NovelDTO> nlist = new ArrayList<NovelDTO>();
		for(int nnum : list) {
			NovelDTO dto = novelMapper.getNovel(nnum);
			nlist.add(dto);
		}
		req.setAttribute("nlist", nlist);
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientOrderList")//일반회원 구매내역
	public String ClientOrderList(HttpSession session,HttpServletRequest req) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login==null){
			return "redirect:/main/login";
		}
		int mnum = login.getMnum();
		List<Map<String, String>> list = purchaseHistoryMapper.listPurchaseHistory(mnum);
		int pageSize = 20;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		Map<String, String> parmas = new HashMap<String, String>();
		parmas.put("mnum", String.valueOf(mnum));
		parmas.put("startRow", String.valueOf(startRow));
		parmas.put("endRow", String.valueOf(endRow));
		int rowCount = purchaseHistoryMapper.getPurchaseHistoryCount(mnum);
		if (endRow > rowCount) endRow = rowCount;
		list = null;
		if (rowCount>0){
			list = purchaseHistoryMapper.purchaseList(parmas);
		}
		int purchaseNum = rowCount - (startRow - 1);
		if (rowCount>0) {
			int pageCount = rowCount/pageSize + (rowCount%pageSize==0 ? 0 : 1);
			int pageBlock = 10;
			int startPage = (currentPage - 1)/pageBlock  * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) endPage = pageCount;
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("startPage", startPage);
			req.setAttribute("endPage", endPage);
		}
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("purchaseNum", purchaseNum);
		req.setAttribute("purchaseHistoryList", list);
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientViewer")//일반회원 소설보기
	public String ClientViewer(HttpServletRequest req,HttpSession session,@RequestParam int epnum) {
		List<Integer> checkList=(List<Integer>) session.getAttribute("checkList");
		if(session.getAttribute("login")==null){
			return "/main/login";
		}else if (!checkList.contains(epnum)) {
			return "/main/main";
		}
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		NovelDTO novelDTO=(NovelDTO) session.getAttribute("noveldto");
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("nnum", Integer.toString(novelDTO.getNnum()));
		params.put("mnum", Integer.toString(login.getMnum()));
		NoticeNovelDTO noticeNovelDTO=noticeNovelMapper.getNoticeNovel(params);
		req.setAttribute("noticeNovelDTO", noticeNovelDTO);
		EpisodeDTO epdto=episodeMapper.getEpisode(epnum,"view");
		req.setAttribute("epdto", epdto);
		return "client/clientViewer";
	}
	
	@RequestMapping("/clientPay")//일반회원 충전 페이지
	public String ClientPay(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage/clientPay";
	}
	
	//일반회원 충전 기능
	@RequestMapping(value="updateCash", method=RequestMethod.POST)
	public String updateCash(HttpServletRequest req, @RequestParam Map<String, String> params, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		/*int res = memberMapper.updateCash(params);
		if(res>0) {
			req.setAttribute("msg", "충전성공.");
			req.setAttribute("url", "clientMypage");
			MemberDTO login = (MemberDTO)session.getAttribute("login");
			login.setCash(login.getCash() + Integer.parseInt(params.get("cash")));
			session.setAttribute("login", login);
		}else {
			req.setAttribute("msg", "충전실패.");
			req.setAttribute("url", "clientMypage");
		}*/
		return "message";
	}
	
	@RequestMapping("/clientNovelInfo")//�뜝���눦�삕 �뜝�룞�삕�뜝占�
	public String ClientNovelInfo(HttpServletRequest req,HttpSession session,@RequestParam int nnum, String change) {
		MemberDTO login=(MemberDTO)session.getAttribute("login");
		NovelDTO ndto=novelMapper.getNovel(nnum);
		
		if(login!=null){
			HashMap<String, String> params=new HashMap<String, String>();
			params.put("nnum", Integer.toString(nnum));
			params.put("mnum", Integer.toString(login.getMnum()));
			NoticeNovelDTO noticeNovelDTO=noticeNovelMapper.getNoticeNovel(params);
			req.setAttribute("noticeNovelDTO", noticeNovelDTO);
			HeartDTO heartDTO = heartMapper.getHeart(params);
			req.setAttribute("heartDTO", heartDTO);
			Map<String, Object> myReview=new HashMap<String, Object>();
			myReview.put("mnum", login.getMnum());
			myReview.put("nnum", nnum);
			req.setAttribute("review", reviewMapper.getreview(myReview));
			
		}
		/*List<EpisodeDTO> elist=episodeMapper.listNoEpisode(nnum);
		session.setAttribute("elist", elist);*/
		List<Map<String, String>> elist = episodeMapper.listEpisodeCount(nnum);
		int pageSize = 25;
		String pageNum = req.getParameter("pageNum");
		if (pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		Map<String, String> params = new HashMap<String, String>();
		params.put("nnum", String.valueOf(nnum));
		params.put("startRow", String.valueOf(startRow));
		params.put("endRow", String.valueOf(endRow));
		int rowCount = episodeMapper.getEpisodeCount(nnum);
		if (endRow > rowCount) endRow = rowCount;
		elist = null;
		if (rowCount>0){
			if(change.equals("past")) {
				elist=episodeMapper.episodeCountListReverse(params);
			}else {
				elist = episodeMapper.episodeCountList(params);
			}
		}
		int episodeNum =  rowCount - (startRow - 1);
		if (rowCount>0) {
			int pageCount = rowCount/pageSize + (rowCount%pageSize==0 ? 0 : 1);
			int pageBlock = 10;
			int startPage = (currentPage - 1)/pageBlock  * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) endPage = pageCount;
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("startPage", startPage);
			req.setAttribute("endPage", endPage);
		}
		req.setAttribute("rowCount", rowCount);
		req.setAttribute("episodeNum", episodeNum);
		session.setAttribute("elist", elist);
		req.setAttribute("change", change);
		session.setAttribute("noveldto", ndto);
		List<Map<String, String>> reviewList = reviewMapper.getReviewList(nnum);
		req.setAttribute("reviewList", reviewList);
		double totalscore=0;
		for(Map<String, String> map : reviewList) {
			totalscore+=(double)Integer.parseInt(String.valueOf(map.get("SCORE")));
		}
		totalscore=totalscore/reviewList.size();
		req.setAttribute("ascore", totalscore);
		return "client/clientNovelInfo";
	}

	
	@RequestMapping("/signUp")//회원가입 페이지
	public String SignUp(HttpServletRequest req) {
		List<CategoryDTO> list=categoryMapper.listCategory();
		req.setAttribute("categoryList", list);
		return "main/signUp";
	}
	
	//회원가입 기능
	
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String insertMember(HttpServletRequest req, @ModelAttribute MemberDTO dto, @RequestParam Map<String, String> params,@RequestParam(required = false) String[] member_preferred){
		dto.setMember_Tel(req.getAttribute("tel1")+"-"+req.getAttribute("tel2")+"-"+req.getAttribute("tel3"));
		if(member_preferred.length>2) {
			dto.setMember_preferred1(member_preferred[0]);
			dto.setMember_preferred2(member_preferred[1]);
			dto.setMember_preferred3(member_preferred[2]);
		}else if (member_preferred.length>1) {
			dto.setMember_preferred1(member_preferred[0]);
			dto.setMember_preferred2(member_preferred[1]);
		}else if (member_preferred.length>0) {
			dto.setMember_preferred1(member_preferred[0]);
		}else {
			dto.setMember_preferred1(null);
			dto.setMember_preferred2(null);
			dto.setMember_preferred3(null);
		}
		
		int res = memberMapper.insertMember(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "회원가입성공.";
			url = "signUp";
		}else {
			msg = "회원가입실패.";
			url = "signUp";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	//로그인 기능
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String LoginForm(HttpServletRequest req) {
		String referrer = req.getHeader("Referer");
		req.getSession().setAttribute("prevPage",referrer);
		return "/main/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String Login(HttpServletRequest req, HttpServletResponse resp,			
			@RequestParam Map<String, String> params,HttpSession session) {
		MemberDTO dto = memberMapper.getMember(params.get("Member_id"));
		String msg = null, url = null;
		if (dto == null){	
			msg = "해당하는 아이디가 없습니다. 다시 확인하고 로그인해 주세요!!";
			url = "login";
			return "message";
		}else {
			if (params.get("Member_passwd").equals(dto.getMember_passwd())){
				session.setAttribute("login", dto);		
				List<NoticeEpisodeDTO> noticeEpisodeList=noticeEpisodeMapper.sendNoticeList(dto);
				session.setAttribute("noticeEpisodeList",noticeEpisodeList);
				List<Integer> checkList=purchaseHistoryMapper.purchaseHistoryCheckList(dto.getMnum());
				session.setAttribute("checkList", checkList);
				Cookie ck = new Cookie("saveId", dto.getMember_id());
				if (params.containsKey("saveId")){
					ck.setMaxAge(0);
				}else {
					ck.setMaxAge(24*60*60);
				}
				resp.addCookie(ck);
			}else {	
				msg = "비밀번호가 틀렸습니다. 다시 확인하고 로그인해 주세요!!";
				url = "login";
				return "message";
			}
		}
		
	//알림설정
		List<HashMap<String, String>> noticeList=noticeEpisodeMapper.getNoticeEpisodeMsg(dto.getMnum());
		for(HashMap<String, String> map : noticeList) {
			Map<String, String> epmap=episodeMapper.getEpisode(String.valueOf(map.get("EPNUM")));
			NovelDTO ndto=novelMapper.getNovel(Integer.parseInt(String.valueOf(epmap.get("NNUM"))));
			map.put("EPI_SUBJECT", epmap.get("EPI_SUBJECT"));
			map.put("SUBJECT", ndto.getNovel_subject());
		}
		session.setAttribute("noticeList", noticeList);
		if(session.getAttribute("prevPage")==null) {
			return "/main/main";
		}
		return "redirect:" + session.getAttribute("prevPage");
	}
	
	//로그아웃 기능
	@RequestMapping("logout")
	public String Logout(HttpServletRequest req,HttpSession session) {
		session.invalidate();
		return "redirect:" + req.getHeader("Referer");
	}
	
	//일반회원 정보수정 기능
	@RequestMapping(value="updateMember", method=RequestMethod.POST)
	public String updateMember(HttpServletRequest req, @ModelAttribute MemberDTO dto,
			HttpSession session, @RequestParam Map<String, String> params, String[] member_preferred) {
		MemberDTO login=(MemberDTO) session.getAttribute("login");
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		dto.setMember_Tel(params.get("Member_tel1")+"-"+params.get("Member_tel2")+"-"+params.get("Member_tel3"));
		if(member_preferred!=null) {
			if(member_preferred.length>2) {
				dto.setMember_preferred1(member_preferred[0]);
				dto.setMember_preferred2(member_preferred[1]);
				dto.setMember_preferred3(member_preferred[2]);
			}else if (member_preferred.length>1) {
				dto.setMember_preferred1(member_preferred[0]);
				dto.setMember_preferred2(member_preferred[1]);
			}else if (member_preferred.length>0) {
				dto.setMember_preferred1(member_preferred[0]);
			}
		}else {
			dto.setMember_preferred1(null);
			dto.setMember_preferred2(null);
			dto.setMember_preferred3(null);
		}
		int res = memberMapper.updateMember(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "회원 정보가 수정되었습니다.";
			url = "clientMypage";
		}else {
			msg = "회원 정보 수정 실패하였습니다.";
			url = "clientMypage";
		}
		dto.setCash(login.getCash());
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		session.setAttribute("login", dto);
		return "message";
	}
	
	//일반회원 탈퇴기능
	@RequestMapping(value="leaveMember", method=RequestMethod.GET)
	public String leaveMember(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "/main/main";
	}
	
	@RequestMapping(value="leaveMember", method=RequestMethod.POST)
	public String leaveMember(HttpServletRequest req, @RequestParam int mnum, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = memberMapper.deleteMember(mnum);
		String msg = null, url = null;
		if (res>0) {
			session.invalidate();
			msg = "회원탈퇴 성공, 이용해주셔서 감사합니다.";
			url = "redirect:main";
		}else {
			msg = "회원탈퇴 실패, 마이 페이지로 이동합니다.";
			url = "clientMypage";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	
	@RequestMapping(value="/purchaseCash", method=RequestMethod.GET)
	public String PurchaseCashForm(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "main/main";
	}
	
	@RequestMapping(value="purchaseCash", method=RequestMethod.POST)
	public String PurchaseCash(@RequestBody String data,HttpServletRequest req,HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		Gson gson = new Gson();
		Map<String, Object> params = gson.fromJson(data, Map.class);
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		params.put("mnum", String.valueOf(login.getMnum()));
		int cash=(int)Math.round((Double)params.get("paid_amount"))*1000;
		params.put("cash",cash);
		int res = payMapper.insertPay(params);
		
		if(res>0) {
			int res2 = memberMapper.updateCash(params);
			login.setCash(login.getCash() + cash);
			session.setAttribute("login", login);
			return "clientMypage";
		}else {
			req.setAttribute("msg", "실패 성공.");
			req.setAttribute("url", "clientMypage");
		}
		return "clientMypage";
	}
}
