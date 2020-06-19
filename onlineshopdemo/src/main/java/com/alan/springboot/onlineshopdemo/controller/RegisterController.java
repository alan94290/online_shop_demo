package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {
	@GetMapping("/register")
	public String getRegister(){
		return "register-form";
	}
	@PostMapping("/registerconfirm")
	public String registerConfirm(@RequestParam Register register, Model model){
		model.addAttribute("register",register);
		return "register-confirm";
	}
}
