package com.alan.springboot.onlineshopdemo.service;


import com.alan.springboot.onlineshopdemo.dao.CartDAO;
import com.alan.springboot.onlineshopdemo.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	private CartDAO cartDAO;

	@Autowired
	public CartServiceImpl(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}


	@Override
	@Transactional
	public List<Cart> getCartByUsername(String username) {
		try {
			List<Cart> cartList = cartDAO.getCartByUsername(username);
			return cartList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void updateCart(List<Cart> cartList) {
		try {
			cartDAO.updateCart(cartList);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
