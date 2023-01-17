package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IDNotFoundException;
import com.axis.model.Customer;
import com.axis.repository.CustomerRepository;
import com.axis.utils.AppConstants;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*
	 * @Description: This method is used  to add a customer
	 * @Param: It takes product parameter
	 * @Returns:It returns customers
	 * @Author:Aditi
	 * @Created Date: 19 Dec 2022
	 * 
	 */
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	
	@Override
	public Customer getCustomerById(int customer_id) {
		return customerRepository.findById(customer_id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
	}

	
	@Override
	public Customer updateCustomer(int customer_id, Customer customer) {
		Customer cust=customerRepository.findById(customer_id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		cust.setFull_name(customer.getFull_name());
		cust.setMail_id(customer.getMail_id());
		cust.setMobile_no(customer.getMobile_no());
		cust.setOrder(customer.getOrder());
		
		
		return customerRepository.save(cust);
	}

	
	@Override
	public String deleteCustomer(int customer_id) {
		Customer cust=customerRepository.findById(customer_id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		customerRepository.delete(cust);
		return AppConstants.CUSTOMER_DELETE_MESSAGE;
	}
	
	

}
