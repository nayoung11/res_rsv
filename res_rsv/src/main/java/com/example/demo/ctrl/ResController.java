package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.RsVO;
import com.example.demo.service.RsService;

@RequestMapping("/res")
@Controller
public class ResController {
	
	@Autowired
	private RsService rsService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String resList(Model model) {
		
		List<RsVO> rsList = rsService.selectAll();
		
		model.addAttribute("rsList", rsList);
		
		return "res/list";
	}

	// airbnb: /rooms/번호 <-- PathVariable (경로변수)
	// 우리: /res/detail?no=123
	@RequestMapping(value = "/detail/{no}", method = RequestMethod.GET)
	public String resDetail(@PathVariable(name = "no") int no,
			Model model) {
		
		RsVO rs = rsService.selectDetail(no);
		
		if (rs != null) {
			rsService.updateRsViewCount(no);
		}
		
		model.addAttribute("rs", rs);
		model.addAttribute("rsName", rs.getNm());
		
		return "res/detail";
	}
	
	@RequestMapping(value = "/list/{no}", method = RequestMethod.GET)
	public String resList(@PathVariable(name = "no") int no,
			Model model) {
		
		RsVO rs = rsService.selectDetail(no);
		
		model.addAttribute("rs", rs);
		
		return "res/list";
	}

}
