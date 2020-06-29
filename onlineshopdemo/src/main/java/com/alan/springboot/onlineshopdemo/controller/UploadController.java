package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Image;
import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("upload")
public class UploadController {
	private ProductService productService;
	private static int num;

	@Autowired
	public UploadController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/showForm")
	public String addProduct(HttpSession session, Model model) {
		Product product = new Product();
		String username = (String) session.getAttribute("login");
		product.setUsername(username);
		model.addAttribute("product", product);
		return "product_upload";
	}

	@PostMapping("/request")
	public String sendProduct(@ModelAttribute("product") Product product, @RequestPart("product-image") MultipartFile multipartFile) throws IOException {
		num += 1;
		Image image = new Image();
		String productImage = image.imageStore(multipartFile,num);
		product.setProductImage(productImage);
		productService.uploadProduct(product);
		return "redirect:/product/list";
	}
}
