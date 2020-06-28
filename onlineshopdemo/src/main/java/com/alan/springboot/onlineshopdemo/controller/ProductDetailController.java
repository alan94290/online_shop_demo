package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductDetailController {
	private ProductService productService;

	@Autowired
	public ProductDetailController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping("/product-detail")
	public String showProductDetail(int productId, Model model){
		Product product = productService.showProduct(productId);
		model.addAttribute("product",product);
		return "product-detail";
	}

	@GetMapping("/product-list")
	public String showAllProduct(Model model, HttpSession session){
		String username = (String) session.getAttribute("login");
		List<Product> productList = productService.showProductByUsername(username);
		model.addAttribute("productList",productList);
		return "product-list";
	}
}
