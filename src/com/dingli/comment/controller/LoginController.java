package com.dingli.comment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingli.comment.bean.Member;
import com.dingli.comment.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/preLogin")
	public String preLogin(){
		return "login";
	}
	
	@RequestMapping("/checkLogin")
	public String login(Member m){
		if(loginService.checkLogin(m))
		{
		return "index";
		}
		return "login";
	}

}
