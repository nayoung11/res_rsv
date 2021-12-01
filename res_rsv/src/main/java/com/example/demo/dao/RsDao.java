package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<RsVO> selectAllByCtgNo(String ctgNo) {
		return sqlsessiontemplate.selectList("RsMapper.selectAllByCtgNo", ctgNo);
	}

	public List<RsVO> selectAllByCtgNoPaging(String ctgNo, int pageNum) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ctgNo", ctgNo);
		param.put("pageNum", pageNum);
		
		int offset = (pageNum - 1) * 6;
		param.put("offset", offset);

		return sqlsessiontemplate.selectList("RsMapper.selectAllByCtgNoPaging", param);
	}

	public List<RsVO> selectAllPaging(int pageNum) {
		int offset = (pageNum - 1) * 6;
		return sqlsessiontemplate.selectList("RsMapper.selectAllPaging", offset);
	}

	public List<RsVO> searchListPaging(String searchKeyword, int pageNum) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searchKeyword", searchKeyword);
		
		int offset = (pageNum - 1) * 6;
		param.put("offset", offset);
		return sqlsessiontemplate.selectList("RsMapper.searchListPaging", param);
	}

}
