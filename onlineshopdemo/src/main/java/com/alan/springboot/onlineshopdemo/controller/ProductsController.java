package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
	@GetMapping("/products")
	public String showProducts(){
		return "products";
	}
}
