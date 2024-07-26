package com.minihome.comment.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.minihome.comment.dto.Comment;
import com.minihome.comment.model.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@GetMapping("/home")
	public String list(Model model) { 
		try {
			List<Comment> comments = service.readAll();	
			model.addAttribute("comments", comments);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
}