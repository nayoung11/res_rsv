package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RsDao;
import com.example.demo.model.RsVO;
import com.example.demo.util.Constant;

@Service
public class RsService {
	
	@Autowired
	private RsDao rsDao;
	
	public List<RsVO> selectAll(){
		return rsDao.selectAll();
	}
	
	public RsVO selectDetail(int no) {
		return rsDao.selectDetail(no);
	}
	
	public int insert(RsVO paramVO) {
		return rsDao.insert(paramVO);
	}
	
	public int update(RsVO paramVO) {
		return rsDao.update(paramVO);
	}
	
	public int delete(int no) {
		return rsDao.delete(no);
	}
	
	public List<RsVO> selectRandomRs() {
		return rsDao.selectRandomRs();
	}
	
	public int updateRsViewCount(int no) {
		return rsDao.updateRsViewCount(no);
	}

	public List<RsVO> selectAllByCtgNo(String ctgNo) {
		return rsDao.selectAllByCtgNo(ctgNo);
	}

	public List<RsVO> selectAllByCtgNoPaging(String ctgNo, int pageNum) {
		return rsDao.selectAllByCtgNoPaging(ctgNo, pageNum);
	}

	public List<RsVO> selectAllPaging(int pageNum) {
		return rsDao.selectAllPaging(pageNum);
	}

	public List<RsVO> searchListPaging(String searchKeyword, int i) {
		return rsDao.searchListPaging(searchKeyword, i);
	}

}
