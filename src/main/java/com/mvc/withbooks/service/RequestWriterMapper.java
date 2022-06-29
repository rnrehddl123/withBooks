package com.mvc.withbooks.service;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.BoardDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NovelDTO;
import com.mvc.withbooks.dto.RequestWriterDTO;

@Service
public class RequestWriterMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<RequestWriterDTO> listRequestWriterClient(int mnum){
		List<RequestWriterDTO> list = sqlSession.selectList("listRequestWriterClient", mnum);
		return list;
	}
	
	public List<RequestWriterDTO> listRequestWriter(int start, int end){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		List<RequestWriterDTO> list = sqlSession.selectList("listRequestWriter", map);
		return list;
	}
	
	public RequestWriterDTO getRequestWriter(int Rwnum) {
		RequestWriterDTO dto = sqlSession.selectOne("getRequestWriter",Rwnum);
		return dto;
	}
	
	public int insertRequestWriter(RequestWriterDTO dto, int mnum) {
		MemberDTO mdto= sqlSession.selectOne("getMember", mnum);
		dto.setMemberDTO(mdto);
		int res = sqlSession.insert("insertRequestWriter",dto);
		return res;
	}
	
	public int updateRequestWriter(RequestWriterDTO dto) {
		RequestWriterDTO dto2 = getRequestWriter(dto.getRwnum());
		int res = sqlSession.update("updateRequestWriter", dto);
		return res;
	}
	
	public int getRequestWriterCount() {		
		int count = sqlSession.selectOne("getRequestWriterCount");
		return count;
	}
	
	public int getRequestWriterSearchCount(String search, String searchString) {
		java.util.Map<String, Object> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		int count = sqlSession.selectOne("getRequestWriterSearchCount", map);
		return count;
	}
	
	public List<RequestWriterDTO> findRequestWriter(String search, String searchString, int start, int end){
		java.util.Map<String, Object> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		map.put("start", start);
		map.put("end", end);
		List<RequestWriterDTO> find = sqlSession.selectList("findRequestWriter", map);
		return find;
	}
	
	public int upgradeClientState(int rwnum, String state) {
		java.util.Map<String, Object> map = new java.util.Hashtable<>();
		map.put("rwnum", rwnum);
		map.put("state", state);
		int res = sqlSession.update("upgradeClientState", map);
		return res;
	}
	
}
