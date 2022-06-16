package com.mvc.withbooks.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.dto.NoticeNovelDTO;
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
	
	public NoticeNovelDTO getNoticeNovel(Map<String, String> params){
		NoticeNovelDTO noticeNovelDTO = sqlSession.selectOne("getNoticeNovel", params);
		return noticeNovelDTO;
	}
	
	public List<NoticeNovelDTO> listNoticeNovel(int nnum){
		List<NoticeNovelDTO> list = sqlSession.selectList("listNoticeNovel", nnum);
		return list;
	}
	
}
