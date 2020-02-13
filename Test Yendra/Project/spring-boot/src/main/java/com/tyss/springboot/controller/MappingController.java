package com.tyss.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springboot.dto.InboxBean;
import com.tyss.springboot.dto.UserPrimaryBean;
import com.tyss.springboot.service.UserService;


@RestController
public class MappingController {

	@Autowired
	UserService service;
	@PostMapping(path="/register",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MappingResponse register(@RequestBody UserPrimaryBean bean) {
		MappingResponse response=new MappingResponse();

		if(service.registerUserPrimary(bean)) {
			response.setMessage("done");

		}else {
			response.setMessage("not done");

		}
		return response;
	}

	@PostMapping(path="/mail",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MappingResponse sentMessage(@RequestBody InboxBean bean) {
		MappingResponse response=new MappingResponse();

		if(service.sentMessage(bean)) {
			response.setMessage("done");

		}else {
			response.setMessage("not done");

		}
		return response;
	}
}
