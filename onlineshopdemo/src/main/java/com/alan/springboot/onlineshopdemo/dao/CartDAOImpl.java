package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.Cart;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {
    private EntityManager entityManager;

    @Autowired
    public CartDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cart> getCartByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Cart where username=?1 order by productId");
        query.setParameter(1, username);
        List<Cart> cartList = query.getResultList();
        return cartList;
    }

    @Override
    public void updateCart(Cart cart) {
        Session session = entityManager.unwrap(Session.class);
        session.update(cart);
    }

    @Override
    public Cart getCartByProductIdUsername(int productId, String username) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Cart where productId = ?1 and username = ?2");
        query.setParameter(1, productId);
        query.setParameter(2, username);
        List<Cart> cartList = query.getResultList();
        if (cartList.isEmpty()) {
            return null;
        } else {
            Cart cart = cartList.get(0);
            return cart;
        }

    }

    @Override
    public void addCart(Cart cart) {
        Session session = entityManager.unwrap(Session.class);
        session.save(cart);
    }
}
