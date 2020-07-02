package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    //define entity for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void addMember(User user) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);
        // save the user
        session.save(user);

    }

    @Override
    public String login(String username, String password) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User where username=?1 and password=?2");
        query.setParameter(1, username);
        query.setParameter(2, password);
        List<User> users = query.getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            // login success return account
            return username;
        }
    }

    @Override
    public User findByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User where username=?1");
        query.setParameter(1, username);
        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            return null;
        } else {
            User user = userList.get(0);
            return user;
        }
    }

    @Override
    public void modifyMember(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User findByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User where email=?1");
        query.setParameter(1, email);
        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            return null;
        } else {
            User user = userList.get(0);
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User");
        List<User> userList = query.getResultList();
        return userList;
    }
}
