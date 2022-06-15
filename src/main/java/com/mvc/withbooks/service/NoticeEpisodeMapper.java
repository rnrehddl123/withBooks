package com.mvc.withbooks.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;

@Service
public class NoticeEpisodeMapper {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int sendNoticeEpisode(EpisodeDTO epdto) {
		NoticeEpisodeDTO dto = new NoticeEpisodeDTO();
		dto.setEpisodeDTO(epdto);
		int res = sqlSession.insert("sendNoticeEpisode", dto);
		return res;
	}
	
	
	public List<NoticeEpisodeDTO> sendNoticeList(MemberDTO dto) {
		List<NoticeEpisodeDTO> list = sqlSession.selectList("sendNoticeList", dto);
		System.out.println(list.get(0).getSendTime());
		return list;
	}
	
	
	
	
}
