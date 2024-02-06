package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLogin;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

  
    public String authenticate(String username, String password) {	
    	try {
    		UserLogin userOptional = userRepository.findByUsername(username);	
    		
    		if (userOptional.getUsername() != null) {
    			if (userOptional.getPassword().equals(password)) {
    				return "Autenticación satisfactoria";
    			}
    		}
    				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
    	return "Autenticación fallida";	
	}
    
    
    /*
     * metodo para crear usuario
     * */
    public String register(String username, String password) {
    	UserLogin data = new UserLogin();
    	data.setPassword(password);
    	data.setUsername(username);
    	try {
    		userRepository.save(data);	
    		return "Se ha registrado el usuario " + data.getUsername() ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
    	return "Registro fallido";	
	}



}
