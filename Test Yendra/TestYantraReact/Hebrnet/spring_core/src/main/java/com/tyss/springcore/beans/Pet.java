package com.tyss.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Pet {

	private String name;
	
	@Autowired
//	@Qualifier
	private Animals animals;
	public Pet() {}
	
	public Pet(String name, Animals animals) {
		super();
		this.name = name;
		this.animals = animals;
	}

	
	
}
