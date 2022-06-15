package com.mvc.withbooks;

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
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.dto.NoticeNovelDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.CategoryMapper;
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
	
	@RequestMapping("/clientMypage")//留덉씠�럹�씠吏�
	public String ClientmyPage(HttpSession session) {
		if(session.getAttribute("login")==null){
			return "/main/login";
		}
		return "client/clientMypage";
	}
	
	@RequestMapping("/clientUpdate")//�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
	public String ClientUpdate() {
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping("/clientLeave")//회원탈퇴 페이지f
	public String ClientLeave() {
		return "client/clientMypage/clientLeave";
	}
	
	@RequestMapping("/clientLibrary")//�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
	public String ClientLibrary() {
		return "client/clientMypage/clientLibrary";
	}
	
	@RequestMapping("/clientCart")//�뜝�룞�삕熬귛뜝�룞�삕�뜝占�
	public String ClientCart() {
		return "client/clientMypage/clientCart";
	}
	
	@RequestMapping("/clientOrder")//�뜝�뙇諭꾩삕�뜝�떦源띿삕
	public String ClientOrder() {
		return "client/clientMypage/clientCart/clientOrder";
	}
	
	@RequestMapping("/clientOrderList")//�뜝�룞�삕�뜝�떊�냲�삕�뜝�룞�삕
	public String ClientOrderList() {
		return "client/clientMypage/clientOrderList";
	}
	
	@RequestMapping("/clientNovelSubject")//�뜝���눦�삕�뜝�룞�삕�뜝�룞�삕
	public String ClientNovelSubject() {
		return "client/clientMypage/clientOrderList/clientNovelSubject";
	}
	
	@RequestMapping("/clientNovelEpi")//�뜝�룞�삕�뜝�떎�냼�뱶蹂닷뜝�룞�삕
	public String ClientNovelEpi() {
		return "client/clientMypage/clientOrderList/clientNovelEpi";
	}
	
	@RequestMapping("/clientViewer")//�뜝�룞�삕�뜝�떎�냼�뱶蹂닷뜝�룞�삕
	public String ClientViewer() {
		return "client/clientViewer";
	}
	
	
	@RequestMapping("/clientRequest")//�뜝�뙗怨ㅼ삕 �뜝�룞�삕泥�
	public String ClientNovelRequest() {
		return "client/clientMypage/clientRequest";
	}
	
	@RequestMapping("/clientPay")//�뜝�룞�삕�뜝�룞�삕�뜝�떦源띿삕
	public String ClientPay() {
		return "client/clientMypage/clientPay";
	}
	
	@RequestMapping(value="/updateCash", method=RequestMethod.GET)
	public String updateCash() {
		return "main/main";
	}
	
	@RequestMapping(value="updateCash", method=RequestMethod.POST)
	public String updateCash(HttpServletRequest req, @RequestParam Map<String, Integer> params) {
		int res = memberMapper.updateCash(params);
		if(res>0) {
			req.setAttribute("msg", "���Ǽҵ� ���� ����!! ���Ǽҵ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "clientMypage");
		}else {
			req.setAttribute("msg", "���Ǽҵ� ���� ����!! ���Ǽҵ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "clientMypage");
		}
		return "message";
	}
	
	@RequestMapping("/clientNovelInfo")//�뜝���눦�삕 �뜝�룞�삕�뜝占�
	public String ClientNovelInfo(HttpServletRequest req,@RequestParam int nnum) {
		NovelDTO ndto=novelMapper.getNovel(nnum);
		NoticeNovelDTO noticeNovelDTO=noticeNovelMapper.getNoticeNovel(nnum);
		req.setAttribute("noveldto", ndto);
		req.setAttribute("noticeNovelDTO", noticeNovelDTO);
		return "client/clientNovelInfo";
	}
	
	@RequestMapping("/clientNotice")//�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
	public String ClientNotice() {
		return "client/clientNotice";
	}
	
	@RequestMapping("/clientBoard")//�뜝�룞�삕�뜝�룞�삕�뜝�뙃�룞�삕�뜝�룞�삕
	public String ClientBoard() {
		return "client/clientBoard";
	}
	
	@RequestMapping("/signUp")//�쉶�썝媛��엯 �럹�씠吏�
	public String SignUp(HttpServletRequest req) {
		List<CategoryDTO> list=categoryMapper.listCategory();
		req.setAttribute("categoryList", list);
		return "main/signUp";
	}
	
	//�쉶�썝媛��엯
	@RequestMapping(value="/insertMember", method=RequestMethod.GET)
	public String insertMember() {
		return "main/signUp";
	}
	
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
		return "redirect:" + session.getAttribute("prevPage");
	}
	
	@RequestMapping("logout")
	public String Logout(HttpServletRequest req,HttpSession session) {
		session.removeAttribute("login");
		return "redirect:" + req.getHeader("Referer");
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.GET)
	public String updateMember(HttpServletRequest req, @RequestParam int mnum) {
		MemberDTO dto = memberMapper.getMember(mnum);
		req.setAttribute("getMember", dto);
		return "client/clientMypage/clientUpdate";
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.POST)
	public String updateMember(HttpServletRequest req, @ModelAttribute MemberDTO dto) {
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
	
	@RequestMapping(value="leaveMember", method=RequestMethod.GET)
	public String leaveMember() {
		return "/main/main";
	}
	
	@RequestMapping(value="leaveMember", method=RequestMethod.POST)
	public String leaveMember(HttpServletRequest req, @RequestParam int mnum, HttpSession session) {
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
