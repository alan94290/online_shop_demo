package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LoginDAOImpl implements LoginDAO {

	private EntityManager entityManager;

	@Autowired
	public LoginDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public String login(String username, String password) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from User where username=?1 and password=?2");
		query.setParameter(1,username);
		query.setParameter(2,password);
		List<User> users = query.getResultList();
	if(users.isEmpty()){
		System.out.println("Login fail");
		return "Login fail";
	}else {
		System.out.println("Login success");
		return "Login success";
	}
	}
}
