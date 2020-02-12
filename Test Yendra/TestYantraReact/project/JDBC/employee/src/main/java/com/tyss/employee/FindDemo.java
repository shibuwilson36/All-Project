package com.tyss.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employee.dto.Employee;


public class FindDemo {

	public static void main(String[] args) {


		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			Employee result =manager.find(Employee.class, 101);
			
			System.out.println(result.getEmpid());
			System.out.println(result.getEname());
			System.out.println(result.getSalary());
	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}

	}

}
