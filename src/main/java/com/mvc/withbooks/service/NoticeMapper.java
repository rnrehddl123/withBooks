package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.NoticeDTO;

@Service
public class NoticeMapper {

	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeDTO> listBoard(){
		List<NoticeDTO> list = sqlSession.selectList("listNotice");
		return list;
	}
	
	public NoticeDTO getNotice(int Nonum,String mode) {
		if(mode.equals("contents")) {
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
		int res = sqlSession.update("updateMember",dto);
		return res;
	}
	
}
