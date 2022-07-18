package com.customer.customer_service;

import org.springframework.stereotype.Service;

import com.customer.entity.Customer;



@Service
public interface CustomerService {
	
	public Customer selectCustomerByIdService(int custId);
	
	public Customer saveCustomerService(Customer customer);
	
	public Customer fetchCustomerByEmailIdService(String email);
	
	public Customer updateCustomerService(Customer customer);
	
	

}
