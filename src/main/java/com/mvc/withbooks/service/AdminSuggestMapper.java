package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.NovelDTO;

@Service
public class AdminSuggestMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertAdminSuggest(AdminSuggestDTO dto) {
		int res = sqlSession.insert("insertAdminSuggest", dto);
		return res;
	}
	
	public int deleteAdminSuggest(int sunum) {
		int res = sqlSession.delete("deleteAdminSuggest", sunum);
		return res;
	}
	
	public List<AdminSuggestDTO> listAdminSuggest(){
		List<AdminSuggestDTO> list = sqlSession.selectList("listAdminSuggest");
		return list;
	}
	
	public NovelDTO searchAdminSuggest(String Novel_subject) {
		NovelDTO dto = sqlSession.selectOne("searchAdminSuggest", Novel_subject);
		return dto;
	}
	
	public List<NovelDTO> listNovel(){
		List<NovelDTO> list = sqlSession.selectList("listNovel");
		return list;
	}
}
