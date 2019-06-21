package com.hcl.breachmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breachmanagement.dto.LoginDTO;
import com.hcl.breachmanagement.exception.UserNotFoundException;
import com.hcl.breachmanagement.service.LoginService;



@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders= {"*", "*/"}, origins = {"*", "*/"})
public class LoginController {
	@Autowired
	private LoginService loginService;
	@PostMapping("/login")
	public ResponseEntity<LoginDTO> validateLogin(@RequestBody LoginDTO loginDTO) throws UserNotFoundException {
		
		LoginDTO loginDto = loginService.validate(loginDTO);
		
		
		if(loginDto!=null  ) {
			
			return new ResponseEntity<>(loginDTO, HttpStatus.OK);
			}
		else {
			return new ResponseEntity<>(loginDTO, HttpStatus.PRECONDITION_FAILED);
		}
	}
	
	@PostMapping("/validateotp/{otp}")
public ResponseEntity<LoginDTO> validateOtp(@RequestBody LoginDTO loginDTO ,@PathVariable Long otp) throws UserNotFoundException {
		
	
		
		LoginDTO loginDto = loginService.validateotp(loginDTO,otp);
	
				return new ResponseEntity<>(loginDto, HttpStatus.OK);
		
	}
	
}