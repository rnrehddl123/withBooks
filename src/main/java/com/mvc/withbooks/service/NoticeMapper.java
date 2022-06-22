package com.mvc.withbooks.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.NoticeDTO;
import com.mvc.withbooks.dto.NovelDTO;

@Service
public class NoticeMapper {

	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeDTO> listNotice(int start, int end){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		List<NoticeDTO> list = sqlSession.selectList("listNotice", map);
		return list;
	}
	
	public NoticeDTO getNotice(int Nonum,String mode) {
		if(mode.equals("content")) {
			sqlSession.update("plusReadcount",Nonum);
		}
		NoticeDTO dto = sqlSession.selectOne("getNotice",Nonum);
		return dto;
	}
	
	public int insertNotice(NoticeDTO dto) {
		int res = sqlSession.insert("insertNotice",dto);
		return res;
	}
	
	public int deleteNotice(int Nonum) {
		int res = sqlSession.delete("deleteNotice",Nonum);
		return res;
	}
	
	public int updateNotice(NoticeDTO dto) {
		int res = sqlSession.update("updateNotice",dto);
		return res;
	}
	
	public List<NoticeDTO> findNotice(String search, String searchString){
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		List<NoticeDTO> find = sqlSession.selectList("findNotice", map);
		return find;
	}
	
	public int getNoticeCount() {		
		int count = sqlSession.selectOne("getNoticeCount");
		return count;
	}
	
}
