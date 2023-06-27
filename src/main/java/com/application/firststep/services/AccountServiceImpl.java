package com.application.firststep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.firststep.DTOs.UserDto;

import com.application.firststep.model.*;
import com.application.firststep.repositories.UserRepository;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(UserDto userDto) {
		
		
		String firstName = userDto.getFirstName();
		String lastName = userDto.getLastName();
		String email = userDto.getEmail();
		String mobileNo = userDto.getMobileNo();
		String password = userDto.getPassword();
		
	
		
		
		User existingUser = userRepository.findByMobileNumber(mobileNo);
		
		if(existingUser==null) {
			
			User user = new User();
			
			
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(email);
			user.setMobileNumber(mobileNo);
			user.setPassword(password);
				
			
			User savedEntity = userRepository.save(user);
			
			return savedEntity;
			
			
		}else {
			
			return null;
		}
		
	
		
		
	}
	
	

}