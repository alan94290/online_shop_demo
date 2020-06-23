package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.User;

public interface AccountService {
	public User findByAccount(String username);

	public void modifyMember(User user);
}
