package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.ProductDAO;
import com.alan.springboot.onlineshopdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	@Autowired
	public ProductServiceImpl(ProductDAO productDAO){
		this.productDAO = productDAO;
	}

	@Override
	public void uploadProduct(Product product) {
		productDAO.uploadProduct(product);
	}

	@Override
	public Product showProduct(int productId) {
		Product product = productDAO.showProduct(productId);
		return product;
	}
}
