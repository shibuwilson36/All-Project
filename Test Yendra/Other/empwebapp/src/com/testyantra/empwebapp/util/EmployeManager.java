package com.testyantra.empwebapp.util;

import com.testyantra.empwebapp.dao.EmployeDao;
import com.testyantra.empwebapp.dao.EmployeDaoImp;

public class EmployeManager {

	private EmployeManager() {
		
	}
	public static EmployeDao getInstance() {
		
		return new EmployeDaoImp();
	}
}
