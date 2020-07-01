package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.Cart;

import java.util.List;

public interface CartService {

	public List<Cart> getCartByUsername(String username);

	public void updateCart(Cart cart,int quantity);

	public Cart getCartByProductIdUsername(int productId, String username);

	public void addCart(Cart cart);
}
