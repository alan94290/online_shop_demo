package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Image;
import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MultipartDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;


import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UploadController {
	private ProductService productService;

	@Autowired
	public UploadController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/upload")
	public String addProduct(HttpSession session, Model model) {
		Product product = new Product();
		String username = (String) session.getAttribute("login");
		product.setUsername(username);
		model.addAttribute("product", product);
		return "upload-product";
	}

	@PostMapping("/upload-request")
	public String sendProduct(@ModelAttribute("product") Product product, @RequestPart("product-image") MultipartFile multipartFile) throws IOException {
		Image image = new Image();
		image.imageStore(multipartFile);
		String productImage = image.imageStore(multipartFile);
		product.setProductImage(productImage);
		productService.uploadProduct(product);
		return "redirect:product-list";
	}
}
