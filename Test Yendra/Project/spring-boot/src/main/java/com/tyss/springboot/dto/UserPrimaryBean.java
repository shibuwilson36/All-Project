package com.tyss.springboot.dto;

import java.io.Serializable;
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

@Entity
@Data
@Table(name="user_primary_info")
public class UserPrimaryBean implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column
	private String userName;
	@Column(unique = true)
	private String  email;
	@Column
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserSecondaryBean secondary;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fromId")
	private List<InboxBean> inbox;
}
