package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.AccountDAO;
import com.alan.springboot.onlineshopdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService {

    private AccountDAO accountDAO;

    @Autowired
    public RegisterServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @Transactional
    public void addMember(User user) {
        try {
            accountDAO.addMember(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Add fail");
        }
    }

    @Override
    @Transactional
    public String checkUsed(String username, String email) {
        User user = accountDAO.findByUsername(username);
        if (user == null) {
            user = accountDAO.findByEmail(email);
            if (user == null) {
                return "unused";
            } else {
                return "email used";
            }
        } else {
            return "username used";
        }
    }
}
