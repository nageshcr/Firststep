package com.application.firststep.DTOs;

public class UserLoginDto {
	private String email;
	private String mobileNo;
	private String password;
	private String userName;
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserLoginDto [email=" + email + ", mobileNo=" + mobileNo + ", password=" + password + ", userName="
				+ userName + "]";
	}
	
	
	
}
