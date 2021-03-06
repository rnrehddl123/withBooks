package com.mvc.withbooks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.EpisodeDTO;
import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NoticeEpisodeDTO;
import com.mvc.withbooks.dto.NoticeNovelDTO;

@Service
public class NoticeEpisodeMapper {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int sendNoticeEpisode(EpisodeDTO epdto) {
		HashMap<String,Object> params=new HashMap<String, Object>();
		params.put("epdto", epdto);
		List<Integer> list=sqlSession.selectList("listNoticeNovel", epdto.getNovelDTO().getNnum());
		if(list.size()==0) {
			return 0;
		}
		params.put("list",list);
		int res = sqlSession.insert("sendNoticeEpisode", params);
		return res;
	}
	
	
	public List<NoticeEpisodeDTO> sendNoticeList(MemberDTO dto) {
		List<NoticeEpisodeDTO> list = sqlSession.selectList("sendNoticeList", dto);
		return list;
	}
	
	
	public List<HashMap<String, String>> getNoticeEpisodeMsg(int mnum){
		List<HashMap<String, String>> list = sqlSession.selectList("getNoticeEpisodeMsg", mnum);
		return list;
	}
	
	public int deleteNoticeEpisode(Map<String, Integer> params){
		int res = sqlSession.delete("deleteNoticeEpisode", params);
		return res;
	}
	
}
