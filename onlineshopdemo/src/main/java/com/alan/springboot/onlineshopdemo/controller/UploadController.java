package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String addProduct(HttpSession session,Model model){
		Product product = new Product();
		String seller = (String)session.getAttribute("login");
		product.setSeller(seller);
		model.addAttribute("product",product);
		return  "upload_product";
	}
}
