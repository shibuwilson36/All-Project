package com.tyss.customermanagement.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="customer_info")
public class CustomerInfoBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customeId;
	@Column
	private String name;
	@Column(unique = true)
	private String email;	
	@Column
	private long mobile;
	@Column
	private String dateOfBirth;
	@Column
	private boolean status;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressInfoBean address;
	
	
	
}
