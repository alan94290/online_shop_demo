package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {
	@GetMapping("/product_detail")
	public String showProductDetail(){
		return "product_detail";
	}
}
