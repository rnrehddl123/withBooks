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
		int novelCount = sqlSession.selectOne("getNovelCountMain", map);
		return novelCount;
	}
	
	public int getWriterCountMain(String searchString) {		
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("searchString", searchString);
		int writerCount = sqlSession.selectOne("getWriterCountMain", map);
		return writerCount;
	}
	
	public List<NovelDTO> listmemberNovel(int mnum) {
		List<NovelDTO> list = sqlSession.selectList("listmemberNovel", mnum);
		return list;
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
	
	public List<NovelDTO> getNovelAre(int a){
		List<NovelDTO> list = sqlSession.selectList("getNovelAre", a);
		return list;
	}
	
	public List<NovelDTO> getNovelMain(Map<Integer, Long> map){
		List<NovelDTO> list = new ArrayList<NovelDTO>();
		for(int i=0; i<map.size(); i++) {
			NovelDTO dto = sqlSession.selectOne("getNovel", map.get(i).intValue());
			list.add(dto);
		}
		return list;
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
	
	public List<NovelDTO> findWriterMain(String searchString, int start, int end){
		java.util.Map<String, Object> map = new java.util.Hashtable<>();
		map.put("searchString", searchString);
		map.put("start", start);
		map.put("end", end);
		System.out.println(searchString);
		System.out.println(start);
		System.out.println(end);
		List<NovelDTO> find = sqlSession.selectList("findWriterMain", map);
		System.out.println(find.size());
		return find;
	}
	
	public List<NovelDTO> listForCate(String selectCate){
		List<NovelDTO> listForCate = sqlSession.selectList("listForCate", selectCate);
		return listForCate;
	}
	
	public int novelCount(int mnum) {
		int res = sqlSession.selectOne("NovelCount", mnum);
		return res;
	}
	
	public List<Map<String, String>> novelCountList(Map<String, String> params) {
		List<Map<String, String>> list = sqlSession.selectList("novelCountList", params);
		return list;
	}
	
	public List<Map<String, String>> listNovelCount(int mnum) {
		List<Map<String, String>> list = sqlSession.selectList("listNovelCount", mnum);
		return list;
	}
	
	public List<NovelDTO> searchmemberNovel(String novel_memberName) {
		List<NovelDTO> list = sqlSession.selectList("searchmemberNovel", novel_memberName);
		return list;
	}
	
	public NovelDTO checkNovelMemberName(Map<String, String> params) {
		NovelDTO novelDTO = sqlSession.selectOne("checkNovelMemberName", params);
		return novelDTO;
	}
	
	
}
