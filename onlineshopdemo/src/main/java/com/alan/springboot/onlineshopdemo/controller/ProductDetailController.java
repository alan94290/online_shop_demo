package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {
	private ProductService productService;

	@Autowired
	public ProductDetailController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping("/product_detail")
	public String showProductDetail(int productId, Model model){
		Product product = productService.showProduct(productId);
		model.addAttribute("product",product);
		return "product_detail";
	}
}
