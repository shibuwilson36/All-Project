package com.tyss.customermanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="address_info")
public class AddressInfoBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int addresId;
	@Column
	private String houseName;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private int pin;
	
}
