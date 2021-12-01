package com.example.demo.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.MbrVO;
import com.example.demo.model.RsSnsVO;
import com.example.demo.model.RsVO;
import com.example.demo.service.MbrService;
import com.example.demo.service.RsService;
import com.example.demo.service.RsSnsService;

@RequestMapping("/res")
@Controller
public class ResController {
	
	@Autowired
	private RsService rsService;
	
	@Autowired
	private RsSnsService rsSnsService;
	
	@Autowired
	private MbrService mbrService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String resList(Model model, HttpServletRequest req) {
		
		String pageNumStr = req.getParameter("pageNum");
		if (pageNumStr == null) {
			pageNumStr = "1";
		}
		int pageNum = Integer.parseInt(pageNumStr);

		String ctgNo = req.getParameter("ctgNo");
		List<RsVO> rsList;
		if (ctgNo != null) {
			rsList = rsService.selectAllByCtgNoPaging(ctgNo, pageNum);
		} else {
			rsList = rsService.selectAllPaging(pageNum);
		}
		
		
		model.addAttribute("rsList", rsList);
		model.addAttribute("ctgNo", ctgNo);
		
		return "res/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list/ajax", method = RequestMethod.GET)
	public List<RsVO> resListAjax(Model model, HttpServletRequest req) {
		
		String pageNumStr = req.getParameter("pageNum");
		if (pageNumStr == null) {
			pageNumStr = "1";
		}
		int pageNum = Integer.parseInt(pageNumStr);

		String ctgNo = req.getParameter("ctgNo");
		List<RsVO> rsList;
		if (ctgNo != null) {
			rsList = rsService.selectAllByCtgNoPaging(ctgNo, pageNum);
		} else {
			rsList = rsService.selectAllPaging(pageNum);
		}

		return rsList;
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
		
		List<RsSnsVO> rsSnsList = rsSnsService.selectAllByRsNo(no);
		
		model.addAttribute("rs", rs);
		model.addAttribute("rsName", rs.getNm());
		model.addAttribute("rsSnsList", rsSnsList);
		
		return "res/detail";
	}
	
	@RequestMapping(value = "/list/{no}", method = RequestMethod.GET)
	public String resList(@PathVariable(name = "no") int no,
			Model model) {
		
		RsVO rs = rsService.selectDetail(no);
		
		model.addAttribute("rs", rs);
		
		return "res/list";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, @RequestParam("searchKeyword") String searchKeyword) {
		List<RsVO> searchRsList = rsService.searchListPaging(searchKeyword, 1);

		model.addAttribute("searchRsList", searchRsList);
		model.addAttribute("searchKeyword", searchKeyword);
		return "res/search";
	}
	
	@ResponseBody
	@RequestMapping(value = "/search/ajax", method = RequestMethod.GET)
	public List<RsVO> searchAjax(@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam("pageNum") String pageNumStr) {
		int pageNum = Integer.parseInt(pageNumStr);
		List<RsVO> searchRsList = rsService.searchListPaging(searchKeyword, pageNum);
		
		return searchRsList;
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(Model model) {
		List<RsVO> randomRsList = rsService.selectRandomRs();
		
		model.addAttribute("randomRsList", randomRsList);
		return "res/cart";
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String email(Model model) {
		
		return "res/email";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		List<RsVO> randomRsList = rsService.selectRandomRs();
		
		model.addAttribute("randomRsList", randomRsList);
		return "res/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinProcess(@ModelAttribute MbrVO paramVO) {
		mbrService.insert(paramVO);

		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		List<RsVO> randomRsList = rsService.selectRandomRs();
		
		model.addAttribute("randomRsList", randomRsList);
		return "res/login";
	}


}
