package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	@GetMapping("/error-page")
	public String sendLoginError(){
		return "login-error";
	}

	@GetMapping("register-error")
	public String sendRegisterError(){
		return "register-error";
	}
}
