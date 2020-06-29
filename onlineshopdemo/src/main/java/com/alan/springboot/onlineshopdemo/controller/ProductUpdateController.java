package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/update")
public class ProductUpdateController {
	private ProductService productService;

	@Autowired
	public ProductUpdateController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping("/showForm")
	public String showFormForUpdate(@RequestParam("productId") int productId, HttpSession session, Model model){
		String username = (String)session.getAttribute("login");
		Product product = productService.showProductByIdUsername(productId,username);
		product.setUsername(username);
		model.addAttribute("product",product);
		return "product_update";
	}
}
