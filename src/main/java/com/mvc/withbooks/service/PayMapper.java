package com.mvc.withbooks.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.PayDTO;

@Service
public class PayMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertPay(Map<String, Object> params) {
		MemberDTO mdto = sqlSession.selectOne("getMember", params);
		params.put("mnum", Integer.toString(mdto.getMnum()));
		int res = sqlSession.insert("insertPay", params);
		return res;
	}
}
