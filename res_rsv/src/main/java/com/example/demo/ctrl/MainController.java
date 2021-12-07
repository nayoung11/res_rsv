package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.RsVO;
import com.example.demo.service.RsService;


@Controller
public class MainController {
	
	@Autowired
	private RsService rsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<RsVO> randomRsList = rsService.selectRandomRs();
		
		model.addAttribute("randomRsList", randomRsList);
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "res/test";
	}

}
