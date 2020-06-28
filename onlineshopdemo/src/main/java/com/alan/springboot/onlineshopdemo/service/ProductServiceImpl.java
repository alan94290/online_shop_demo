package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.ProductDAO;
import com.alan.springboot.onlineshopdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void uploadProduct(Product product) {
		try {
			productDAO.uploadProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product showProduct(int productId) {
		Product product = productDAO.showProduct(productId);
		return product;
	}

	@Override
	public List<Product> showProductByUsername(String username) {
		try {
			List<Product> productList = productDAO.showProductByUsername(username);
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
