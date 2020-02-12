package com.tyss.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalculatorTest {

	
	
	@Test
	void bmiTest() {
		BMICalculator calculator=new BMICalculator();
		double actual=calculator.bmi(10, 1);
		double expected=10;
		assertEquals(expected, actual);
	}
 
}