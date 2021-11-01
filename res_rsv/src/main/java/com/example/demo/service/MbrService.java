package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MbrDao;
import com.example.demo.model.MbrVO;

@Service
public class MbrService {
	
	@Autowired
	private static MbrDao mbrDao;
	
	public List<MbrVO> selectAll(){
		return mbrDao.selectAll();
	}
	
	public MbrVO selectDetail(String id) {
		return mbrDao.selectDetail(id);
	}
	
	public int insert(MbrVO paramVO) {
		return mbrDao.insert(paramVO);
	}
	
	public int update(MbrVO paramVO) {
		return mbrDao.update(paramVO);
	}
	
	public int delete(String id) {
		return mbrDao.delete(id);
	}

}
