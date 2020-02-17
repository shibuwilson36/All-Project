package com.tyss.customermanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateValidation {

	public static boolean validateJavaDate(String strDate){
		
//		Calendar cal = Calendar.getInstance();
//		cal.setLenient(false);
//		cal.setTime(strDate);
//		try {
//		    cal.getTime();
//		}
//		catch (Exception e) {
//		  System.out.println("Invalid date");
//		}
		if (strDate.trim().equals("")){
			return false;
		}else{

			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
			sdfrmt.setLenient(false);
			try
			{
				Date javaDate = sdfrmt.parse(strDate); 
			}
			catch (ParseException e)
			{

				return false;
			}
			return true;
		}
	}
	

}
