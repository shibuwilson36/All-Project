package com.tyss.hibernateapp.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.tyss.employeapp.dto.Employe;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="employe_adderess_info")
public class EmployeAdderess implements Serializable {
	
	@EmbeddedId
	private AddressPK addressPK;
	@Column
	private String   house_no;
	@Column
	private String   address1;
	@Column
	private String   address2;
	@Column
	private String   landmark;
	@Column
	private String    city;
	@Column
	private int pincode;
	
	@Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	private Employe primary;

}
