package com.tyss.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Animals;
import com.tyss.springcore.beans.Book;
import com.tyss.springcore.beans.Dog;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;

import lombok.extern.java.Log;

/**
 * Hello world!
 *
 */
@Log
public class BookApp 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("book.xml");
       Book book=context.getBean(Book.class);
       
       log.info("Book Name "+book.getName());
       log.info("Author PenName "+book.getAuthor().getPenName());
       log.info("Author Name "+book.getAuthor().getName());
       
      
    }
}
