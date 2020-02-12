package com.tyss.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.springmvc.beans.User;

@Controller
public class SpringController {

//	@RequestMapping("/hello")
//	public String hello(ModelMap map) {
//		map.addAttribute("msg","hello world.....");
//		return "index";
//	}
	@RequestMapping("/hello")
	public ModelAndView hello( ) {
		ModelAndView map=new ModelAndView();
		map.setViewName("index");
		map.addObject("msg","hello world.....!!!!");
		return map;
	}
	//Query String


	@GetMapping("/query")
	public String query(@RequestParam(name="name",required = false )String name,
			@RequestParam(name="age",required = false)Integer age,ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("age", age);
		return "query";
	}//end of query
	@GetMapping("/form")
	public String form() {
		return "form";
	}//end of form
//	@PostMapping("/form")
//	public String form(String name,String email,long mobile,String password, ModelMap map) {
//		map.addAttribute("name",name);
//		map.addAttribute("email",email);
//		map.addAttribute("mobile",mobile);
//		map.addAttribute("password",password);
//		return "form-data";
//	}
	@PostMapping("/form")
	public String form(User user, ModelMap map) {
		map.addAttribute("name",user.getName());
		map.addAttribute("email",user.getEmail());
		map.addAttribute("mobile",user.getMobile());
		map.addAttribute("password",user.getPassword());
		return "form-data";
	}//end form
	@GetMapping("/path/{name}")
	public String path(@PathVariable("name") String name,ModelMap map) {
		map.addAttribute("name", name);
		return "path";
	}
	@GetMapping("/create-cookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name","Surya");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		return "create-cookie";
	}
	@GetMapping("/read-cookie")
	public String readCookie(@CookieValue(name="name",required = false)String name,ModelMap map) {
		map.addAttribute("name", name);
		
		
		return "read-cookie";
	}
	@GetMapping("/forward")
	public String forward() {
		return "forward:hello";
	}
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:https://www.google.com";
	}
		
		
	

}//end of springController
