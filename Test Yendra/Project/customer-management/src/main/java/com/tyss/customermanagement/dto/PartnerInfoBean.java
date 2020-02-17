package com.tyss.customermanagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Entity
@Data
@Table(name="partner_info")
public class PartnerInfoBean {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int partnerId;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerInfoBean> customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PartnerInfoBean> partner;
	
}
