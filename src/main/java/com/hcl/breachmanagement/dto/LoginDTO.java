package com.hcl.breachmanagement.dto;



import org.springframework.stereotype.Component;
/**
 * Date :July 25,2018
 * @author MukulJaiswal
 * @version 1.0
 *
 */
@Component

public class LoginDTO {
	
	public Long userId;

	public String phNum;
	
	


	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", phNum=" + phNum + "]";
	}

	public LoginDTO(Long userId, String phNum, String email) {
		super();
		this.userId = userId;
		this.phNum = phNum;
	
	}

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}



	public LoginDTO() {
		super();
		
	}


	
	
	

}

