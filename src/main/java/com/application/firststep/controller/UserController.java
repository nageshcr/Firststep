package com.application.firststep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.firststep.DTOs.PasswordChangeDto;
import com.application.firststep.DTOs.UserDto;
import com.application.firststep.model.User;
import com.application.firststep.services.AccountService;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody UserDto userDto) {
		User savedUser = null;
		if (userDto == null)
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Please provide required fields",
					savedUser);
		if (userDto.getFirstName() == null)
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "First Name cannot be empty",
					savedUser);
		if (userDto.getPassword() == null)
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Password cannot be empty",
					savedUser);
		if (userDto.getMobileNo() == null )
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile Number cannot be empty",
					savedUser);

		savedUser = accountService.saveUser(userDto);

		if (savedUser != null) {
			return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "User Successully Signedup", savedUser);
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false,
				"User Already Exists Please Provide Different Mobile number", savedUser);

	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserDto userDto) {

		if (userDto == null || userDto.getMobileNo() == null || userDto.getPassword() == null) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile Number or Password cannot be empty",
					userDto);
		}

		User loggedInUser = accountService.loginUser(userDto);

		if (loggedInUser != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Logged In successfuly", loggedInUser);
		}
		return ResponseHandler.generateResponse(HttpStatus.CONFLICT, false, "Mobile Number or Password is wrong", loggedInUser);
	}

	@PostMapping("/changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody UserDto userDto) {

		if (userDto == null || userDto.getMobileNo() == null) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile Number or Password cannot be empty",
					userDto);
		}

		User changedPassword = accountService.changePassword(userDto);

		if (changedPassword != null) {
			return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "Password changed successfully",
					changedPassword);
		}
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Mobile  Number does not exist",
				changedPassword);

	}

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

}
