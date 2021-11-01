package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MbrVO;

@Repository
public class MbrDao {

	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;

	public List<MbrVO> selectAll() {
		return sqlsessiontemplate.selectList("MbrMapper.selectAll");
	}

	public MbrVO selectDetail(String id) {
		return sqlsessiontemplate.selectOne("MbrMapper.selectDetail", id);
	}

	public int insert(MbrVO paramVO) {
		return sqlsessiontemplate.insert("MbrMapper.insert", paramVO);
	}

	public int update(MbrVO paramVO) {
		return sqlsessiontemplate.update("MbrMapper.update", paramVO);
	}

	public int delete(String id) {
		return sqlsessiontemplate.delete("MbrMapper.delete", id);
	}

}
