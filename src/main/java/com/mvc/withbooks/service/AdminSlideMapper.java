package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.AdminSlideDTO;

@Service
public class AdminSlideMapper {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertAdminSlide(AdminSlideDTO dto) {
		int res = sqlSession.insert("insertAdminSlide", dto);
		return res;
	}
	
	public AdminSlideDTO getAdminSlide(int snum) {
		AdminSlideDTO dto = sqlSession.selectOne("getAdminSlide", snum);
		return dto;
	}
	
	public List<AdminSlideDTO> listSlide(){
		List<AdminSlideDTO> list = sqlSession.selectList("listSlide");
		return list;
	}

}
