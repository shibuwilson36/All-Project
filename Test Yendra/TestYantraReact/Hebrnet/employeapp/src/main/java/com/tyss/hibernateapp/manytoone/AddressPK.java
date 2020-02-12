package com.tyss.hibernateapp.manytoone;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AddressPK implements Serializable{
	
	private int emp_id;
	private String  address_type;
}
