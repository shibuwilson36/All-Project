package com.tyss.hibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tyss.hibernateapp.dto.Movie;


public class ReadDemo {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			String jpql="select m from Movie m";
			TypedQuery<Movie> query=manager.createQuery(jpql,Movie.class);
			List<Movie> result= query.getResultList();
			
			for (Movie movie : result) {
				System.out.println(movie.getId());
				System.out.println(movie.getName());
				System.out.println(movie.getRating());
			}

	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}


	}

}
