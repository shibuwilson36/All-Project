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
import com.tyss.springcore.config.SpringConfig;

import lombok.extern.java.Log;
@Log
public class AnnotationComponentScanApp {

	public static void main(String[] args) {
		 ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		 
		
			Animals animals=context.getBean(Animals.class);
			animals.makeSound();
			System.out.println("*-*-*-*-*-*-*-*-*-*--*-*-*-*-**-");
			Pet pet=context.getBean(Pet.class);
			pet.setName("opijuy");
			System.out.println(pet.getName());
			pet.getAnimals().makeSound();
			
		
	}
	
	

}
