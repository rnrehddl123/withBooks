package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.PurchaseHistoryDTO;

@Service
public class PurchaseHistoryMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<PurchaseHistoryDTO> listPurchaseHistory(){
		List<PurchaseHistoryDTO> list = sqlSession.selectList("listPurchaseHistory");
		return list;
	}
	
	public int insertPurchase(PurchaseHistoryDTO dto, int mnum) {
		MemberDTO mdto = sqlSession.selectOne("getMember", mnum);
		dto.setMemberDTO(mdto);
		int res = sqlSession.insert("insertPurchase", mnum);
		return res;
	}
}