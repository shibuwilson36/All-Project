package com.tyss.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springboot.dto.EmployeeInfoBean;
import com.tyss.springboot.dto.EmployeeResponse;
import com.tyss.springboot.service.EmployeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeService service;

	@GetMapping(path="/search",produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse search(@RequestParam(name="name",required = false)String name) {
		EmployeeResponse response=new EmployeeResponse();
		List<EmployeeInfoBean> beans=service.search(name);
		if(beans!=null&&!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data  found");
			response.setBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not found");
			response.setBeans(null);
		}
		return response;

	}
	@PostMapping(path="/register",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public EmployeeResponse register(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response=new EmployeeResponse();

		if(service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Inserted into the db");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not Inserted into the db");

		}

		return response;

	}
	@PostMapping(path="/auth",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public EmployeeResponse auth(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response=new EmployeeResponse();

		EmployeeInfoBean infoBean=service.auth(bean.getEmail(),bean.getPassword());
		if(infoBean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Login Success");
			response.setBeans(Arrays.asList(infoBean));

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Login failure");

		}

		return response ;

	}
	@PostMapping(path="/change-password",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public EmployeeResponse changePassword(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response=new EmployeeResponse();

		if(service.changePassword(bean.getId(),bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Password Change");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Password not Change");

		}

		return response;

	}
	@DeleteMapping(path="/delete/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public EmployeeResponse deleteEmploye( @PathVariable("id") int id) {
		EmployeeResponse response=new EmployeeResponse();

		if(service.deleteEmploye(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("deleted");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription(" not deleted");

		}

		return response;

	}



}
