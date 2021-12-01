package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RsSnsDao;
import com.example.demo.model.RsSnsVO;

@Service
public class RsSnsService {

	@Autowired
	private RsSnsDao rsSnsDao;

	public List<RsSnsVO> selectAllByRsNo(int rsNo) {
		return rsSnsDao.selectAllByRsNo(rsNo);
	}
}
