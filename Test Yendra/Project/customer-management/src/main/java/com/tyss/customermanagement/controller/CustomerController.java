package com.tyss.customermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.customermanagement.dto.CustomeResponse;
import com.tyss.customermanagement.dto.CustomerInfoBean;
import com.tyss.customermanagement.dto.PartnerInfoBean;
import com.tyss.customermanagement.service.CustomeService;
import org.springframework.http.MediaType;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RestController
public class CustomerController {

	@Autowired
	CustomeService service;
	static Logger log=LogManager.getLogger("customer");


	@PostMapping(path="partners/register",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public CustomeResponse addPartner(@RequestBody PartnerInfoBean bean) {
		CustomeResponse response=new CustomeResponse();

		if(service.register(bean)) {
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

	@PostMapping(path="/partners/customer/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public CustomeResponse addCustomer(@RequestBody CustomerInfoBean bean,
			@PathVariable("id") int id) {
		CustomeResponse response=new CustomeResponse();

		if(service.addCustomer(bean,id)) {
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

	@PostMapping(path="/partners/partner/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public CustomeResponse addPartner(@RequestBody PartnerInfoBean bean,
			@PathVariable("id") int id) {
		CustomeResponse response=new CustomeResponse();

		if(service.addPartner(bean,id)) {
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

	@PutMapping(path="/customer",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public CustomeResponse editCustmor(@RequestBody CustomerInfoBean bean) {
		CustomeResponse response=new CustomeResponse();

		if(service.editCustomer(bean)) {

			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Edited");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Not Edited");

		}

		return response;
	}



	@GetMapping(path="/partners/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CustomeResponse findCustomer( @PathVariable("id") int id) {
		CustomeResponse response=new CustomeResponse();
		PartnerInfoBean partner=service.getPartnerDetails(id);
		if(partner!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("find");
			response.setCustomer(partner.getCustomer());
			response.setPartner(partner.getPartner());

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription(" not find");

		}

		return response;

	}
	
	@GetMapping(path="/partners",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CustomeResponse getAll() {
		CustomeResponse response=new CustomeResponse();
		List<PartnerInfoBean> partner=service.getAllPartnerDetails();
		if(!partner.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("find");
			response.setPartner(partner);

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription(" not find");

		}

		return response;

	}
	@DeleteMapping(path="/customer/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CustomeResponse deleteEmploye( @PathVariable("id") int id) {
		CustomeResponse response=new CustomeResponse();

		if(service.deleteCustomer(id)) {
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
	@DeleteMapping(path="/partner/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CustomeResponse deletePartnerr( @PathVariable("id") int id) {
		CustomeResponse response=new CustomeResponse();

		if(service.deletePartner(id)) {
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
