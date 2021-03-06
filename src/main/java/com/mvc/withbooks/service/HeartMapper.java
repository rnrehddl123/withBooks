package com.mvc.withbooks.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.BoardDTO;
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
		int res = sqlSession.delete("deleteHeart",params);
		return res;
	}
	
	public int deleteHeartHeart(Map<String, Integer> params) {
		int res = sqlSession.delete("deleteHeartHeart",params);
		return res;
	}
	
	public List<HeartDTO> listHeart(int start, int end, int mnum){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		map.put("mnum", mnum);
		List<HeartDTO> list = sqlSession.selectList("listHeart", map);
		return list;
	}
	
	public HeartDTO getHeart(Map<String, String> params){
		HeartDTO heartDTO = sqlSession.selectOne("getHeart", params);
		return heartDTO;
	}
	
	public int getHeartCount() {		
		int count = sqlSession.selectOne("getHeartCount");
		return count;
	}
	
	public List<HeartDTO> findHeart(String searchString){
		List<HeartDTO> find = sqlSession.selectList("findHeart", searchString);
		return find;
	}
}
