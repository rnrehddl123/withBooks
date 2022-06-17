package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.AdminSlideDTO;
import com.mvc.withbooks.dto.AdminSuggestDTO;
import com.mvc.withbooks.dto.NovelDTO;

@Service
public class AdminSuggestMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertAdminSuggest(AdminSuggestDTO dto,int nnum) {
		NovelDTO ndto= sqlSession.selectOne("getNovel", nnum);
		dto.setNovelDTO(ndto);
		int res = sqlSession.insert("insertAdminSuggest", dto);
		return res;
	}
	
	public int deleteAdminSuggest(int sunum) {
		int res = sqlSession.delete("deleteAdminSuggest", sunum);
		return res;
	}
	
	public List<AdminSuggestDTO> listAdminSuggestMain(){
		List<AdminSuggestDTO> list = sqlSession.selectList("listAdminSuggestMain");
		return list;
	}
	
	public List<AdminSuggestDTO> listAdminSuggest(int start, int end){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		List<AdminSuggestDTO> list = sqlSession.selectList("listAdminSuggest", map);
		return list;
	}
	
	public List<AdminSuggestDTO> findAdminSuggest(String search, String searchString) {
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		List<AdminSuggestDTO> find = sqlSession.selectList("findAdminSuggest", map);
		return find;
	}
	
	public List<NovelDTO> findNovelAdmin(String search, String searchString) {
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		List<NovelDTO> find = sqlSession.selectList("findNovelAdmin", map);
		return find;
	}
	
	public List<NovelDTO> listNovel(int start, int end){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		List<NovelDTO> list = sqlSession.selectList("listNovel", map);
		return list;
	}
	
	public int getSuggestCount() {		
		int count = sqlSession.selectOne("getSuggestCount");
		return count;
	}
	
	public int getNovelCount() {		
		int count = sqlSession.selectOne("getNovelCount");
		return count;
	}
}
