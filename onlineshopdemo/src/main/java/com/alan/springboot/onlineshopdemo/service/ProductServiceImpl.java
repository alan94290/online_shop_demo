package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.ProductDAO;
import com.alan.springboot.onlineshopdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public void uploadProduct(Product product) {
        try {
            productDAO.uploadProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public Product showProduct(int productId) {
        Product product = productDAO.showProduct(productId);
        return product;
    }

    @Override
    @Transactional
    public List<Product> showProductByUsername(String username) {
        try {
            List<Product> productList = productDAO.showProductByUsername(username);
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    @Transactional
    public Product showProductByIdUsername(int productId, String username) {
        try {
            Product product = productDAO.showProductByIdUsername(productId, username);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Product> findAll() {
        try {
            List<Product> productList = productDAO.findAll();
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
