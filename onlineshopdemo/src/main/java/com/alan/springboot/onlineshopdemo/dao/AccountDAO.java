package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.entity.User;

public interface AccountDAO {

	// register account
	public void addMember(User user);

	public String login(String username,String password);

	public User findByUsername(String username);

	public void modifyMember(User user);


}
