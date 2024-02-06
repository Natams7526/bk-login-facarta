package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;



@RestController
@RequestMapping("/api/auth")
public class LoginController {
    
	@Autowired
    private LoginService LoginService;

	@GetMapping("/register")
	public String register(@RequestParam String username, @RequestParam String password) {
		return LoginService.register(username, password);
	}
	
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return LoginService.authenticate(username, password);
    }
    
}