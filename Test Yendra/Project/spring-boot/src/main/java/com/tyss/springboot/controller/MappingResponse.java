package com.tyss.springboot.controller;

import java.util.List;

import lombok.Data;


@Data
public class MappingResponse {

	private int statusCode;
	private String message;
	private String description;
	
}
