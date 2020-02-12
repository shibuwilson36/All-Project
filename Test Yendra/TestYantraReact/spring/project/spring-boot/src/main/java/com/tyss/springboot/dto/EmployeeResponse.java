package com.tyss.springboot.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<EmployeeInfoBean> beans;
	
}
