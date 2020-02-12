package com.tyss.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MyRestServiceTest {

	@Test
	@Timeout(value = 5000,unit = TimeUnit.MILLISECONDS)
	void getStudentNameTest() {
		MyRestService service=new MyRestService();
		String actual=service.getStudentName();
		assertNotNull(actual);
	
	}
	@Test
	@Timeout(value = 5000,unit = TimeUnit.MILLISECONDS)
	void getTeachertNameTest() {
		MyRestService service=new MyRestService();
		String actual=service.getTeachertName();
		assertNotNull(actual);
	}

}
