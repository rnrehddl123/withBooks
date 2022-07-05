package com.mvc.withbooks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.ReviewDTO;

@Service
public class ReviewMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReviewDTO> listRecommend(int mnum){
		List<ReviewDTO> list = sqlSession.selectList("listRecommend", mnum);
		return list;
	}
	
	public List<ReviewDTO> listReview(){
		List<ReviewDTO> list = sqlSession.selectList("listReview");
		return list;
	}
	
	public int insertReview(Map<String, Object> params) {
		int res=sqlSession.insert("insertReview",params);
		return res;
	}
	
	public int updateReview(Map<String, Object> params) {
		int res=sqlSession.insert("updateReview",params);
		return res;
	}
	
	public Map<String, String> getreview(Map<String, Object> params){
		Map<String, String> review = sqlSession.selectOne("getReview",params);
		return review;
	}
	
	public List<Map<String, String>> getReviewList(int nnum){
		List<Map<String, String>> review = sqlSession.selectList("getReviewList",nnum);
		return review;
	}
}
