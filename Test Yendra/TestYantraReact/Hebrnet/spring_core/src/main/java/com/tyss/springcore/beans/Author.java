package com.tyss.springcore.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Author {

	private String name;
	private String penName;
	public Author() {
		// TODO Auto-generated constructor stub
	}
	public Author(String name, String penName) {
		super();
		this.name = name;
		this.penName = penName;
	}
	
}
