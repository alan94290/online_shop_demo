package com.alan.springboot.onlineshopdemo.service;


import com.alan.springboot.onlineshopdemo.dao.CartDAO;
import com.alan.springboot.onlineshopdemo.dao.ProductDAO;
import com.alan.springboot.onlineshopdemo.model.Cart;
import com.alan.springboot.onlineshopdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	private CartDAO cartDAO;
	private ProductDAO productDAO;

	@Autowired
	public CartServiceImpl(CartDAO cartDAO,ProductDAO productDAO) {
		this.cartDAO = cartDAO;
		this.productDAO = productDAO;
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
	public void updateCart(Cart cart, int quantity) {
		try {
			cartDAO.updateCart(cart);
			int productId = cart.getProductId();
			Product product = productDAO.showProduct(productId);
			product.setInventory(product.getInventory()-quantity);
			productDAO.updateProduct(product);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public Cart getCartByProductIdUsername(int productId, String username) {
		try {
			Cart cart = cartDAO.getCartByProductIdUsername(productId, username);
			return cart;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void addCart(Cart cart) {
		try {
			cartDAO.addCart(cart);
			int productId = cart.getProductId();
			int quantity = cart.getQuantity();
			Product product = productDAO.showProduct(productId);
			product.setInventory(product.getInventory()-quantity);
			productDAO.updateProduct(product);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
