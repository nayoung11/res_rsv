package com.example.demo.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.CtgVO;
import com.example.demo.service.CtgService;

@Component
public class CtgUtil {
	@Autowired
	private CtgService ctgService;

	public static List<CtgVO> CTG_LIST;

	@PostConstruct
	public void getCategoryList() {
		CTG_LIST = ctgService.selectAll();
	}
}
