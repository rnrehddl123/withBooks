package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.EpisodeDTO;

@Service
public class EpisodeMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insertEpisode(EpisodeDTO dto) {
		int res = sqlSession.insert("insertEpisode", dto);
		return res;
	}
	
	public List<EpisodeDTO> listEpisode() {
		List<EpisodeDTO> list = sqlSession.selectList("listEpisode");
		return list;
	}
	
	public int deleteEpisode(int Epnum) {
		int res = sqlSession.delete("deleteEpisode", Epnum);
		return res;
	}
	
	public int updateEpisode(EpisodeDTO dto) {
		int res = sqlSession.update("updateEpisode", dto);
		return res;
	}
	
	public EpisodeDTO getEpisode(int Epnum) {
		EpisodeDTO dto = sqlSession.selectOne("getEpisode", Epnum);
		return dto;
	}
}
