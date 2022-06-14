package com.mvc.withbooks.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.MemberDTO;	

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
				if (dto == null) return "입력된값과 일치하는 데이터가 없습니다.";
				return "아이디는 " + dto.getMember_id() +" 입니다.";
			}else {
				sql = "select * from member where Member_name='"+params.get("Member_name") 
						+ "' and Member_Tel='"+params.get("Member_Tel") + "' and Member_address='"+params.get("Member_address")+"' and Member_id='"+params.get("Member_id")+"'";
				params.put("sql", sql);
				MemberDTO dto = sqlSession.selectOne("searchMember", params);
				if (dto == null) return "입력된값과 일치하는 데이터가 없습니다.";
				return "비밀번호는 " + dto.getMember_passwd() + " 입니다.";
			}
	}
	
	public int updateCash(Map<String, Integer> params) {
		int res = sqlSession.update("updateCash", params);
		return res;
	}
}
