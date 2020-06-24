package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.User;

public interface RegisterService {
	public void addMember(User user);

	public String checkUsed(String username,String email);
}
