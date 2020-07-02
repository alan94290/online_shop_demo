package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.AccountDAO;
import com.alan.springboot.onlineshopdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    @Transactional
    public User findByUsername(String username) {
        User user = accountDAO.findByUsername(username);
        return user;
    }

    @Override
    @Transactional
    public void modifyMember(User user) {
        try {
            accountDAO.modifyMember(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Modify fail");
        }
    }
}
