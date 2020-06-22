package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
	@GetMapping("/checkout")
	public String showCheckout(){
		return "checkout";
	}
}
