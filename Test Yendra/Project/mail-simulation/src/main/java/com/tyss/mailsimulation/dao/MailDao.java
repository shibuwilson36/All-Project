package com.tyss.mailsimulation.dao;

import java.util.List;

import com.tyss.mailsimulation.dto.InboxBean;
import com.tyss.mailsimulation.dto.UserInfoBean;

public interface MailDao {
	
	public boolean register(UserInfoBean bean);
	public boolean sentMessage(InboxBean bean);
	public UserInfoBean auth(String email,String password);
	public List<InboxBean> getUserInbox(int userId);
	public List<InboxBean> getUserSentBox(int fromId);
	public int getToId(String email);
	public boolean ChangePassword(UserInfoBean bean);
	
	

}
