package com.mvc.withbooks;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mvc.withbooks.dto.CategoryDTO;
import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.dto.NoticeNovelDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.CategoryMapper;
import com.mvc.withbooks.service.EpisodeMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NoticeEpisodeMapper;
import com.mvc.withbooks.service.NoticeNovelMapper;
import com.mvc.withbooks.service.NovelMapper;

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
	
	@RequestMapping("/clientMypage")//일반회원 마이 페이지
	public String ClientmyPage(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//일반회원 수정 페이지
	public String ClientUpdate(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
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
	public String ClientLibrary(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//일반회원 장바구니
	public String ClientCart(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//일반회원 주문하기
	public String ClientOrder(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//일반회원 구매내역
	public String ClientOrderList(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientViewer")//일반회원 소설보기
	public String ClientViewer(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
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
	@RequestMapping(value="/updateCash", method=RequestMethod.GET)
	public String updateCash(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "main/main";
	}
	
	@RequestMapping(value="updateCash", method=RequestMethod.POST)
	public String updateCash(HttpServletRequest req, @RequestParam Map<String, String> params, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = memberMapper.updateCash(params);
		if(res>0) {
			req.setAttribute("msg", "충전성공.");
			req.setAttribute("url", "clientMypage");
			MemberDTO login = (MemberDTO)session.getAttribute("login");
			login.setCash(login.getCash() + Integer.parseInt(params.get("cash")));
			session.setAttribute("login", login);
		}else {
			req.setAttribute("msg", "충전실패.");
			req.setAttribute("url", "clientMypage");
		}
		return "message";
	}
	

	@RequestMapping("/clientNovelInfo")//�뜝���눦�삕 �뜝�룞�삕�뜝占�
	public String ClientNovelInfo(HttpServletRequest req,HttpSession session,@RequestParam int nnum) {
		MemberDTO login=(MemberDTO)session.getAttribute("login");
		NovelDTO ndto=novelMapper.getNovel(nnum);
		if(login!=null){
			HashMap<String, String> params=new HashMap<String, String>();
			params.put("nnum", Integer.toString(nnum));
			params.put("mnum", Integer.toString(login.getMnum()));
			NoticeNovelDTO noticeNovelDTO=noticeNovelMapper.getNoticeNovel(params);
			req.setAttribute("noticeNovelDTO", noticeNovelDTO);
		}
		req.setAttribute("nnum", nnum);
		req.setAttribute("noveldto", ndto);
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
		dto.setMember_Tel(params.get("member_tel1"+"-")+params.get("member_tel2"+"-")+params.get("member_tel3"));	
		if (member_preferred.length>0) {
			dto.setMember_preferred1(member_preferred[0]);
		}else if (member_preferred.length>1) {
			dto.setMember_preferred1(member_preferred[0]);
			dto.setMember_preferred2(member_preferred[1]);
		}else if(member_preferred.length>2) {
			dto.setMember_preferred1(member_preferred[0]);
			dto.setMember_preferred2(member_preferred[1]);
			dto.setMember_preferred3(member_preferred[2]);
		}
		
		int res = memberMapper.insertMember(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "�쉶�썝媛��엯 �꽦怨�!! 硫붿씤 �럹�씠吏�濡� �씠�룞�빀�땲�떎.";
			url = "signUp";
		}else {
			msg = "�쉶�썝媛��엯 �떎�뙣!! �쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞�빀�땲�떎.";
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
		return "redirect:" + session.getAttribute("prevPage");
	}
	
	//로그아웃 기능
	@RequestMapping("logout")
	public String Logout(HttpServletRequest req,HttpSession session) {
		session.invalidate();
		return "redirect:" + req.getHeader("Referer");
	}
	
	//일반회원 정보수정 기능
	@RequestMapping(value="updateMember", method=RequestMethod.GET)
	public String updateMember(HttpServletRequest req, HttpSession session) {
		List<CategoryDTO> list=categoryMapper.listCategory();
		req.setAttribute("categoryList", list);
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		String[] tel = login.getMember_Tel().split("-");
		req.setAttribute("tel1", tel[0]);
		req.setAttribute("tel2", tel[1]);
		req.setAttribute("tel3", tel[2]);
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.POST)
	public String updateMember(HttpServletRequest req, @ModelAttribute MemberDTO dto, HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		int res = memberMapper.updateMember(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "회원 정보가 수정되었습니다.";
			url = "main";
		}else {
			msg = "회원 정보 수정 실패하였습니다.";
			url = "clientUpdate";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
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
}
