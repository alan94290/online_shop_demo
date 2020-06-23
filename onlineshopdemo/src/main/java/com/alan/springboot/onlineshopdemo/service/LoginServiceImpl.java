package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	private AccountDAO accountDAO;

	public LoginServiceImpl(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}

	@Override
	public String login(String username, String password) {
		return accountDAO.login(username,password);
	}
}
