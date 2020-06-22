package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping("/cart")
	public String showCart(){
		return "cart";
	}

	@GetMapping("/header")
	public String showHeader(){
		return "header";
	}

	@GetMapping("/footer")
	public String showFooter(){
		return "footer";
	}

	@GetMapping("/test")
	public String showTest(){
		return "test";
	}
}
