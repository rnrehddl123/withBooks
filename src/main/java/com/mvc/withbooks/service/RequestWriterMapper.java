package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.RequestWriterDTO;

@Service
public class RequestWriterMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<RequestWriterDTO> listRequestWriter(){
		List<RequestWriterDTO> list = sqlSession.selectList("listRequestWriter");
		return list;
	}
	
	public RequestWriterDTO getRequestWriter(int Rwnum) {
		RequestWriterDTO dto = sqlSession.selectOne("getRequestWriter",Rwnum);
		return dto;
	}
	
	public int insertRequestWriter(RequestWriterDTO dto) {
		int res = sqlSession.insert("inserRequestWriter",dto);
		return res;
	}
	
	public int deleteRequestWriter(int Rwnum) {
		RequestWriterDTO dto = getRequestWriter(Rwnum);
		int res = sqlSession.delete("deleteRequestWriter",Rwnum);
		return res;
	}
	
	public int updateRequestWriter(RequestWriterDTO dto) {
		RequestWriterDTO dto2 = getRequestWriter(dto.getRwnum());
		int res = sqlSession.update("updateRequestWriter", dto);
		return res;
	}
	
}
