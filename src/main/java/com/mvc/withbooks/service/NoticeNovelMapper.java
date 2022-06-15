package com.mvc.withbooks.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.dto.NoticeNobelDTO;
import com.mvc.withbooks.dto.NovelDTO;

@Service
public class NoticeNovelMapper {
	
	@Autowired
	private SqlSession sqlSession;

	public int insertNoticeNovel(Map<String, Integer> params){
		int res = sqlSession.insert("insertNoticeNovel", params);
		return res;
	}
	
	public int deleteNoticeNovel(Map<String, Integer> params){
		int res = sqlSession.delete("deleteNoticeNovel", params);
		return res;
	}
}
