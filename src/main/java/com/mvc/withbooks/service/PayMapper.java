package com.mvc.withbooks.service;

import java.util.List;
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
	
	public List<PayDTO> listPay(int start, int end){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		List<PayDTO> list = sqlSession.selectList("listPay", map);
		return list;
	}
	
	public int getPayCount() {		
		int count = sqlSession.selectOne("getPayCount");
		return count;
	}
}
