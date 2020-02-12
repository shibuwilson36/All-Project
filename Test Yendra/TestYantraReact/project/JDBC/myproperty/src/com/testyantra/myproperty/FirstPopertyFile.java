package com.testyantra.myproperty;

import java.io.FileOutputStream;
import java.util.Properties;

public class FirstPopertyFile {

	public static void main(String[] args) {

		try {
			FileOutputStream stream = new FileOutputStream("first property file");
			Properties pro=new Properties();
			pro.setProperty("name", "Shibu");
			pro.setProperty("mobile", "9562645910");
			pro.store(stream, "new file");
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//end of the method

}//end of the class
