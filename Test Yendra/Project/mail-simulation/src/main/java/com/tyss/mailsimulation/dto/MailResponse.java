package com.tyss.mailsimulation.dto;

import java.util.List;

import lombok.Data;

@Data
public class MailResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<UserInfoBean> userData;
	private List<InboxBean> inboxData;
	
}
