package com.tyss.mailsimulation.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.mailsimulation.dao.MailDao;
import com.tyss.mailsimulation.dto.InboxBean;
import com.tyss.mailsimulation.dto.UserInfoBean;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	MailDao dao;

	final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);



	@Override
	public boolean register(UserInfoBean bean) {
		if(bean==null) {
			return false;
		}
		if(bean.getEmail()!=null) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(bean.getEmail());
			if(matcher.find()) {
				return dao.register(bean);
			}else {
				return false;
			}
		}else {
			return false;
		}

		
	}

	@Override
	public UserInfoBean auth(String email, String password) {

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
		if(matcher.find()) {
			return dao.auth(email, password);
		}else {
			return null;

		}
	}

	@Override
	public boolean sentMessage(InboxBean bean) {

		return dao.sentMessage(bean);
	}

	@Override
	public List<InboxBean> getUserInbox(int userId) {

		return dao.getUserInbox(userId);
	}

	@Override
	public List<InboxBean> getUserSentBox(int fromId) {

		return dao.getUserSentBox(fromId);
	}

	@Override
	public int getToId(String email) {

		return dao.getToId(email);
	}

	@Override
	public boolean ChangePassword(UserInfoBean bean) {
		
		return dao.ChangePassword(bean);
	}

}
