package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.AccountDAO;
import com.alan.springboot.onlineshopdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService{

	private AccountDAO accountDAO;

	@Autowired
	public RegisterServiceImpl(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}

	@Override
	@Transactional
	public void addMember(User user) {
		accountDAO.addMember(user);
	}
}
