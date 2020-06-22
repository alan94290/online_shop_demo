package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RegisterDAOImpl implements RegisterDAO{

	//define entity for entityManager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public RegisterDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}


	@Override
	public void addMember(User user) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		// save the user
		session.save(user);

	}
}
