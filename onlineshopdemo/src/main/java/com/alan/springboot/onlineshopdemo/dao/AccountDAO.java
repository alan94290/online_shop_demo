package com.alan.springboot.onlineshopdemo.dao;

import com.alan.springboot.onlineshopdemo.model.User;

import java.util.List;

public interface AccountDAO {

	// register account
	public void addMember(User user);

	public String login(String username,String password);

	public User findByUsername(String username);

	public void modifyMember(User user);

	public User findByEmail(String email);

	public List<User> findAll();


}
