package com.mvc.withbooks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertReview(Map<String, Object> params) {
		int res=sqlSession.insert("insertReview",params);
		return res;
	}
	
	public int updateReview(Map<String, Object> params) {
		int res=sqlSession.insert("updateReview",params);
		return res;
	}
	
	public Map<String, String> getreview(int mnum){
		Map<String, String> review = sqlSession.selectOne("getReview",mnum);
		return review;
	}
	
	public List<Map<String, String>> getReviewList(int nnum){
		List<Map<String, String>> review = sqlSession.selectList("getReviewList",nnum);
		return review;
	}
}
