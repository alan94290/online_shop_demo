package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.Product;

public interface ProductDAO {
	public void uploadProduct(Product product);

	public Product showProduct(int productId);

}
