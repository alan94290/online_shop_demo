package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.User;
import com.alan.springboot.onlineshopdemo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
	private RegisterService registerService;

	public RegisterController(){

	}

	@Autowired
	public RegisterController(RegisterService registerService){
		this.registerService = registerService;
	}

	@GetMapping("/register")
	public String showRegister(Model model){
		User user = new User();
		model.addAttribute("user",user);
		return "register";
	}

	@PostMapping("/register-request")
	public String sendRegister(@ModelAttribute("user") User user){
		registerService.addMember(user);
		return "register-request";
	}
}
