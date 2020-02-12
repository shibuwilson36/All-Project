package com.tyss.springcore.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class Hello implements InitializingBean,DisposableBean {
	private String message;
	private Map<Integer, String> map;
	private List<String> list;
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	public Hello() {
		System.out.println("Hello object created");
	}
	public Hello(String message) {

		this.message=message;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method");
		
	}
	
@PostConstruct
	public void init() {
		System.out.println("Init method");

	}
	
	public void destroy()  {
	System.out.println("destroy-method");

	}
	
	

	
	


}
