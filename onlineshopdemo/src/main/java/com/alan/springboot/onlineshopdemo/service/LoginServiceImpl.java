package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.LoginDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;

	public LoginServiceImpl(LoginDAO loginDAO){
		this.loginDAO = loginDAO;
	}

	@Override
	public String login(String username, String password) {
		return loginDAO.login(username,password);
	}
}
