package com.testyantra.myproperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadFirstFile {

	public static void main(String[] args) {
		
		try {
			FileInputStream input = new FileInputStream("db.properties");
			Properties pro = new Properties();
			pro.load(input);
			System.out.println(pro.getProperty("user"));
			System.out.println(pro.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
