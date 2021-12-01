package com.example.demo.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CtgVO;

@Repository
public class CtgDao {
	
	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;
	
	public List<CtgVO> selectAll(){
		return sqlsessiontemplate.selectList("CtgMapper.selectAll");
	}
	
}
