package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RsVO;
import com.example.demo.util.Constant;

@Repository
public class RsDao {

	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;

	public List<RsVO> selectAll() {
		return sqlsessiontemplate.selectList("RsMapper.selectAll");
	}

	public RsVO selectDetail(int no) {
		return sqlsessiontemplate.selectOne("RsMapper.selectDetail", no);
	}

	public int insert(RsVO paramVO) {
		return sqlsessiontemplate.insert("RsMapper.insert", paramVO);
	}

	public int update(RsVO paramVO) {
		return sqlsessiontemplate.update("RsMapper.update", paramVO);
	}

	public int delete(int no) {
		return sqlsessiontemplate.delete("RsMapper.delete", no);
	}
	
	public List<RsVO> selectRandomRs() {
		return sqlsessiontemplate.selectList("RsMapper.selectRandomRs", Constant.RANDOM_COUNT);
	}

	public int updateRsViewCount(int no) {
		return sqlsessiontemplate.update("RsMapper.updateRsViewCount", no);
	}

}
