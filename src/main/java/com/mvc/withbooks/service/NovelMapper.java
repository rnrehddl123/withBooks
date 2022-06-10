package com.mvc.withbooks.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;

@Service
public class NovelMapper {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertMember(MemberDTO dto) {
		int res = sqlSession.insert("insertMember", dto);
		return res;
}
}
