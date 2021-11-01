package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RevDao;
import com.example.demo.model.RevVO;

@Service
public class RevService {
	
	@Autowired
	private RevDao revDao;
	
	public List<RevVO> selectAll(){
		return revDao.selectAll();
	}
	
	public RevVO selectDetail(int rev_no) {
		return revDao.selectDetail(rev_no);
	}
	
	public int insert(RevVO paramVO) {
		return revDao.insert(paramVO);
	}
	
	public int update(RevVO paramVO) {
		return revDao.update(paramVO);
	}
	
	public int delete(int rev_no) {
		return revDao.delete(rev_no);
	}

}
