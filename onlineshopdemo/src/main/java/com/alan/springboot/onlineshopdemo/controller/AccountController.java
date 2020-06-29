package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.User;
import com.alan.springboot.onlineshopdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService){
		this.accountService = accountService;
	}

	@GetMapping("/maintain")
	public String showAccount(HttpSession session,Model model){
		String login = (String)session.getAttribute("login");
		if(login==null){
			return "redirect:/register/showForm";
		}else {
			User user = accountService.findByUsername(login);
			model.addAttribute("user",user);
			return "account";
		}
	}

	@PostMapping("/sendAccountModify")
	public String updateAccount(@ModelAttribute("user")User user){
		accountService.modifyMember(user);
		return "redirect:/account/maintain";
	}

}
