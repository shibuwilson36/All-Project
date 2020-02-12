package com.tyss.employeapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.employeapp.dto.Employe;

public class RemoveDemo {

	public static void main(String[] args) {

		Employe entity=new Employe();

		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			Employe record=manager.find(Employe.class, 101);
			manager.remove(record);
			transaction.commit();
			System.out.println("removed");

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
			factory.close();
		}




	}

}
