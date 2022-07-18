package com.customer.cusomer_repository;

import org.springframework.stereotype.Repository;


import com.customer.entity.Customer;

@Repository
public interface CustomerRepository {

	public Customer selectCustomerById(int custId);

	public Customer saveCustomer(Customer customer);

	public Customer fetchCustomerByEmailId(String email);

	public Customer updateCustomer(Customer customer);

	

}
