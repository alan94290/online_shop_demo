package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String requestLogout(HttpSession session){
		session.invalidate();
		return "redirect:index";
	}
}
