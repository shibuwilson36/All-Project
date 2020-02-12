package com.tyss.employeapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employeapp.dto.Employe;

public class FindDemo {

	public static void main(String[] args) {


		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			Employe result =manager.find(Employe.class, 102);
			
			System.out.println(result.getEname());
			System.out.println(result.getMobile());
			System.out.println(result.getSalary());
			System.out.println(result.getAge());
			System.out.println(result.getPassword());
	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}

	}

}
