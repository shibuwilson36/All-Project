package com.tyss.springboot.dao;

import com.tyss.springboot.dto.InboxBean;
import com.tyss.springboot.dto.UserPrimaryBean;
import com.tyss.springboot.dto.UserSecondaryBean;

public interface UserDao {

	public boolean registerUserPrimary(UserPrimaryBean primaryBean);
	public boolean sentMessage(InboxBean bean );
	
	
}
