package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RsSnsVO;

@Repository
public class RsSnsDao {

	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;

	public List<RsSnsVO> selectAllByRsNo(int rsNo) {
		return sqlsessiontemplate.selectList("RsSnsMapper.selectAllByRsNo", rsNo);
	}
}
