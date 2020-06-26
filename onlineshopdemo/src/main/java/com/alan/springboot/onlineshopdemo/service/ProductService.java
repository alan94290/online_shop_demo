package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.Product;

public interface ProductService {
	public void uploadProduct(Product product);

	public Product showProduct(int productId);

}
