package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.entity.User;
import com.alan.springboot.onlineshopdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService){
		this.loginService = loginService;
	}

	@PostMapping("/login-request")
	public String sendLogin(@ModelAttribute("user") User user,Model model){


		System.out.println(user.getUsername());
		System.out.println(user.getPassword());

		model.addAttribute("login",loginService.login(user.getUsername(),user.getPassword()));
		return "login-request";
	}
}
