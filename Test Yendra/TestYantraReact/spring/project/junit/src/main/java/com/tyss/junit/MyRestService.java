package com.tyss.junit;

public class MyRestService {
	
	public String getStudentName() {
		return "Nidhin";
	}
	public String getTeachertName() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Nidhin";
	}

}
