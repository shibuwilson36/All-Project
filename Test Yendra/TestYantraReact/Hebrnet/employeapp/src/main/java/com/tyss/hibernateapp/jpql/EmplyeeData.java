package com.tyss.hibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.employeapp.dto.Employe;

public class EmplyeeData {

	public static void main(String[] args) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			String jpql="select m from Employe m";
			Query query=manager.createQuery(jpql);
			List<Employe> result= query.getResultList();
			
			
			
			for (Employe employe : result) {
				
				System.out.println(employe.getEmpid());
				System.out.println(employe.getEname());
				
			}

	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}



	}

}
