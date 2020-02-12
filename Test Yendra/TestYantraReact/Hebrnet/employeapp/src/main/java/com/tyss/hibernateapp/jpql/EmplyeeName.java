package com.tyss.hibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class EmplyeeName {

	public static void main(String[] args) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			String jpql="select m.ename from Employe m";
//			Query query=manager.createQuery(jpql);
			TypedQuery<String> query=manager.createQuery(jpql,String.class);
			List<String> result= query.getResultList();
			
			
			
			for (String employe : result) {
				
				System.out.println("Name :"+employe);
				
			}

	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}



	}

}
