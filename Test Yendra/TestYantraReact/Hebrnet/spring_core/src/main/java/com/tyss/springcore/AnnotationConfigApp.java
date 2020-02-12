package com.tyss.springcore;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Animals;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;
import com.tyss.springcore.config.BeanConfig;

import lombok.extern.java.Log;
@Log
public class AnnotationConfigApp {

	public static void main(String[] args) {
		 ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
		 
		 Hello hello =context.getBean(Hello.class);
			log.info(hello.getMessage());
			
			Hello hello1 =context.getBean(Hello.class);
			log.info(Boolean.toString(hello==hello1));
			log.info(hello1.getMessage());
			log.info("-----------------------");
			
			Animals animal = context.getBean(Animals.class);
			animal.makeSound();
			
			Pet pet= context.getBean(Pet.class);
			
			log.info(pet.getName());
			pet.getAnimals().makeSound();
			
			
		
	}
	
	

}
