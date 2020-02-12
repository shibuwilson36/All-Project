package com.tyss.springcore;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Animals;
import com.tyss.springcore.beans.Book;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;
import com.tyss.springcore.config.BeanConfig;
import com.tyss.springcore.config.BookConfig;

import lombok.extern.java.Log;
@Log
public class AnnotationConfigBookApp {

	public static void main(String[] args) {
		 ApplicationContext context=new AnnotationConfigApplicationContext(BookConfig.class);
		 
		Book book=context.getBean(Book.class);
		System.out.println(book.getName());
		System.out.println(book.getAuthor().getName());
		System.out.println(book.getAuthor().getPenName());
		log.info("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*");
		log.info(book.getName());
		log.info(book.getAuthor().getName());
		log.info(book.getAuthor().getPenName());
			
			
		
	}
	
	

}
