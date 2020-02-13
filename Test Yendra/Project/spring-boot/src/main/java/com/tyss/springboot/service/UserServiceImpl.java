package com.tyss.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springboot.dao.UserDao;
import com.tyss.springboot.dto.InboxBean;
import com.tyss.springboot.dto.UserPrimaryBean;
import com.tyss.springboot.dto.UserSecondaryBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	public boolean registerUserPrimary(UserPrimaryBean primaryBean) {
		
		return dao.registerUserPrimary(primaryBean);
	}

	@Override
	public boolean sentMessage(InboxBean bean) {
		
		return dao.sentMessage(bean);
	}


	
}
