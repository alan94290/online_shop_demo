package com.alan.springboot.onlineshopdemo.controller;

import com.alan.springboot.onlineshopdemo.model.User;
import com.alan.springboot.onlineshopdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService){
		this.adminService = adminService;
	}

	@GetMapping("/admin-maintain")
	public String adminMaintenance(HttpSession session, Model model){
		// get login session
		String login = (String)session.getAttribute("login");
		if (login.equals("alan94290")){
			List<User> userList = adminService.findAll();
			model.addAttribute("users",userList);
			return "admin";
		}else{
			return "redirect:index";
		}
	}

}
