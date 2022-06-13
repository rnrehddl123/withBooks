package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.NovelDTO;

@Service
public class NovelMapper {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insertNovel(NovelDTO dto) {
		int res = sqlSession.insert("insertNovel", dto);
		return res;
	}
	
	public List<NovelDTO> listNovel() {
		List<NovelDTO> list = sqlSession.selectList("listNovel");
		return list;
	}
	
	public int deleteNovel(int nnum) {
		int res = sqlSession.delete("deleteNovel", nnum);
		return res;
	}
	
	public int updateNovel(NovelDTO dto) {
		int res = sqlSession.update("updateNovel", dto);
		return res;
	}
	
	public NovelDTO getNovel(int nnum) {
		NovelDTO dto = sqlSession.selectOne("getNovel", nnum);
		return dto;
	}
	
}
