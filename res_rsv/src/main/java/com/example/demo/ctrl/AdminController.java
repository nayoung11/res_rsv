package com.example.demo.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.dto.LoginReqDTO;
import com.example.demo.util.AjaxResult;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session) {
		if (session.getAttribute("adminLoginYn") != null) {
			return "admin/home";
		} else {
			return "admin/index";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AjaxResult loginProcess(@ModelAttribute LoginReqDTO reqDTO,
			HttpSession session) {
		AjaxResult res = new AjaxResult();
		
		if ("admin".equals(reqDTO.getUsername())) {
			if ("1234".equals(reqDTO.getPassword())) {
				res.setCode(0);
				res.setResult(true);
				res.setMessage("로그인 성공");
				session.setAttribute("adminLoginYn", "Y");
			} else {
				res.setCode(1);
				res.setResult(false);
				res.setMessage("비밀번호가 틀렸습니다.");
			}
		} else {
			res.setCode(2);
			res.setResult(false);
			res.setMessage("아이디가 틀렸습니다.");
		}

		return res;
	}
}