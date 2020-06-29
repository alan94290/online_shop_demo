package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.Cart;
import com.alan.springboot.onlineshopdemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}


	@GetMapping("/list")
	public String showCart(HttpSession session, Model model) {
		String login = (String) session.getAttribute("login");
		if (login == null) {
			return "redirect:/register/showForm";
		} else {
			String username = (String) session.getAttribute("login");
			List<Cart> cartList = cartService.getCartByUsername(username);
			model.addAttribute("cart", cartList);
			return "cart";
		}
	}

	@PostMapping("/update")
	public String updateCart(@ModelAttribute("cart") List<Cart> cartList) {
		cartService.updateCart(cartList);
		return "redirect:/cart/list";
	}
}
