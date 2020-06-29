package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
	private ProductService productService;

	@Autowired
	public IndexController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping("/")
	public String redirectIndex(){
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String showIndex(Model model){
		List<Product> productList =  productService.findAll();
		model.addAttribute("products",productList);
		return "index";
	}
}
