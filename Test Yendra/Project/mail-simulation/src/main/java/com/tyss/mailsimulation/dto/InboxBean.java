package com.tyss.mailsimulation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mail_info")
public class InboxBean {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int fromId;
	@Column
	private int toId;
	@Column
	private String subject;
	@Column
	private String message;
	@Column
	private String status;
	

}
