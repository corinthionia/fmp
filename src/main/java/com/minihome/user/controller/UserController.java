package com.minihome.user.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.minihome.user.dto.User;
import com.minihome.user.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("/login")
	public String login() {
	  System.out.println(">>> GET login");
	  return "login";
	}
	
	@PostMapping("/login")
	public String regist(User user, Model model) {
		System.out.println(">>> POST login");
		System.out.println("user>>>"+ user);
		
		try {
			service.add(user);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:home";
	}
}






