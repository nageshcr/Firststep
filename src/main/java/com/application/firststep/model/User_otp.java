package com.application.firststep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_otp")
public class User_otp {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "mobile_no")
	private String mobileNumber;
	
	@Column(name = "otp")
	private String otp;
	

}
