package com.tyss.mailsimulation.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.mailsimulation.Exception.EmailAlreadyException;
import com.tyss.mailsimulation.Exception.EmailNotExistException;
import com.tyss.mailsimulation.dto.MailResponse;


@RestControllerAdvice
public class UserControlerAdvice {

	@ExceptionHandler(EmailAlreadyException.class)
	public MailResponse emailAlreadyExist(EmailAlreadyException e) {
		MailResponse response=new MailResponse();
		
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		
		return response;
	}
	@ExceptionHandler(EmailNotExistException.class)
	public MailResponse emailNotExist(EmailNotExistException e) {
		MailResponse response=new MailResponse();
		
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		
		return response;
	}
}
