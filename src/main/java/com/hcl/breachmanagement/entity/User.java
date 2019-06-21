package com.hcl.breachmanagement.entity;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/**
 * Date :July 25,2018
 * @author MukulJaiswal
 * @version 1.0
 *
 */
@Component
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long userId;
	public String userName;
	public String password;
	public String phNum;
	public  Long otp;
	public String email;
	
	public String userRoles;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public Long getOtp() {
		return otp;
	}
	public void setOtp(Long otp) {
		this.otp = otp;
	}
	public String getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}
	
	public User(Long userId, String userName, String password, String phNum, Long otp, String email, String userRoles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phNum = phNum;
		this.otp = otp;
		this.email = email;
		this.userRoles = userRoles;
	}
	public User() {
		super();
		
	}
	

	
	

}
