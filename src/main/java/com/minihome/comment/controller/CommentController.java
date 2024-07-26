package com.minihome.comment.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minihome.comment.dto.Comment;
import com.minihome.comment.model.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	@Autowired
	CommentService service;
	
	@GetMapping("/home")
	public String list(Model model, HttpSession session) { 
		try {
			List<Comment> comments = service.readAll();	
			model.addAttribute("comments", comments);
			
			// 세션에서 사용자 이름 읽기
            String username = (String) session.getAttribute("username");
            model.addAttribute("username", username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@PostMapping("/comment")
	public String regist(HttpSession session, @RequestParam String nickname, @RequestParam String commentText,
						Model model) {

		System.out.println(">>> POST comment: " + nickname + ", " + commentText);
//		System.out.println("comment >>>" + comment);
		
		Integer userId = (Integer) session.getAttribute("userId");
        Comment comment = new Comment(userId, nickname, commentText);
		
		try {
            service.add(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
	}
	
	@GetMapping("/delete")
	public String remove(@RequestParam("id") int commentId) {
		try {
			service.remove(commentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	
}