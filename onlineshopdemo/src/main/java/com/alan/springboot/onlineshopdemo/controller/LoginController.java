package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.User;
import com.alan.springboot.onlineshopdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/request")
    public String sendLogin(@ModelAttribute("user") User user, HttpSession session) {
        
        session.setAttribute("login", loginService.login(user.getUsername(), user.getPassword()));
        String login = (String) session.getAttribute("login");
        if (login == null) {
            return "redirect:/error/login";
        } else {
            return "redirect:/index";
        }
    }
}
