package com.tyss.empspringmvc.dao;

import java.util.List;

import com.tyss.empspringmvc.dto.EmployeeInfoBean;

public interface EmployeeDAO {
	public EmployeeInfoBean auth(String email,String password);
	public boolean register(EmployeeInfoBean bean);
	public boolean changePassword(int id,String password);
	public List<EmployeeInfoBean> search(String name);

}
