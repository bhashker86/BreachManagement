package com.hcl.breachmanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CommonExpHandler {


	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
		ErrorResponse err_res=new ErrorResponse(new Date(), HttpStatus.OK, ex.getMessage());
		return new ResponseEntity<>(err_res,HttpStatus.NOT_FOUND);
	}	
	
	

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleCourseNotFoundException(Exception ex, WebRequest request){
		ErrorResponse err_res=new ErrorResponse(new Date(), HttpStatus.OK, ex.getMessage());
		return new ResponseEntity<>(err_res,HttpStatus.NOT_FOUND);
	}	
	
	

	

	
}
