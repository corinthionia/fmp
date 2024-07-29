package com.minihome.user.controller;

import java.sql.SQLException;
import java.util.regex.Pattern;

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
	
	private static final Pattern KOREAN_NAME_PATTERN = Pattern.compile("^[가-힣]+$");

	@GetMapping("/login")
	public String login() {
	  System.out.println(">>> GET login");
	  return "login";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        HttpSession session, Model model) {
        
        try {
        	// 한글 이름인지 검증
            if (!KOREAN_NAME_PATTERN.matcher(name).matches()) {
                model.addAttribute("nameError", "한글 이름만 가능합니다");
                return "login";
            }
            
            // 4자리 숫자로 이루어진 비밀번호인지 검증
            if (!password.matches("\\d{4}")) {
                model.addAttribute("passwordError", "4자리 숫자로 이루어진 비밀번호만 가능합니다");
                return "login";
            }

            User existingUser = service.findByName(name);
            
            if (existingUser != null) {
            	// 이미 존재하는 이름이거나 비밀번호가 틀렸을 경우
                if (!existingUser.getPassword().equals(password)) {
                    model.addAttribute("passwordError", "이미 존재하는 이름이거나 비밀번호가 틀립니다");
                    return "login";
                }
                
                // 기존 사용자가 로그인 한 경우
                session.setAttribute("userId", existingUser.getId());
                session.setAttribute("username", name);
                return "redirect:/home";
            } else {
            	// 신규 사용자인 경우 DB에 저장
                User user = new User();
                user.setName(name);
                user.setPassword(password);
                service.add(user);

                User userFromDB = service.findByName(name);
                session.setAttribute("userId", userFromDB.getId());
                session.setAttribute("username", name);
                return "redirect:/home";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error", "요청 처리 중 에러가 발생했습니다. 다시 시도해 주세요.");
            return "login";
        }
    }
}






