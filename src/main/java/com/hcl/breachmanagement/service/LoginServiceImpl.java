
package com.hcl.breachmanagement.service;
  
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breachmanagement.dto.LoginDTO;
import com.hcl.breachmanagement.entity.User;
import com.hcl.breachmanagement.exception.UserNotFoundException;
import com.hcl.breachmanagement.repository.LoginRepository;


 
 
 @Service
 @Transactional
 
 public class LoginServiceImpl implements LoginService{
 
 @Autowired 
 private LoginRepository loginRepository;
 @Autowired
 private MailService mailService;
 
 
 
 public LoginDTO validate(LoginDTO loginDTO) throws UserNotFoundException {
	
 User user =   loginRepository.findUserByUserIdAndPhNum(loginDTO.getUserId(),loginDTO.getPhNum() ); 
 Random rand = new Random();
 long otp=1000+rand.nextInt(9999);
 
		  LoginDTO loginDto = new LoginDTO(); 
 if(user==null ) {
	throw new UserNotFoundException ("Invalid User");
	  }
 
 else {
	 loginDto.setUserId(user.getUserId()); 
	 loginDto.setPhNum(user.getPhNum());
	 mailService.sendEmail(user.getEmail(),otp);
	 user.setOtp(otp);
	 loginRepository.save(user);
	  return loginDto;
 
 
 }




 
 
 
 }



@Override
public LoginDTO validateotp(LoginDTO loginDTO, Long otp) throws UserNotFoundException {
	 User user =   loginRepository.findUserByPhNumAndOtp(loginDTO.getPhNum() ,otp); 
	 LoginDTO loginDto = new LoginDTO(); 
	 if(user==null ) {
		throw new UserNotFoundException ("Invalid User");
		  }
	 
	 else {
		 loginDto.setUserId(user.getUserId()); 
		 loginDto.setPhNum(user.getPhNum());
		
		  return loginDto;
	 
	 
	 }
}
 




  
  
  




  
  }
