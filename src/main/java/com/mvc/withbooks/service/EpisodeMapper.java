package com.mvc.withbooks.service;

import java.util.LinkedHashMap;
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
	
	public List<EpisodeDTO> listNoEpisode(int nnum) {
		List<EpisodeDTO> list = sqlSession.selectList("listNoEpisode", nnum);
		return list;
	}
	
	public int deleteEpisode(int epnum) {
		int res = sqlSession.delete("deleteEpisode", epnum);
		return res;
	}
	
	public int updateEpisode(EpisodeDTO dto) {
		int res = sqlSession.update("updateEpisode", dto);
		return res;
	}
	
	public EpisodeDTO getEpisode(int epnum, String mode) {
		if (mode.equals("view")) {	//���Ǽҵ� ���� �Ѿ�� �Ǹ� ��ȸ���� ������ �ϱ� ����
			sqlSession.update("plusReadcountEpi", epnum);
		}
		EpisodeDTO dto = sqlSession.selectOne("getEpisode", epnum);
		return dto;
	}
	
	public Map<String, String> getEpisode(String Epnum) {
		Map<String, String> params = sqlSession.selectOne("getEpisodeSubject", Epnum);
		return params;
	}
	
	public Map<String, String> contentNoEpisode(int epnum) {
		Map<String, String> params = sqlSession.selectOne("contentNoEpisode", epnum);
		return params;
	}
	
	public int getEpisodeCount(int nnum) {
		int res = sqlSession.selectOne("getEpisodeCount", nnum);
		return res;
	}
	
	public List<Map<String, String>> episodeCountList(Map<String, String> params) {
		List<Map<String, String>> list = sqlSession.selectList("episodeCountList", params);
		return list;
	}
	
	public List<Map<String, String>> listEpisodeCount(int nnum) {
		List<Map<String, String>> list = sqlSession.selectList("listEpisodeCount", nnum);
		return list;
	}
	
	public List<Map<String, String>> episodeCountListReverse(Map<String, String> params) {
		List<Map<String, String>> list = sqlSession.selectList("episodeCountListReverse", params);
		return list;
	}
}
