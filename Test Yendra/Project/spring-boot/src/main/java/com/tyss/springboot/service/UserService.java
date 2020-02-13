package com.tyss.springboot.service;

import com.tyss.springboot.dto.InboxBean;
import com.tyss.springboot.dto.UserPrimaryBean;
import com.tyss.springboot.dto.UserSecondaryBean;

public interface UserService {

	public boolean registerUserPrimary(UserPrimaryBean primaryBean);
	public boolean sentMessage(InboxBean bean );
	
}
