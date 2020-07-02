package com.alan.springboot.onlineshopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/login")
    public String sendLoginError() {
        return "login_error";
    }

    @GetMapping("/register")
    public String sendRegisterError() {
        return "register_error";
    }
}
