package com.mvc.withbooks.service;

import java.util.HashMap;
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
	
	//아이디 찾기
	public MemberDTO findId(Map<String,String> params) {
		MemberDTO dto = sqlSession.selectOne("findId",params);
		return dto;
	}
	
	// 비밀번호 찾기
	public MemberDTO selectMember(String Member_email) {
		MemberDTO dto = sqlSession.selectOne("selectMember", Member_email);
		return dto;
	}
	
	public int pwUpdate_M(Map<String,String> params) {
		int res = sqlSession.update("pwUpdate_M",params);
		return res;
	}
	
	public boolean checkMember(Map<String, String> params) {
		MemberDTO dto = sqlSession.selectOne("checkMember", params);
		if (dto == null) return false;
		else return true;
	}
	
	public int insertMember(MemberDTO dto) {
			int res = sqlSession.insert("insertMember", dto);
			return res;
	}
	
	public List<MemberDTO> listMemberAll(){
		List<MemberDTO> list = sqlSession.selectList("listMemberAll");
		return list;
	}
	
	public List<MemberDTO> listMember(int start, int end){
			java.util.Map<String, Integer> map = new java.util.Hashtable<>();
			map.put("start", start);
			map.put("end", end);
			List<MemberDTO> list = sqlSession.selectList("listMember",map);
			return list;
	}
	
	public List<MemberDTO> listChartMember() {
		List<MemberDTO> list= sqlSession.selectList("listChartMember");
		return list;
	}
	
	
	public List<MemberDTO> listWriter(int start, int end){
		java.util.Map<String, Integer> map = new java.util.Hashtable<>();
		map.put("start", start);
		map.put("end", end);
		List<MemberDTO> list = sqlSession.selectList("listWriter",map);
		return list;
	}
	
	/*public int deleteMember(int mnum) {
			int res = sqlSession.delete("deleteMember", mnum);
			return res;
	}*/
	
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
	
	public List<MemberDTO> findWriter(String searchString, int start, int end){
		java.util.Map<String, Object> map = new java.util.Hashtable<>();
		map.put("searchString", searchString);
		map.put("start", start);
		map.put("end", end);
		List<MemberDTO> find = sqlSession.selectList("findWriter", map);
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
	
	public int updateCash(Map<String, Object> params) {
		int res = sqlSession.update("updateCash", params);
		return res;
	}
	
	public int updateAuthority(MemberDTO dto) {
		int res = sqlSession.update("updateAuthority", dto);
		return res;
	}
	
	public int purchaseCash(Map<String, String> params) {
		int res = sqlSession.update("purchaseCash", params);
		return res;
	}
	
	//페이징
	public int getMemberCount() {		
		int count = sqlSession.selectOne("getMemberCount");
		return count;
	}
	
	public int getMemberSearchCount(String search, String searchString) {		
		Map<String, String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("searchString", searchString);
		int count = sqlSession.selectOne("getMemberSearchCount", map);
		return count;
	}
	
	public int getWriterCount() {		
		int count = sqlSession.selectOne("getWriterCount");
		return count;
	}
	
	public int getWriterSearchCount(String search, String searchString) {		
		Map<String, String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("searchString", searchString);
		int count = sqlSession.selectOne("getWriterSearchCount", map);
		return count;
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
	
	public String checkKakao(String kakaoid) {
		String mnum = sqlSession.selectOne("checkKakao", kakaoid);
		return mnum;
	}
	
	public int insertKakaoMember(Map<String, Object> userInfo) {
		int res=sqlSession.insert("insertKakaoMember",userInfo);
		return res;
	}
	
	public MemberDTO loginKakao(String kakaoid){
		MemberDTO dto = sqlSession.selectOne("loginKakao", kakaoid);
		return dto;
	}
	
	public int upgradeClientOk(int mnum) {
		int res = sqlSession.update("upgradeClientOk", mnum);
		return res;
	}
	
	public int downgradeWriter(int mnum) {
		int res = sqlSession.update("downgradeWriter", mnum);
		return res;
	}
	
	public int idCheck(String member_id) {
		int result = sqlSession.selectOne("idCheck", member_id);
		return result;
	}
	
	public int emailCheck(String member_email) {
		int result = sqlSession.selectOne("emailCheck", member_email);
		return result;
	}
	
}
