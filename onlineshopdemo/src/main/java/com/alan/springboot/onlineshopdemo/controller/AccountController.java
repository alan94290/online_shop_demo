package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AccountController {

	@GetMapping("/account")
	public String showAccount(@ModelAttribute("login") String username, User user, Model model){
		model.addAttribute("login",username);
		model.addAttribute("user",user);
		return "account";
	}
}
