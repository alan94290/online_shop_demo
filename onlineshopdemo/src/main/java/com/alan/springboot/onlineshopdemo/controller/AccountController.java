package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.User;
import com.alan.springboot.onlineshopdemo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService){
		this.accountService = accountService;
	}

	@GetMapping("/account")
	public String showAccount(HttpSession session,Model model){
		String login = (String)session.getAttribute("login");
		if(login==null){
			return "redirect:register";
		}else {
			User user = accountService.findByAccount(login);
			model.addAttribute("user",user);
			return "account";
		}
	}

	@PostMapping("/account-maintain")
	public String updateAccount(@ModelAttribute("user")User user){
		accountService.modifyMember(user);
		return "redirect:account";
	}


}
