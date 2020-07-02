package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.Cart;

import java.util.List;


public interface CartDAO {
    public List<Cart> getCartByUsername(String username);

    public void updateCart(Cart cart);

    public Cart getCartByProductIdUsername(int productId, String username);

    public void addCart(Cart cart);
}
