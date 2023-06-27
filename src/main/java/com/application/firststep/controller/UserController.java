package com.application.firststep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.firststep.DTOs.UserDto;
import com.application.firststep.model.User;
import com.application.firststep.services.AccountService;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody UserDto user) {

		User savedUser = accountService.saveUser(user);

		if (savedUser != null) {

			return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "User Successully Signedup", savedUser);

		} else

		{
			
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "User Already Exists Please Provide Different Mobiel number", savedUser);
		}

	}
	
	
	
	
	
	

	

}
