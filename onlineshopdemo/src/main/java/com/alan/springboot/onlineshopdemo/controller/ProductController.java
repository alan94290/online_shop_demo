package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts() {
        return "products";
    }

    @GetMapping("/detail")
    public String showProductDetail(@RequestParam("productId") int productId, Model model) {
        Product product = productService.showProduct(productId);
        model.addAttribute("product", product);
        return "product_detail";
    }

    @GetMapping("/list")
    public String showAllProduct(Model model, HttpSession session) {
        String username = (String) session.getAttribute("login");
        List<Product> productList = productService.showProductByUsername(username);
        model.addAttribute("productList", productList);
        return "product_list";
    }
}
