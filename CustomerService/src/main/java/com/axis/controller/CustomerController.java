package com.axis.controller;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Customer;
import com.axis.service.CustomerService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer customer2 = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK );
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable int customer_id){
		Customer customers = customerService.getCustomerById(customer_id);
		return new ResponseEntity<Customer>(customers, HttpStatus.OK);
	}
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int customer_id,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer_id, customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customer_id){
		return new ResponseEntity<String>(customerService.deleteCustomer(customer_id),HttpStatus.OK);
	}


}
