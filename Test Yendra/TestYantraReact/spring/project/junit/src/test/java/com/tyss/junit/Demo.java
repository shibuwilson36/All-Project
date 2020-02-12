package com.tyss.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("It is sample test class")
class Demo {
	
	Calculator cal;
	
	
	@BeforeEach
	void createCalculator() {
		 cal=new Calculator();
	}
	@AfterEach
	void destroye() {
		cal=null;
	}
	
	
	@Test
	@DisplayName("Ti is positive number")
	void addTest() {
		
		int i=cal.add(10, 5);
		assertEquals(15, i);
	} 
	
	@Test
	@DisplayName("Ti is addNegitiveTest number")
	void addNegitiveTest() {
		
		int actual=cal.add(-5, -5);
		int expected=-10;
		assertEquals(expected, actual);
	}
	
	@Disabled
	@Test
	void div() {
		
	}
	@Disabled
	@Test
	void sub() {
		
	}

}
