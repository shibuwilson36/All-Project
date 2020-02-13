package com.tyss.mailsimulation.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user_info")
public class UserInfoBean implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String userName;
	@Column(unique = true)
	private String email;
	@Column
	private String image;
	@Column
	private String password;	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fromId")
	private List<InboxBean> inbox;
	
}
