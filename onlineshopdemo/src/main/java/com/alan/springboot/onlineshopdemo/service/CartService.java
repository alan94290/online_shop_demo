package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.Cart;

import java.util.List;

public interface CartService {

	public List<Cart> getCartByUsername(String username);

	public void updateCart(List<Cart> cartList);
}
