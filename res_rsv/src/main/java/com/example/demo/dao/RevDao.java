package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RevVO;

@Repository
public class RevDao {

	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;

	public List<RevVO> selectAll() {
		return sqlsessiontemplate.selectList("RevMapper.selectAll");
	}

	public RevVO selectDetail(int rev_no) {
		return sqlsessiontemplate.selectOne("RevMapper.selectDetail", rev_no);
	}

	public int insert(RevVO paramVO) {
		return sqlsessiontemplate.insert("RevMapper.insert", paramVO);
	}

	public int update(RevVO paramVO) {
		return sqlsessiontemplate.update("RevMapper.update", paramVO);
	}

	public int delete(int rev_no) {
		return sqlsessiontemplate.delete("RevMapper.delete", rev_no);
	}

}
