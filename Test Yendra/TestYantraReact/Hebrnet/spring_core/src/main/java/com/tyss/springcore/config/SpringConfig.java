package com.tyss.springcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tyss.springcore.beans.Author;
import com.tyss.springcore.beans.Book;

@Configuration
@ComponentScan(basePackages ="com.tyss.springcore.beans")
@Import(BeanConfig.class)
public class SpringConfig {
	
	
}
