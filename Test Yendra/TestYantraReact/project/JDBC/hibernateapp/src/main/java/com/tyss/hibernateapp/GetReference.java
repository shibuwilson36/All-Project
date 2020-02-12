package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Movie;

public class GetReference {

	public static void main(String[] args) {


		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;

		try {
			factory=Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
//			Movie result =manager.find(Movie.class, 102); 
			//if use find method  this method hit the data base whenever run the code
			//it will give crct address of the class 
			//if primary key not presnt it will
			Movie result =manager.getReference(Movie.class, 102);
			//it will give proxy address of the class
			//if primary key not presnt it will give javax.persistence.EntityNotFoundException
			
			System.out.println(result.getClass());
			System.out.println(result.getId());
			System.out.println(result.getName());
			System.out.println(result.getRating());
	
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
			factory.close();
		}

	}

}
