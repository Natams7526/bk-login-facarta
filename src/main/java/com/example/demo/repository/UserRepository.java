package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserLogin;


public interface UserRepository extends JpaRepository<UserLogin, Long> {
	
	UserLogin findByUsername(String username);
	
}
