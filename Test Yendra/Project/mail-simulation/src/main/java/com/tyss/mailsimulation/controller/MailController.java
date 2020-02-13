package com.tyss.mailsimulation.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.mailsimulation.dto.InboxBean;
import com.tyss.mailsimulation.dto.MailResponse;
import com.tyss.mailsimulation.dto.UserInfoBean;
import com.tyss.mailsimulation.service.MailService;

@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RestController
public class MailController {

	@Autowired
	MailService service;
	static Logger log=LogManager.getLogger("mail-simulation");

	@PostMapping(path="/register",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MailResponse register(@RequestBody UserInfoBean bean) {
		MailResponse response=new MailResponse();

		if(service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Inserted into the db");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not Inserted into the db");

		}

		return response;

	}
	@PostMapping(path="/auth",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MailResponse auth(HttpServletRequest request,@RequestBody UserInfoBean bean) {
		MailResponse response=new MailResponse();
		log.info("Login");
		UserInfoBean infoBean=service.auth(bean.getEmail(),bean.getPassword());
		if(infoBean!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("bean", bean);
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Login Success");
			response.setUserData(Arrays.asList(infoBean));

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Login failure");

		}

		return response ;

	}
	@PostMapping(path="/mail",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MailResponse sentMessage(@RequestBody InboxBean bean,@SessionAttribute(name="bean", required = false)UserInfoBean beans) {
		MailResponse response=new MailResponse();


		if(beans!=null) {

			bean.setFromId(service.getToId(beans.getEmail()));
			bean.setToId(service.getToId("shibu360"));
			if(service.sentMessage(bean)) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("“Mail Delivery ”");

			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Mail Delivery Failed");

			}
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("ivalid");
		}

		return response;

	}
	@GetMapping(path="/inbox",produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse search(@SessionAttribute(name="bean", required = false)UserInfoBean bean) {
		MailResponse response=new MailResponse();
		if(bean!=null) {
			List<InboxBean> beans=service.getUserInbox(service.getToId(bean.getEmail()));
			if(beans!=null&&!beans.isEmpty()) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Data  found");
				response.setInboxData(beans);
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Data not found");

			}
		}
		return response;

	}
	@GetMapping("/logout")
	public MailResponse logout(HttpSession  session) {

		MailResponse response=new MailResponse();
		UserInfoBean bean=(UserInfoBean) session.getAttribute("bean");
		if(bean!=null) {
			session.invalidate();

			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data  found");


		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not found");
		}
		return response;

	}
	@GetMapping(path="/inbox/sentbox",produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse getUserSentBox(@SessionAttribute(name="bean", required = false)UserInfoBean bean) {
		MailResponse response=new MailResponse();
		log.info(bean.getEmail().isEmpty());
		if(bean!=null) {
			List<InboxBean> beans=service.getUserSentBox(bean.getId());
			if(beans!=null&&!beans.isEmpty()) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Data  found");
				response.setInboxData(beans);
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Data not found");

			}
		}
		return response;

	}
	@PostMapping(path="/forget",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MailResponse changePassword(@RequestBody UserInfoBean bean) {
		MailResponse response=new MailResponse();
		
			if(service.ChangePassword(bean)) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Data  found");
				
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Data not found");

			}
		
		return response;
	}
}
