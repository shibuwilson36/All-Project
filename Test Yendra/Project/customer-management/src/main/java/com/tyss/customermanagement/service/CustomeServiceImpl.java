package com.tyss.customermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.tyss.customermanagement.dao.CustomerDao;
import com.tyss.customermanagement.dto.CustomerInfoBean;
import com.tyss.customermanagement.dto.PartnerInfoBean;
import com.tyss.customermanagement.util.DateValidation;
import com.tyss.customermanagement.util.MobileNumberValidation;
import com.tyss.customermanagement.util.RegisterValidation;

@Service
public class CustomeServiceImpl implements CustomeService {

	@Autowired
	CustomerDao dao;
	final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	@Override
	public boolean addCustomer(CustomerInfoBean bean,int id) {

		if(bean==null) {
			return false;
		}
		if(bean.getEmail()!=null) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(bean.getEmail());
			if(matcher.find()&&
					DateValidation.validateJavaDate(bean.getDateOfBirth())&&
					MobileNumberValidation.isValid(Long.toString(bean.getMobile()))) {

				return dao.addCustomer(bean,id);
			}else {
				return false;
			}
		}else {
			return false;
		}


	}

	@Override
	public boolean editCustomer(CustomerInfoBean bean) {
		if(RegisterValidation.isValid(bean)) {
			return dao.editCustomer(bean);
		}
		return false;

	}

	@Override
	public boolean deleteCustomer(int id) {
		if(dao.getCustomer(id)==null) {
			return false;
		}
		if(dao.getCustomer(id).isStatus()) {
			return false;
		}
		return dao.deleteCustomer(id);
	}



	@Override
	public boolean register(PartnerInfoBean bean) {
		if(bean==null) {
			return false;
		}
		if(bean.getEmail()!=null) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(bean.getEmail());
			if(matcher.find()&&
					DateValidation.validateJavaDate(bean.getDateOfBirth())&&
					MobileNumberValidation.isValid(Long.toString(bean.getMobile()))) {

				return dao.register(bean);
			}else {
				return false;
			}
		}else {
			return false;
		}

	}


	@Override
	public PartnerInfoBean getPartnerDetails(int id) {
		PartnerInfoBean bean=dao.getPartnerDetails(id);
		List<CustomerInfoBean> list=dao.findCustomer(id);
		if(list!=null) {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).isStatus()) {
					list.remove(i);
				}
			}
			bean.setCustomer(list);
		}

		return bean;
	}

	@Override
	public boolean addPartner(PartnerInfoBean bean, int id) {
		if(bean==null) {
			return false;
		}
		if(bean.getEmail()!=null) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(bean.getEmail());
			if(matcher.find()&&
					DateValidation.validateJavaDate(bean.getDateOfBirth())&&
					MobileNumberValidation.isValid(Long.toString(bean.getMobile()))) {

				return dao.addPartner(bean, id);
			}else {
				return false;
			}
		}else {
			return false;
		}

	}

	@Override
	public boolean deletePartner(int id) {

		return dao.deletePartner(id);
	}

	@Override
	public List<PartnerInfoBean> getAllPartnerDetails() {
		
		return dao.getAllPartnerDetails();
	}


}
