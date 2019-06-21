package com.hcl.breachmanagement.service;

import com.hcl.breachmanagement.dto.LoginDTO;
import com.hcl.breachmanagement.exception.UserNotFoundException;

public interface LoginService {

	LoginDTO validate(LoginDTO loginDTO) throws UserNotFoundException;

	LoginDTO validateotp(LoginDTO loginDTO, Long otp) throws UserNotFoundException;

}
