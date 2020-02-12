package com.tyss.junit;

public class BMICalculator {

	public double bmi(int weight,int height) {
		
		double result=(weight/(height*height));
		
		return result;
	}
	public String getBmiResult(double bmi) {
		
		if(bmi<18.5) {
			return "Under weight";
		}else if(bmi>=18.5&&bmi<25.0) {
			return "Normal";
		}else if(bmi>=25&&bmi<35) {
			return "over weight ";
		}else {
			
			return "Obesity";
		}
		
		
	}
}
