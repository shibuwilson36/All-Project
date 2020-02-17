package com.tyss.customermanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.customermanagement.dto.CustomeResponse;
import com.tyss.customermanagement.exception.EmailAlreadyException;

@RestControllerAdvice
public class CustomerControllerAdvice {
	
	@ExceptionHandler(EmailAlreadyException.class)
	public CustomeResponse emailAlreadyExist(EmailAlreadyException e) {
		
		CustomeResponse response=new CustomeResponse();	
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		
		return response;
	}
}
