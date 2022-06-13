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
	
	public EpisodeDTO getEpisode(int Epnum, String mode) {
		if (mode.equals("writerNovelEpisode")) {	//에피소드 뷰어로 넘어가게 되면 조회수가 오르게 하기 위함
			sqlSession.update("plusReadcount", Epnum);
		}
		EpisodeDTO dto = sqlSession.selectOne("getEpisode", Epnum);
		return dto;
	}
}
