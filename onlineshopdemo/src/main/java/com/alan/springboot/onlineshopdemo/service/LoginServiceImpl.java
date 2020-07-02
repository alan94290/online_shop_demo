package com.alan.springboot.onlineshopdemo.service;

import com.alan.springboot.onlineshopdemo.dao.AccountDAO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    private AccountDAO accountDAO;

    public LoginServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @Transactional
    public String login(String username, String password) {
        try {
            String login = accountDAO.login(username, password);
            return login;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login fail");
            return null;
        }
    }
}
