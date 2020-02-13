package com.tyss.mailsimulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tyss.mailsimulation.Exception.EmailAlreadyException;
import com.tyss.mailsimulation.dto.UserInfoBean;
import com.tyss.mailsimulation.service.MailService;
import com.tyss.mailsimulation.service.MailServiceImpl;

class RegisterTest {

	
	
	
	@Test
	void registerEmailNullTest() {
		MailService service=new MailServiceImpl();
		UserInfoBean bean=new UserInfoBean();
		boolean actual=service.register(bean);
		boolean expected=false;
		assertEquals(expected, actual);
	}
	@Test
	void registerUserBeanNullTest() {
		MailService service=new MailServiceImpl();
		UserInfoBean bean=null;
		boolean actual=service.register(bean);
		boolean expected=false;
		assertEquals(expected, actual);
	}
	@Test
	void registerEmailExistTest() {
		MailService service=new MailServiceImpl();
		UserInfoBean bean=new UserInfoBean();
		bean.setEmail("shibuwilson36@gmail.com");
		assertThrows(Exception.class, ()->{
			service.register(bean);
			service.register(bean);
		});
	}

}
