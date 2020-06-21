package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.RegisterDAO;
import com.alan.springboot.onlineshopdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService{

	private RegisterDAO registerDAO;

	@Autowired
	public RegisterServiceImpl(RegisterDAO registerDAO){
		this.registerDAO = registerDAO;
	}

	@Override
	@Transactional
	public void addMember(User user) {
		registerDAO.addMember(user);
	}
}
