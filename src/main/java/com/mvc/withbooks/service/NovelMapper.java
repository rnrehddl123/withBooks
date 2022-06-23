package com.mvc.withbooks.service;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.dto.MemberDTO;

@Service
public class NovelMapper {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insertNovel(NovelDTO dto,int mnum) {
		MemberDTO mdto = sqlSession.selectOne("getMember", mnum);
		dto.setMemberDTO(mdto);
		int res = sqlSession.insert("insertNovel", dto);
		return res;
	}
	
	public List<NovelDTO> listNovel() {
		List<NovelDTO> list = sqlSession.selectList("writerListNovel");
		return list;
	}
	
	public int getNovelCountMain(String searchString) {		
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("searchString", searchString);
		int count = sqlSession.selectOne("getNovelCountMain", map);
		return count;
	}
	
	public List<NovelDTO> listmemberNovel(int mnum) {
		List<NovelDTO> list = sqlSession.selectList("listmemberNovel", mnum);
		return list;
	}
	
	public int deleteNovel(int nnum) {
		int res = sqlSession.delete("deleteNovel", nnum);
		return res;
	}
	
	public int updateNovel(NovelDTO dto,int mnum) {
		MemberDTO mdto = sqlSession.selectOne("getMember", mnum);
		dto.setMemberDTO(mdto);
		int res = sqlSession.update("updateNovel", dto);
		return res;
	}
	
	public NovelDTO getNovel(int nnum) {
		NovelDTO dto = sqlSession.selectOne("getNovel", nnum);
		return dto;
	}
	
	public List<NovelDTO> findNovel(String search, String searchString){
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		List<NovelDTO> find = sqlSession.selectList("findNovel", map);
		return find;
	}
	
	public List<NovelDTO> findNovelMain(String searchString, int start, int end){
		java.util.Map<String, Object> map = new java.util.Hashtable<>();
		map.put("searchString", searchString);
		map.put("start", start);
		map.put("end", end);
		List<NovelDTO> find = sqlSession.selectList("findNovelMain", map);
		return find;
	}
	
	public List<NovelDTO> listForCate(String selectCate){
		List<NovelDTO> listForCate = sqlSession.selectList("listForCate", selectCate);
		return listForCate;
	}
}
