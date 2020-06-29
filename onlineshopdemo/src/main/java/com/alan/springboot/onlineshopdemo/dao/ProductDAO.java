package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.Product;

import java.util.List;

public interface ProductDAO {
	public void uploadProduct(Product product);

	public Product showProduct(int productId);

	public List<Product> showProductByUsername(String username);

	public Product showProductByIdUsername(int productId, String username);

}
