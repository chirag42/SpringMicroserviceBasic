package com.account.account_repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.account.entity.Account;

@Repository
public class AccountRepositoryImpl extends BaseRepository implements AccountRepository {

	@Transactional
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		System.out.println("layer 3 repo method called");
		EntityManager entityManager = getEntityManager();
		entityManager.persist(account); // based on PK
		return account;
	}

	@Transactional
	public List<Account> selectAccountByCustomerId(int custId) {
		EntityManager entityManager = getEntityManager();
		List<Account> accounts = new ArrayList<>();
		try {
			accounts = entityManager
					.createQuery("SELECT a from Account a WHERE a.custId = :custId", Account.class)
					.setParameter("custId", custId).getResultList();
		} catch (Exception e) {

		}

		return accounts;// based on PK
	}


	

}
