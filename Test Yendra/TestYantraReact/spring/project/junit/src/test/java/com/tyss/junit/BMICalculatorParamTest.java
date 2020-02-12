package com.tyss.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BMICalculatorParamTest {

	@ParameterizedTest
	@MethodSource("getBmiValues")
	void getBmiResultTest(double value,String result) {
		BMICalculator bmi=new BMICalculator();
		String actual=bmi.getBmiResult(value);
		assertEquals(result, actual);
	}
 
	static Stream<Arguments> getBmiValues(){
		return Stream.of(Arguments.arguments(15.5,"Under weight"),
				Arguments.arguments(15.5,"Under weight"),
				Arguments.arguments(15.5,"Under weight"),
				Arguments.arguments(19.5,"Normal"));
	}
}
