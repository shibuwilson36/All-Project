package com.tyss.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tyss.springcore.beans.Cat;
import com.tyss.springcore.beans.Dog;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;

@Configuration
public class BeanConfig {
	@Bean(name="hello" )
//	@Scope("prototype")
	public Hello getHello() {
		Hello hello = new Hello();
		hello.setMessage("I love Spring");
		return hello;
	}
//	@Bean("beanFactoryPostProcessor")
//	public BeanFactoryPostProcessor  getBeanFactoryPostProcessor() {
//		return new BeanFactoryPostProcessorImpl();
//	}
//	
//	@Bean("beanPostProcessor")
//	public BeanPostProcessor getBeanPostProcessor() {
//		return new BeanPostProcessorImpl();
//	}
	
	@Bean
	public Dog getDog() {
		return new Dog();
	}
	
	@Bean
	@Primary
	public Cat getCat() {
		return new Cat();
	}
	
	@Bean
	public Pet getPet() {
//		Pet pet = new Pet("Browni",getDog());
		Pet pet = new Pet();
		pet.setName("Browni");
//		pet.setAnimals(getDog());
		return pet;
	}
	
	
	
	
}
