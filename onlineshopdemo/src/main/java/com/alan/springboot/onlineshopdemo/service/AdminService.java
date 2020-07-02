package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.model.User;

import java.util.List;

public interface AdminService {
    public List<User> findAll();
}
