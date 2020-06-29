package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.User;
import com.alan.springboot.onlineshopdemo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private RegisterService registerService;

	public RegisterController(){

	}

	@Autowired
	public RegisterController(RegisterService registerService){
		this.registerService = registerService;
	}

	@GetMapping("/showForm")
	public String showRegister(Model model){
		User user = new User();
		model.addAttribute("user",user);
		return "register";
	}

	@PostMapping("/request")
	public String sendRegister(@ModelAttribute("user") User user, HttpSession session){
		String username = user.getUsername();
		String email = user.getEmail();
		if(registerService.checkUsed(username,email).equals("unused")){
			session.setAttribute("login",username);
			registerService.addMember(user);
		return "register_request";
		}else if(registerService.checkUsed(username,email).equals("username used")){
			session.setAttribute("error","username used");
			return "redirect:/error/register";
		}else {
			session.setAttribute("error","email used");
			return "redirect:/error/register";
		}
	}
}
