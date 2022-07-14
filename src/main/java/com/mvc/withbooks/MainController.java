package com.mvc.withbooks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.BoardDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.dto.ReviewDTO;
import com.mvc.withbooks.service.AdminSlideMapper;
import com.mvc.withbooks.service.AdminSuggestMapper;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.NovelMapper;
import com.mvc.withbooks.service.RecommendService;
import com.mvc.withbooks.service.ReviewMapper;

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
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private RecommendService recommendService;
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	@RequestMapping("/main")
	public String main(HttpServletRequest req, HttpSession session) {
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
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if(login!=null) {
			List<NovelDTO> relist = null;
			Map<Long, HashMap<Long, Float>> map = recommendService.getRecommend();
			List<ReviewDTO> rlist = reviewMapper.listRecommend(login.getMnum());
			if (rlist.size() != 0) {
				Map<Float, Long> recommend = new HashMap<Float, Long>();
				for (int i = 0; i < rlist.size(); i++) {
					Set<Long> keys = map.get(Long.valueOf(rlist.get(i).getNovelDTO().getNnum())).keySet();
					Iterator<Long> it = keys.iterator();
					while (it.hasNext()) {
						Long key = it.next();
						float rating = map.get(Long.valueOf(rlist.get(i).getNovelDTO().getNnum())).get(key);
						recommend.put(rating, Long.valueOf(rlist.get(i).getNovelDTO().getNnum()));
					}
				}
				List<Float> keySet = new ArrayList<>(recommend.keySet());
				Collections.reverse(keySet);
				Map<Integer, Long> semap = new HashMap<Integer, Long>();
				if(recommend.size()<=4) {
					for (int i = 0; i < recommend.size(); i++) {
						semap.put(i, recommend.get(keySet.get(i)));
					}
				}else {
					for (int i = 0; i < 4; i++) {
						semap.put(i, recommend.get(keySet.get(i)));
					}
				}
				relist = novelMapper.getNovelMain(semap);
				int a = 4-relist.size();
				if(a!=0) {
					List<NovelDTO> re1 = novelMapper.getNovelAre(a);
					for(int i=0; i<a; i++) {
						relist.add(re1.get(i));
					}
				}
				session.setAttribute("relist", relist);
			}else {
				int a = 4;
				List<NovelDTO> re1 = novelMapper.getNovelAre(a);
				relist = new ArrayList<NovelDTO>();
				relist.addAll(re1);
				session.setAttribute("relist", relist);
			}
			
			
			List<NovelDTO> urelist;
			List<Long> ulist = recommendService.recommend2(login.getMnum());
			if (ulist != null) {
				Map<Integer, Long> usemap = new HashMap<Integer, Long>();
				for (int i = 0; i < ulist.size(); i++) {
					usemap.put(i, ulist.get(i));
				}
				urelist = novelMapper.getNovelMain(usemap);
				int b = 4-urelist.size();
				if(b!=0) {
					List<NovelDTO> ure1 = novelMapper.getNovelAre(b);
					urelist.addAll(ure1);
				}
				session.setAttribute("urelist", urelist);
			}else {
				int b = 4;
				List<NovelDTO> re1 = novelMapper.getNovelAre(b);
				urelist = new ArrayList<NovelDTO>();
				urelist.addAll(re1);
				session.setAttribute("urelist", urelist);
			}
			int c=4;
			List<NovelDTO> arelist = novelMapper.getNovelAre(c);
			session.setAttribute("arelist", arelist);
		}else {
			int a=4;
			List<NovelDTO> relist = novelMapper.getNovelAre(a);
			session.setAttribute("relist", relist);
			List<NovelDTO> urelist = novelMapper.getNovelAre(a);
			session.setAttribute("urelist", urelist);
			List<NovelDTO> arelist = novelMapper.getNovelAre(a);
			session.setAttribute("arelist", arelist);
		}
		
		return "/main/main";
	}
	
	@RequestMapping("/searchMain")
	public String searchMain(HttpServletRequest req, String searchString) {
		if(searchString.trim().equals("")) {
			String msg = "검색어를 입력하세요";
			String url = "main";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
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
	
	@RequestMapping(value="/findIdForm")
	public String findIdForm() throws Exception{
		return "/main/findIdForm";
	}
	
	@RequestMapping(value="/findId", method = RequestMethod.POST)
	public String findId(HttpServletRequest request, String name,String email) throws Exception{
		Map<String,String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("email", email);
		MemberDTO dto = memberMapper.findId(params);
		request.setAttribute("dto", dto);
		return "/main/findId";
	}
	
	@RequestMapping("/pw_find")
	public String pw_find() throws Exception{
		return "/main/pw_find";
	}
	
	// 인증번호 발송
	@RequestMapping(value ="/pw_auth")
	public ModelAndView pw_auth(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String email = (String)request.getParameter("Member_email");
		String name = (String)request.getParameter("Member_name");
		
		MemberDTO dto = memberMapper.selectMember(email);
		if(dto != null) {
			Random r = new Random();
			int num = r.nextInt(999999); // 랜덤 인증번호 생성
			
			if(dto.getMember_name().equals(name)) {
				session.setAttribute("email", dto.getMember_email());
				
				String setfrom = "withbooks01@gmail.com"; // 보내는사람
				String tomail = email; // 받는사람
				String title = "[withBooks] 비밀번호 변경 인증 이메일 입니다."; // 메일 제목
				String content = System.getProperty("line.separator") + "안녕하세요 회원님" + System.getProperty("line.separator")
				+ "비밀번호찾기(변경) 인증번호는 " + num + " 입니다." + System.getProperty("line.separator"); // 메일 내용
			
				try {
					MimeMessage message = javaMailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
					
					messageHelper.setFrom(setfrom);
					messageHelper.setTo(tomail); 
					messageHelper.setSubject(title);
					messageHelper.setText(content); 
					
					javaMailSender.send(message);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("main/pw_auth");
				mv.addObject("num", num);
				return mv;
			}else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("main/pw_find");
				return mv;
				}
			}else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("main/pw_find");
				return mv;
		}
	}
	
	//인증번호 동일한지 확인
	@RequestMapping(value = "/pw_set", method = RequestMethod.POST)
	public String pw_set(@RequestParam(value="email_ok") String email_ok,@RequestParam(value = "num") String num) throws IOException{
		if(email_ok.equals(num)) {
			return "main/pw_new";
		}
		else {
			return "main/pw_find";
		}
	}
	
	//DB 비밀번호 업데이트
	@RequestMapping(value = "/pw_new", method = RequestMethod.POST)
	public String pw_new(HttpSession session,HttpServletRequest req,String pw) throws IOException{
		Map<String,String> params=new HashMap<String, String>();
		params.put("pw", pw);
		String email = (String) session.getAttribute("email");
		params.put("email", email);
		int result = memberMapper.pwUpdate_M(params);
		
		if(result == 1) {
			return "main/login";
		}else {
			System.out.println("pw_update"+ result);
			return "main/pw_new";
		}
	}
	
	@RequestMapping("/chat")
	public String Echo() {
		return "/main/chat";
	}
}
