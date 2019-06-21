package com.hcl.breachmanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	

private String message;

public ErrorResponse(Date date, HttpStatus ok, String message) {
	super();
	
	this.message = message;
}

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ErrorResponse() {
	super();

}

}
