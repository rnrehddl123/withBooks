package com.mvc.withbooks.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.dto.NovelDTO;

@Service
public class EpisodeMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertEpisode(EpisodeDTO dto,int nnum) {
		NovelDTO novelDTO=sqlSession.selectOne("getNovel", nnum);
		dto.setNovelDTO(novelDTO);
		int res = sqlSession.insert("insertEpisode", dto);
		return res;
	}
	
	
	public List<EpisodeDTO> listEpisode(int nnum) {
		List<EpisodeDTO> list = sqlSession.selectList("listEpisode", nnum);
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
		if (mode.equals("writerNovelEpisode")) {	//���Ǽҵ� ���� �Ѿ�� �Ǹ� ��ȸ���� ������ �ϱ� ����
			sqlSession.update("plusReadcount", Epnum);
		}
		EpisodeDTO dto = sqlSession.selectOne("getEpisode", Epnum);
		return dto;
	}
	
	public Map<String, String> getEpisode(String Epnum) {
		Map<String, String> params = sqlSession.selectOne("getEpisodeSubject", Epnum);
		return params;
	}
}
