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
		
		String firstName = userDto.getFirstName();
		String lastName = userDto.getLastName();
		String emailId = userDto.getEmail();
		String mobileNumber = userDto.getMobileNo();
		String userName = userDto.getUserName();
		String password = userDto.getPassword();
	
		User userByNumber = userRepository.findByMobileNumber(mobileNumber);
		User userByEmail = userRepository.findByEmailId(emailId);
		User userByUserName = userRepository.findByUserName(userName);
		

		if( userByNumber == null && userByEmail == null && userByUserName == null ){	
			user.setEmailId(emailId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMobileNumber(mobileNumber);
			user.setUserName(userName);
			user.setPassword(password);

			user.setUserId(userDto.getId());
			user.setCity(userDto.getCity());
			user.setCollege(userDto.getCollege());
			user.setRefferal_code(userDto.getRefferalCode());
			user.setUserProfile(null);
			
			user = userRepository.save(user);
			return user;
		}else return null;
		
	}

	@Override
	public User loginUser(UserLoginDto userDto) {
		String password = userDto.getPassword();
		
		User userByEmail = userRepository.findByEmailId(userDto.getEmail());
		User userByUserName = userRepository.findByUserName(userDto.getUserName());
		User userByNumber = userRepository.findByMobileNumber(userDto.getMobileNo());
		
		if(userByEmail == null) {
			if(userByUserName == null) {
				if(userByNumber.getPassword().equals(password))  return userByNumber;
				return null;
			}	
			if(userByUserName.getPassword().equals(password)) return userByUserName;
			return null;
		}
		if(userByEmail .getPassword().equals(password)) return userByEmail;
		return null;
	}
	
	@Override
	public User changePassword(PasswordChangeDto passwordChangeDto) {
		String emailId = passwordChangeDto.getEmail();
		String userName = passwordChangeDto.getUserName();
		String password = passwordChangeDto.getPassword();
		String newPassword = passwordChangeDto.getNewPassword();
		
		User userByEmail = userRepository.findByEmailId(emailId);
		User userByUserName = userRepository.findByUserName(userName);
		User userByNumber = userRepository.findByMobileNumber(passwordChangeDto.getMobileNo());
		
		if(userByEmail == null) {
			if(userByUserName == null) {
				if(userByNumber.getPassword().equals(password)) {
					userByNumber.setPassword(newPassword);
					userByNumber = userRepository.save(userByNumber);
					return userByNumber;
				}return null;
			}
			if(userByUserName.getPassword().equals(password)) {
				userByUserName.setPassword(newPassword);
				userByUserName = userRepository.save(userByUserName);
				return userByUserName;
			}
			return null;
		}
		if(userByEmail.getPassword().equals(password)) {
			userByEmail.setPassword(newPassword);
			userByEmail = userRepository.save(userByEmail);
			return userByEmail;
		}
		return null;
		
	}
	
}
