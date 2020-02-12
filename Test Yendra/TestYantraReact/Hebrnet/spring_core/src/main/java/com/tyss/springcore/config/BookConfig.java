package com.tyss.springcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tyss.springcore.beans.Author;
import com.tyss.springcore.beans.Book;

@Configuration
public class BookConfig {
	
	@Bean
	public Author getAuthor() {
//		Author author=new Author();
		Author author=new Author("Author Name","hgfd");
//		author.setName("Author Name");
//		author.setPenName("hgfd");;
		return author;
	}
	@Bean
	public Book getBook() {
		Book book=new Book();
		book.setName("Book Name");
//		book.setAuthor(getAuthor());
		return book;
	}
}
