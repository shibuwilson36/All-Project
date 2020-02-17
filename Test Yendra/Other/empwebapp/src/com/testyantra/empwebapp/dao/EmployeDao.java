package com.testyantra.empwebapp.dao;

import com.testyantra.empwebapp.bean.EmployeBean;

public interface EmployeDao {
	
	public EmployeBean searchEmpId(int id);
	public EmployeBean authentication(int id,String password);
	public boolean addEmploye(EmployeBean bean);
	public boolean updateEmploye(EmployeBean bean);


}
