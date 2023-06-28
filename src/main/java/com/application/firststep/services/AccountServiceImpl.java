package com.application.firststep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.firststep.DTOs.*;
import com.application.firststep.model.User;
import com.application.firststep.repositories.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(UserDto userDto) {
		
		User user = new User();
		
		String mobileNumber = userDto.getMobileNo();
	
		User existingUser = userRepository.findByMobileNumber(mobileNumber);

		if( existingUser == null ){	
			user.setMobileNumber(mobileNumber);
			user.setEmailId(userDto.getEmail());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setUserName(userDto.getUserName());
			user.setPassword(userDto.getPassword());
			user.setUserId(userDto.getId());
			user.setCity(userDto.getCity());
			user.setCollege(userDto.getCollege());
			user.setRefferal_code(userDto.getRefferalCode());
			user.setUserProfile(null);
			
			user = userRepository.save(user);
			return user;
		}
		return null;
		
	}

	@Override
	public User loginUser(UserDto userDto) {		
		User existingUser = userRepository.findByMobileNumber(userDto.getMobileNo());
		if(existingUser == null) return null;
		if(existingUser.getPassword().equals(userDto.getPassword())) return existingUser;
		return null;
	}
	
	@Override
	public User changePassword(UserDto userDto) {

		
		User existingUser = userRepository.findByMobileNumber(userDto.getMobileNo());

		if(existingUser != null) {
			existingUser.setPassword(userDto.getPassword());
			existingUser = userRepository.save(existingUser);
			return existingUser;
		}
		return null;

		
	}
	
}
