package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.withbooks.dto.PurchaseHistoryDTO;

public class PurchaseHistoryMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<PurchaseHistoryDTO> listMember(){
		List<PurchaseHistoryDTO> list = sqlSession.selectList("listPurchaseHistory");
		return list;
	}
	
}