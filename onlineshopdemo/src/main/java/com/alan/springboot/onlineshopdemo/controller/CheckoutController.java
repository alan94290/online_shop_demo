package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CheckoutController {
	@GetMapping("/checkout")
	public String showCheckout(HttpSession session) {
		String login = (String) session.getAttribute("login");
		if (login == null) {

			return "redirect:/register/showForm";
		} else {
			return "checkout";
		}
	}
}
