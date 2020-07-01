package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Cart;
import com.alan.springboot.onlineshopdemo.model.Product;
import com.alan.springboot.onlineshopdemo.service.CartService;
import com.alan.springboot.onlineshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
	private CartService cartService;
	private ProductService productService;

	@Autowired
	public CartController(CartService cartService, ProductService productService) {
		this.cartService = cartService;
		this.productService = productService;
	}


	@GetMapping("/list")
	public String showCart(HttpSession session, Model model) {
		String login = (String) session.getAttribute("login");
		if (login == null) {
			return "redirect:/register/showForm";
		} else {
			String username = (String) session.getAttribute("login");
			List<Cart> cartList = cartService.getCartByUsername(username);
			List<Product> productList = new ArrayList<>();
			for (Cart cart : cartList) {
				int productId = cart.getProductId();
				int quantity = cart.getQuantity();
				Product product = productService.showProduct(productId);
				productList.add(product);
			}
			model.addAttribute("cart",cartList);
			model.addAttribute("product",productList);
			return "cart";
		}
	}

	//	@PostMapping("/add")
//	public String addCart(@RequestParam("productId") String id,@RequestParam("quantity") String amount, HttpSession session) {
//		int productId = Integer.parseInt(id);
//		String username = (String) session.getAttribute("login");
//		int quantity = Integer.parseInt(amount);
//		Cart cart = cartService.getCartByProductIdUsername(productId,username);
//		if(cart==null){
//			Cart cart1 = new Cart();
//			cart1.setProductId(productId);
//			cart1.setUsername(username);
//			cart1.setQuantity(quantity);
//			cartService.addCart(cart1);
//		}else {
//			cart.setQuantity(cart.getQuantity()+quantity);
//			cartService.updateCart(cart);
//		}
//
//
//
//		return "redirect:/cart/list";
//	}
	@PostMapping("/add")
	public String addCart(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity, HttpSession session) {
		String username = (String) session.getAttribute("login");
		Cart cart = cartService.getCartByProductIdUsername(productId, username);
		if (cart == null) {
			cart = new Cart();
			cart.setProductId(productId);
			cart.setUsername(username);
			cart.setQuantity(quantity);
			cartService.addCart(cart);
		} else {
			cart.setQuantity(cart.getQuantity() + quantity);
			cartService.updateCart(cart);
		}


		return "redirect:/cart/list";
	}
}
