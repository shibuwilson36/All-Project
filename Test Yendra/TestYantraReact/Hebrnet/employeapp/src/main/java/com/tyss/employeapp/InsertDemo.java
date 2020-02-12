package com.tyss.employeapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employeapp.dto.Employe;

public class InsertDemo {

	public static void main(String[] args) {

		Employe entity=new Employe();

		entity.setEmpid(8202);
		entity.setEname("Lucifer");
		entity.setPassword("good");
		entity.setAge(20);
		entity.setMobile(55555555555l);
		entity.setSalary(55.2);
		entity.setPassword("ugyft");
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			System.out.println("added");

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
			factory.close();
		}




	}

}
