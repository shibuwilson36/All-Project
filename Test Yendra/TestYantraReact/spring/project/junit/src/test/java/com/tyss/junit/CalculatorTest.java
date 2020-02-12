package com.tyss.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator cal;
	
	@BeforeAll
	static void runBeforAll() {
		System.out.println("Run before All");
	}
	@BeforeEach
	void createCalculator() {
		System.out.println("I am @BeforeEach");
		 cal=new Calculator();
	}
	@AfterEach
	void destroye() {
		cal=null;
	}
	@AfterAll
	static void runAfterAll() {
		System.out.println("Run after All");
	
	}
	
	@Test
	void addTest() {
		
		int i=cal.add(10, 5);
		assertEquals(15, i);
	} 
	
	@Test
	void addNegitiveTest() {
		
		int actual=cal.add(-5, -5);
		int expected=-10;
		assertEquals(expected, actual);
	}

}
