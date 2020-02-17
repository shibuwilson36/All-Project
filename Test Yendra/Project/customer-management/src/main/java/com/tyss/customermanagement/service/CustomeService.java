package com.tyss.customermanagement.service;

import java.util.List;

import com.tyss.customermanagement.dto.CustomerInfoBean;
import com.tyss.customermanagement.dto.PartnerInfoBean;

public interface CustomeService {

	public boolean register(PartnerInfoBean bean);
	
	public boolean addCustomer(CustomerInfoBean bean,int id);
	public boolean addPartner(PartnerInfoBean bean,int id);
	
	public boolean deleteCustomer(int id);
	public boolean deletePartner(int id);
	
	public boolean editCustomer(CustomerInfoBean bean);
	
	
	public PartnerInfoBean getPartnerDetails(int id);
	public List<PartnerInfoBean> getAllPartnerDetails();
	
}
