  
package com.customer.cusomer_repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		System.out.println("BaseRepository: getting entityManager");
		return entityManager;
	}
	
}
