package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.dto.UserDto;
import com.registration.service.UserService;
import com.registration.utility.Constant;

/**
* author Venkateswarlu Bikki
*/

@RestController
public class RegistrationController {
	@Autowired
	UserService  userService;
	
	@PostMapping(value="registration")
	public String registration(@RequestBody UserDto user) {
		String msg=null;
		try {
		userService.registerUser(user);
		msg=Constant.REGISTRAION_SUCESS_MSG;
		}
		catch (Exception e) {
			// TODO: handle exception
			msg=Constant.REGISTRAION_FAILURE_MSG;
		}
		return msg;
	}

}
