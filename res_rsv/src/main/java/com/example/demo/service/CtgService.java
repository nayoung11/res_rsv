package com.example.demo.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CtgDao;
import com.example.demo.model.CtgVO;

@Service
public class CtgService {
	@Autowired
	private CtgDao ctgDao;
	
	public List<CtgVO> selectAll(){
		return ctgDao.selectAll();
	}

	
	

}
