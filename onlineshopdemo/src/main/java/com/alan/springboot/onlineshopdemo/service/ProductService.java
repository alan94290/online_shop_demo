package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.Product;

import java.util.List;

public interface ProductService {
	public void uploadProduct(Product product);

	public Product showProduct(int productId);

	public List<Product> showProductByUsername(String username);

	public Product showProductByIdUsername(int productId,String username);

	public List<Product> findAll();

}
