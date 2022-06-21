package com.mvc.withbooks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.EpisodeDTO;
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
	
	public int insertPurchase(Map<String, String> params) {
		MemberDTO mdto = sqlSession.selectOne("getMember", params);
		params.put("mnum", Integer.toString(mdto.getMnum()));
		int res = sqlSession.insert("insertPurchase", params);
		return res;
	}
	

	public List<Integer> purchaseLibrary(int mnum) {
		List<Integer> list = sqlSession.selectList("purchaseLibrary", mnum);
		return list;
	}

	public List<Integer> purchaseHistoryCheckList(int mnum) {
		List<Integer> checkList=sqlSession.selectList("purchaseHistoryCheckList",mnum);
		return checkList;

	}
}