package com.tyss.springboot.service;

import java.util.List;

import com.tyss.springboot.dto.EmployeeInfoBean;



public interface EmployeService {
	
	public EmployeeInfoBean auth(String email,String password);
	public boolean register(EmployeeInfoBean bean);
	public boolean changePassword(int id,String password);
	public List<EmployeeInfoBean> search(String name);
	public boolean deleteEmploye(int id);

}
