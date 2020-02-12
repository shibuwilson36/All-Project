package com.tyss.springcore.beans;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animals {

	@Override
	public void makeSound() {
		
		System.out.println("bao bayooo");

	}

}
