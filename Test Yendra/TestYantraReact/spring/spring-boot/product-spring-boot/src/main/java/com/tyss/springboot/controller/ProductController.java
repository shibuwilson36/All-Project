package com.tyss.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springboot.dto.ProductInfoBean;
import com.tyss.springboot.dto.ProductResponse;
import com.tyss.springboot.service.ProductService;

@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping(path="/addproduect",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ProductResponse register(@RequestBody ProductInfoBean bean) {
		ProductResponse response=new ProductResponse();

		if(service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Inserted into the db");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not Inserted into the db");

		}

		return response;

	}
	@PostMapping(path="/update",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ProductResponse changePassword(@RequestBody ProductInfoBean bean) {
		ProductResponse response=new ProductResponse();

		if(service.updateProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Updated");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription(" not Updated");
		}

		return response;

	}
	@GetMapping(path="/allproduect",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse search() {
		ProductResponse response=new ProductResponse();
		List<ProductInfoBean> beans=service.getAllProduct();
		if(beans!=null&&!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data  found");
			response.setBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not found");
			response.setBeans(null);
		}
		return response;

	}
	@GetMapping(path="/search",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse searchByNmae(@RequestParam(name="name",required = false)String name) {
		
		ProductResponse response=new ProductResponse();
		List<ProductInfoBean> beans=service.searchProduct(name);
		if(beans!=null&&!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data  found");
			response.setBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not found");
			response.setBeans(null);
		}
		return response;
		
	}
	@DeleteMapping(path="/delete/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ProductResponse deleteEmploye( @PathVariable("id") int id) {
		ProductResponse response=new ProductResponse();

		if(service.deleteProduct(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("deleted");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription(" not deleted");

		}

		return response;

	}
}
