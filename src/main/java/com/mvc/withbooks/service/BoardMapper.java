package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.BoardDTO;

@Service
public class BoardMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> listBoard(){
		List<BoardDTO> list = sqlSession.selectList("listBoard");
		return list;
	}
	
	public BoardDTO getBoard(int Bnum,String mode){
		if(mode.equals("content")) {
			sqlSession.update("plusCount",Bnum);
		}
		BoardDTO dto = sqlSession.selectOne("getBoard",Bnum);
		return dto;
	}
	
	public int insertBoard(BoardDTO dto) {
		int res = sqlSession.insert("insertBoard", dto);
		return res;
	}
	
	public int deleteBoard(int Bnum,String passwd) {
		BoardDTO dto = getBoard(Bnum,"passwd");
		if(!dto.getBoard_passwd().equals(passwd)) {
			return -1;
		}
		int res = sqlSession.delete("deleteBoard",Bnum);
		sqlSession.commit();
		return res;
	}
	
	public int adminDeleteBoard(int Bnum) {
		BoardDTO dto = getBoard(Bnum, "admin");
		int res = sqlSession.delete("adminDeleteBoard",Bnum);
		return res;
	}
	
	public int updateBoard(BoardDTO dto) {
		BoardDTO dto2 = getBoard(dto.getBnum(), "password");
		if (!dto.getBoard_passwd().equals(dto2.getBoard_passwd())) {
			return -1;
		}
		int res = sqlSession.update("updateBoard", dto);
		return res;
	}
	
}
