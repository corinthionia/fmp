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
			// 현재 로그인한 사용자 정보
            Integer userId = (Integer) session.getAttribute("userId");
            String username = (String) session.getAttribute("username");
            
            if (userId == null) {
                model.addAttribute("error", "로그인이 필요합니다");
                return "redirect:/login";
            }
            
			List<Comment> comments = service.readAll();	
			model.addAttribute("comments", comments);
			
			model.addAttribute("currentUserId", userId);
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
	public String remove(@RequestParam("id") int commentId, HttpSession session, Model model) {
		try {
            // 현재 로그인한 사용자 정보
            Integer userId = (Integer) session.getAttribute("userId");
            
            
            if (userId == null) {
                model.addAttribute("error", "로그인이 필요합니다");
                return "redirect:/login";
            }

            // 댓글 작성자 정보 조회
            Integer commentAuthorId = service.findCommentAuthor(commentId); 
            System.out.println(userId + ", " + commentAuthorId + ", " + commentAuthorId.equals(userId));

            if (!commentAuthorId.equals(userId)) {
                model.addAttribute("error", "삭제 권한이 없습니다");
                return "redirect:/home";
            }

            // 댓글 삭제
            service.remove(commentId);

        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error", "요청을 처리하는 도중 에러가 발생했습니다. 다시 시도해 주세요.");
        }
		return "redirect:/home";
	}
	
}