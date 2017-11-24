package com.lc.info.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lc.info.base.BaseController;
import com.lc.info.utils.CookieUtil;
@Controller
public class IndexContoller extends BaseController {
	@RequestMapping("index")
	public String index(){
		return "login";
	}
	
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest request,Model model){
		String userName = CookieUtil.getCookieValue(request, "userName");
		model.addAttribute("userName", userName);
		String trueName = CookieUtil.getCookieValue(request, "trueName");
		model.addAttribute("trueName", trueName);
		return "main";
	}
}
