package com.minihome.user.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minihome.user.dto.User;
import com.minihome.user.model.service.UserService;

import jakarta.servlet.http.HttpSession;

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
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        HttpSession session, Model model) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        
        try {
			service.add(user);
			
	        User userFromDB = service.findByName(name);	
	        session.setAttribute("userId", userFromDB.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        session.setAttribute("username", name);
       
        return "redirect:/home";
    }
}






