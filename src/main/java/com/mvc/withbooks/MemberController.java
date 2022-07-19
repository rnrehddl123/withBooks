package com.mvc.withbooks;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.service.MemberMapper;
import com.mvc.withbooks.service.MemberService;
import com.mvc.withbooks.service.NoticeEpisodeMapper;
import com.mvc.withbooks.service.PurchaseHistoryMapper;



@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PurchaseHistoryMapper purchaseHistoryMapper;
	@Autowired
	private NoticeEpisodeMapper noticeEpisodeMapper;

	@RequestMapping(value="kakaoLogin", method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code,HttpSession session) throws Exception {
		System.out.println("#########" + code);
		String access_Token = ms.getAccessToken(code);
		HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));

		MemberDTO login=memberMapper.loginKakao((String)userInfo.get("id"));
		
		if(login==null) {
			memberMapper.insertKakaoMember(userInfo);
		}else {
			session.setAttribute("login", login);
			//세션 : 작품알림
			List<NoticeEpisodeDTO> noticeEpisodeList=noticeEpisodeMapper.sendNoticeList(login);
			session.setAttribute("noticeEpisodeList",noticeEpisodeList);
			//세션 : 구매목록
			List<Integer> checkList=purchaseHistoryMapper.purchaseHistoryCheckList(login.getMnum());
			session.setAttribute("checkList", checkList);
		}
		
		return "redirect:main";
    	}

}