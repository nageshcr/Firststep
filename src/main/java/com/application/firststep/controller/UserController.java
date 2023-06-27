package com.application.firststep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.application.firststep.DTOs.*;
import com.application.firststep.model.User;
import com.application.firststep.services.AccountService;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody UserDto userDto) {
		User savedUser = null;
		if(userDto == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Please provide required fields", savedUser);
		if(userDto.getFirstName() == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "First Name cannot be empty", savedUser);
		if(userDto.getPassword() == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Password cannot be empty", savedUser);
		if(userDto.getUserName() == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "User Name cannot be null", savedUser);
		if(userDto.getMobileNo() == null && userDto.getEmail() == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Email Id or Mobile is empty", savedUser);
			
		savedUser = accountService.saveUser(userDto);

		if (savedUser != null) {
			return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "User Successully Signedup", savedUser);
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "User Already Exists Please Provide Different Mobile number", savedUser);

	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto) {
		User loggedUser = null;

		if(userLoginDto == null || userLoginDto.getUserName() == null && userLoginDto.getMobileNo() == null && userLoginDto.getEmail() == null) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Please provide required fields", loggedUser);
		}
		if(userLoginDto.getPassword() == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Password cannot be empty", loggedUser);

		loggedUser = accountService.loginUser(userLoginDto);
		
		if(loggedUser != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Logged In successfuly", loggedUser);
		}
		return ResponseHandler.generateResponse(HttpStatus.CONFLICT, false,"Wrong Password", loggedUser);
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody PasswordChangeDto passwordChangeDto) {
		User changedPassword  = null;
		
		if(passwordChangeDto == null || passwordChangeDto.getUserName() == null && passwordChangeDto.getMobileNo() == null && passwordChangeDto.getEmail() == null) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Please provide required fields", changedPassword);
		}
		if(passwordChangeDto.getPassword() == null) return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Password cannot be empty", changedPassword);

		changedPassword  = accountService.changePassword(passwordChangeDto);
		
		if(changedPassword != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Password changed successfully", changedPassword);	
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Old Password did not match", changedPassword);

	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	
	
	

	

}
