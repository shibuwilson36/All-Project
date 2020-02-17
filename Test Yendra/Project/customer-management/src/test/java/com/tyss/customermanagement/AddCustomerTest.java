package com.tyss.customermanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.tyss.customermanagement.dto.CustomerInfoBean;
import com.tyss.customermanagement.service.CustomeService;
import com.tyss.customermanagement.service.CustomeServiceImpl;
import com.tyss.customermanagement.util.DateValidation;
import com.tyss.customermanagement.util.MobileNumberValidation;

class AddCustomerTest {

	@Test
	void registerEmailNullTest() {
		CustomeService service=new CustomeServiceImpl();
		CustomerInfoBean bean=new CustomerInfoBean();
		boolean actual=service.addCustomer(bean,1);
		boolean expected=false;
		assertEquals(expected, actual);
	}
	@Test
	void registerUserBeanNullTest() {
		CustomeService service=new CustomeServiceImpl();
		CustomerInfoBean bean=null;
		boolean actual=service.addCustomer(bean,1);
		boolean expected=false;
		assertEquals(expected, actual);
	}
	@Test
	void registerEmailExistTest() {
		CustomeService service=new CustomeServiceImpl();
		CustomerInfoBean bean=new CustomerInfoBean();
		bean.setEmail("shibuwilson36@gmail.com");
		assertThrows(Exception.class, ()->{
			service.addCustomer(bean,1);
			service.addCustomer(bean,1);
		});
	}
	@ParameterizedTest
	@MethodSource("validate")
	void getValidateResultTest(String value,boolean result) {
		boolean actual=DateValidation.validateJavaDate(value);
		assertEquals(result, actual);
	}
 
	static Stream<Arguments> validate(){
		return Stream.of(Arguments.arguments("12/2/2016",true),
				Arguments.arguments("31/2/2016",false),
				Arguments.arguments("29/2/2020",true),
				Arguments.arguments("hftytd",false));
	}
	@ParameterizedTest
	@MethodSource("validateMobile")
	void getMobileResultTest(String value,boolean result) {
		boolean actual=MobileNumberValidation.isValid(value);
		assertEquals(result, actual);
	}
	
	static Stream<Arguments> validateMobile(){
		return Stream.of(Arguments.arguments("9562645910",true),
				Arguments.arguments("0000000000",false),
				Arguments.arguments("+919562645910",false),
				Arguments.arguments("hftytd",false));
	}

}
