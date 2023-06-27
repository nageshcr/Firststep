package com.application.firststep.DTOs;

public class PasswordChangeDto {
	private String email;
	private String mobileNo;
	private String password;
	private String userName;
	private String newPassword;
	
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

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
		return "PasswordChangeDto [email=" + email + ", mobileNo=" + mobileNo + ", password=" + password + ", userName="
				+ userName + ", newPassword=" + newPassword + "]";
	}
	
	
}
