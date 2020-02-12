package com.testyantra.calculator;

import java.io.FileWriter;
import java.util.Properties;

public class Property {

	public static void main(String[] args) {
		try {
			Properties p=new Properties();  
			p.setProperty("name","Sonoo Jaiswal");  
			p.setProperty("email","sonoojaiswal@javatpoint.com");  
			FileWriter myWriter = new FileWriter("filename.properties"); 
			 myWriter.write("Files in Java might be tricky, but it is fun enough!");
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}  



	}

}
