package com.login.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.entity.User;
import com.login.repositories.UserRepository;

public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User  loginUser(String username ,String password) {
		User usr=userRepository.findByNameAndPassword(username, password);
		
		return usr;
	}
}
