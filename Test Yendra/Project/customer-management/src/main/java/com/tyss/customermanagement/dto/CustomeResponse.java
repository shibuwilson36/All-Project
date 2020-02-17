package com.tyss.customermanagement.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomeResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<CustomerInfoBean> customer;
	private List<PartnerInfoBean> partner;
	
}
