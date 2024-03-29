package com.tyss.hibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tyss.hibernateapp.dto.Movie;

public class DeleteDynamic {

	public static void main(String[] args) {

		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			String jpql="delete from Movie m where m.id=:mid";
			Query query=manager.createQuery(jpql);
			query.setParameter("mid", 102);
			int result= query.executeUpdate();
			transaction.commit();
			
		if(result>0) {
			System.out.println("deleted "+" "+result+" row");
		}else {
			System.out.println("Not Deleted");
		}

	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}



	}

}
