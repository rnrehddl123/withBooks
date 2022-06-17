package com.mvc.withbooks.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;
import com.mvc.withbooks.dto.NovelDTO;	

@Service
public class MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean checkMember(Map<String, String> params) {
		MemberDTO dto = sqlSession.selectOne("checkMember", params);
		if (dto == null) return false;
		else return true;
	}
	
	public int insertMember(MemberDTO dto) {
			int res = sqlSession.insert("insertMember", dto);
			return res;
	}
	
	public List<MemberDTO> listMember(){
			List<MemberDTO> list = sqlSession.selectList("listMember");
			return list;
	}
	
	public int deleteMember(int mnum) {
			int res = sqlSession.delete("deleteMember", mnum);
			return res;
	}
	
	public MemberDTO getMember(int mnum){
			MemberDTO dto = sqlSession.selectOne("getMember", mnum);
			return dto;
	}
	
	public MemberDTO getMember(String Member_id){
			MemberDTO dto = sqlSession.selectOne("getMemberId", Member_id);
			return dto;
	}
	
	public int updateMember(MemberDTO dto) {
			int res = sqlSession.update("updateMember", dto);
			return res;
	}
	
	public List<MemberDTO> findMember(String search, String searchString){
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		List<MemberDTO> find = sqlSession.selectList("findMember", map);
		return find;
	}
	
	public String searchMember(Map<String, String> params) {
		String sql = null;
		
			if (!params.containsKey("id")) {
				sql = "select * from member where Member_name='"+params.get("Member_name") 
						+ "' and Member_Tel='"+params.get("Member_Tel") + "' and Member_address='"+params.get("Member_address")+"'";
				params.put("sql", sql);
				MemberDTO dto = sqlSession.selectOne("searchMember", params);
				if (dto == null) return "�ԷµȰ��� ��ġ�ϴ� �����Ͱ� �����ϴ�.";
				return "���̵�� " + dto.getMember_id() +" �Դϴ�.";
			}else {
				sql = "select * from member where Member_name='"+params.get("Member_name") 
						+ "' and Member_Tel='"+params.get("Member_Tel") + "' and Member_address='"+params.get("Member_address")+"' and Member_id='"+params.get("Member_id")+"'";
				params.put("sql", sql);
				MemberDTO dto = sqlSession.selectOne("searchMember", params);
				if (dto == null) return "�ԷµȰ��� ��ġ�ϴ� �����Ͱ� �����ϴ�.";
				return "��й�ȣ�� " + dto.getMember_passwd() + " �Դϴ�.";
			}
	}
	
	public int updateCash(Map<String, String> params) {
		int res = sqlSession.update("updateCash", params);
		return res;
	}
	
	public int updateAuthority(MemberDTO dto) {
		int res = sqlSession.update("updateAuthority", dto);
		return res;
	}
	
	public List<NovelDTO> searchNovelSubject(String searchString){
		Map<String, String> map = new Hashtable<>();
		map.put("searchString", searchString);
		List<NovelDTO> searchNovelSubject = sqlSession.selectList("searchNovelSubject", map);
		return searchNovelSubject;
	}
	
	public List<NovelDTO> searchNovelMemberName(String searchString){
		Map<String, String> map = new Hashtable<>();
		map.put("searchString", searchString);
		List<NovelDTO> searchNovelMemberName = sqlSession.selectList("searchNovelMemberName", map);
		return searchNovelMemberName;
	}
}
