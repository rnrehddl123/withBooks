package com.mvc.withbooks.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.HeartDTO;
import com.mvc.withbooks.dto.NoticeNovelDTO;

@Service
public class HeartMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertHeart(Map<String, Integer> params) {
		int res = sqlSession.insert("insertHeart",params);
		return res;
	}
	
	public int deleteHeart(Map<String, Integer> params) {
		int res = sqlSession.delete("deleteHeart");
		return res;
	}
	
	public List<HeartDTO> listHeart(int nnum){
		List<HeartDTO> list = sqlSession.selectList("listHeart", nnum);
		return list;
	}
	
	public HeartDTO getHeart(Map<String, String> params){
		HeartDTO heartDTO = sqlSession.selectOne("getHeart", params);
		return heartDTO;
	}
}
