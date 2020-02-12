package com.tyss.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Animals;
import com.tyss.springcore.beans.Dog;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;

import lombok.extern.java.Log;

/**
 * Hello world!
 *
 */
@Log
public class App 
{
    public static void main( String[] args )
    {
//       ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
       Hello hello=context.getBean(Hello.class);
       log.info(hello.getMessage());
       log.info(hello.getMap().toString());
       log.info(hello.getList().toString());
       
       Hello hello2=context.getBean(Hello.class);
       log.info(hello2.getMessage());
       log.info(Boolean.toString(hello==hello2));
       
       
       log.info("-----------------------");
       Animals animal=context.getBean(Animals.class);
       
       animal.makeSound();
       log.info("-----------------------");
       Pet pet=context.getBean(Pet.class);
       pet.getAnimals().makeSound();
       log.info(pet.getName());
       
       context.close();
    }
}
