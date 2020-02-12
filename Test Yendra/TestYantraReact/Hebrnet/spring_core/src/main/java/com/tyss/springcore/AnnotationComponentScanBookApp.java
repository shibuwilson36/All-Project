package com.tyss.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.beans.Book;
import com.tyss.springcore.config.SpringConfig;

import lombok.extern.java.Log;
@Log
public class AnnotationComponentScanBookApp {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);


		Book book=context.getBean(Book.class);
		book.getAuthor().setName("Author Name");
		book.setName("Book Name");
		System.out.println("*-*-*-*-*-*-*-*-*-*--*");

		System.out.println("* "+book.getName()+"          *");
		System.out.println("* "+book.getAuthor().getName()+"        *");

		System.out.println("*-*-*-*-*-*-*-*-*-*--*");

	}



}
