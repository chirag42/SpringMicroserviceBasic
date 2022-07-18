package com.customer.customer_service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.entity.Customer;
import com.customer.cusomer_repository.CustomerRepositoryImpl;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepositoryImpl customerRepo;
	
	public Customer selectCustomerByIdService(int custId) {
		
		Customer customer = null;
		
		System.out.println("layer 4 service called");
		
		return customer =customerRepo.selectCustomerById(custId);
	}

	
	public Customer saveCustomerService(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer customer1 = null;
		
		System.out.println("layer 4 service save method called");
		customer1=customerRepo.saveCustomer(customer);
		return customer1;
	}

	
	public Customer fetchCustomerByEmailIdService(String email) {
		// TODO Auto-generated method stub
		Customer customer2 =null;
		System.out.println("layer 4 service fetch by email id  method called");
		
		customer2=customerRepo.fetchCustomerByEmailId(email);
		return customer2;
		
		
	}


	@Transactional
	public Customer updateCustomerService(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.updateCustomer(customer);
	}


	
	
	

}
