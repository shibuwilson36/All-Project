package com.tyss.customermanagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidation {
	public static boolean isValid(String s) { 

		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 

		Matcher m = p.matcher(s); 
		return (m.find() && m.group().equals(s)); 
	} 


} 


