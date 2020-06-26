package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.Cart;

import java.util.List;


public interface CartDAO {
	public List<Cart> getCartByUsername(String username);

	public void updateCart(List<Cart> cartList);
}
