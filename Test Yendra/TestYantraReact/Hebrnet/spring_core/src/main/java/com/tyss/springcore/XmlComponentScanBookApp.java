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
public class XmlComponentScanBookApp {

	public static void main(String[] args) {
		 ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		 
		
			Book book=context.getBean(Book.class);
			book.getAuthor().setName("Author Name");
			book.setName("Book Name");
			System.out.println("*-*-*-*-*-*-*-*-*-*--*-*-*-*-**-");
			
			System.out.println(book.getName());
			System.out.println(book.getAuthor().getName());
			
			
		
	}
	
	

}
