package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.registration.dto.UserDto;
import com.registration.entity.User;
import com.registration.repository.UserRepository;
import com.registration.utility.Constant;

/**
* author Venkateswarlu Bikki
*/
@Component
public class UserService {
	@Autowired
	UserRepository userRepository;
	public String registerUser(UserDto userDto) {
		String msg=Constant.REGISTRAION_FAILURE_MSG;
		User user=new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setuserType(userDto.getuserType());
        try {
		userRepository.save(user);
		msg=Constant.REGISTRAION_SUCESS_MSG;
        }
        catch (Exception e) {
			// TODO: handle exception
		}
		return msg;
	}


}
