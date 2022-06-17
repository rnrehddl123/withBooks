package com.mvc.withbooks;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.service.AdminSlideMapper;
import com.mvc.withbooks.service.AdminSuggestMapper;
import com.mvc.withbooks.service.NovelMapper;

@Controller
public class MainController {
	
	@Autowired
	private AdminSlideMapper adminSlideMapper;
	@Autowired
	private AdminSuggestMapper adminSuggestMapper;
	@Autowired
	private NovelMapper novelMapper;
	
	
	
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
