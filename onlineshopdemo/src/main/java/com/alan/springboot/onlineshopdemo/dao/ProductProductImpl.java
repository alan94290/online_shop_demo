package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductProductImpl implements ProductDAO {
	private EntityManager entityManager;

	@Autowired
	public ProductProductImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void uploadProduct(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.save(product);
	}

	@Override
	public Product showProduct(int productId) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Product where productId =?1");
		List<Product> productList = query.getResultList();
		Product product = productList.get(0);
		return product;
	}

	@Override
	public List<Product> showProductByUsername(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Product where username = ?1 order by productId desc");
		query.setParameter(1,username);
		List<Product> productList = query.getResultList();
		return productList;
	}


}
