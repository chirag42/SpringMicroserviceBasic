package com.customer.cusomer_repository;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.entity.Customer;

@Repository
public class CustomerRepositoryImpl extends BaseRepository implements CustomerRepository {

	@Transactional
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("layer 3 repo method called");
		EntityManager entityManager = getEntityManager();
		entityManager.persist(customer); // based on PK
		return customer;
	}

	@Transactional
	public Customer selectCustomerById(int custId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Customer.class, custId);// based on PK
	}

	@Transactional
	public Customer fetchCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Customer customer = null;

		try {
			customer = entityManager
					.createQuery("SELECT c from Customer c WHERE c.custEmail = :emailId", Customer.class)
					.setParameter("emailId", emailId).getSingleResult();
		} catch (Exception e) {

		}

		return customer;

	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

		EntityManager entityManager = getEntityManager();
		entityManager.merge(customer);

		return customer;

	}

	@Transactional
	public void deleteCustomer(Customer customer) {
		
		EntityManager entityManager = getEntityManager();
		entityManager.remove(customer);
	}

	

}
