package com.minihome.guestbook.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minihome.guestbook.dto.Guestbook;
import com.minihome.guestbook.model.service.GuestbookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService service;
	
	@GetMapping("/guestbook")
	public String list(Model model, HttpSession session) { 
		try {
			// 현재 로그인한 사용자 정보
            Integer userId = (Integer) session.getAttribute("userId");
            String username = (String) session.getAttribute("username");
            
			List<Guestbook> guestbooks = service.readAll();	
			model.addAttribute("guestbooks", guestbooks);
			
            model.addAttribute("username", username);
            model.addAttribute("currentUserId", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "guestbook";
	}
	
	@PostMapping("/guestbook")
	public String regist(HttpSession session, @RequestParam String guestbookText,
						Model model) {

		System.out.println(">>> POST guestbook: " + guestbookText);
		
		Integer userId = (Integer) session.getAttribute("userId");
        Guestbook guestbook = new Guestbook(userId, guestbookText);
		
		try {
            service.add(guestbook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/guestbook";
	}
	
	@GetMapping("/guestbook/delete")
	public String remove(@RequestParam("id") int guestbookId) {
		try {
			service.remove(guestbookId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/guestbook";
	}
	
}