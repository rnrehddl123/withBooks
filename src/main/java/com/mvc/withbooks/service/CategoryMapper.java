package com.mvc.withbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.withbooks.dto.CategoryDTO;

@Service
public class CategoryMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertCategory(CategoryDTO dto) {
		int res = sqlSession.insert("insertCategory", dto);
		return res;
	}
	
	public List<CategoryDTO> listCategory(){
		List<CategoryDTO> list = sqlSession.selectList("listCategory");
		return list;
	}
	
	public String selectCate(int cnum) {
		String selectCate = sqlSession.selectOne("selectCate", cnum);
		return selectCate;
	}
	
	public CategoryDTO getCategory(String cate_name){
		CategoryDTO dto = sqlSession.selectOne("getCategory", cate_name);
		return dto;
	}
}
