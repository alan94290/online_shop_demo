package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.AccountDAO;
import com.alan.springboot.onlineshopdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
	private AccountDAO accountDAO;

	@Autowired
	public AdminServiceImpl(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}


	@Override
	public List<User> findAll() {
		try{
			List<User> userList = accountDAO.findAll();
			return userList;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}
}
