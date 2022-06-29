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
	
	public List<Map<String, String>> listPurchaseHistory(int mnum){
		List<Map<String, String>> list = sqlSession.selectList("purchaseHistoryList", mnum);
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
	
	public int getPurchaseHistoryCount(int mnum) {
		int res = sqlSession.selectOne("getPurchaseHistoryCount", mnum);
		return res;
	}
	
	public List<Map<String, String>> purchaseList(Map<String, String> params) {
		List<Map<String, String>> list = sqlSession.selectList("purchaseList", params);
		return list;
	}
	
	public int getEpisaleCount(int epnum) {
		int res = sqlSession.selectOne("getEpisaleCount", epnum);
		return res;
	}
	
	public int getNovelsaleCount(int nnum) {
		int res = sqlSession.selectOne("getNovelsaleCount", nnum);
		return res;
	}
	
	public PurchaseHistoryDTO chart(int mnum) {
		PurchaseHistoryDTO dto = sqlSession.selectOne("chart", mnum);
		return dto;
	}
}