package com.tyss.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="product_info")
public class ProductInfoBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String productName;
	@Column
	private double price;
	@Column
	private int quntity;
	@Column
	private String description;
	@Column
	private String productImage;
	
	
	
}
