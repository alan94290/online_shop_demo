package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String redirectIndex(){
		return "redirect:index";
	}
	@GetMapping("/index")
	public String showIndex(){
		return "index";
	}
}
