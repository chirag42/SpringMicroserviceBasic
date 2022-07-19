package com.account.account_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.account.entity.Account;
import com.account.account_repository.AccountRepositoryImpl;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepositoryImpl accountRepo;

	public List<Account> selectAccountByCustomerIdService(int custId) {

		List<Account> account = new ArrayList<Account>();

		System.out.println("layer 4 service called");

		account = accountRepo.selectAccountByCustomerId(custId);
		return account;

	}

	public Account saveAccountService(Account account) {
		// TODO Auto-generated method stub

		Account accountObj = null;

		System.out.println("layer 4 service save method called");
		accountObj = accountRepo.saveAccount(account);
		return accountObj;
	}

	public boolean deleteAccountByCustomerIdService(List<Account> accounts) {
		boolean deleted = false;

		for (Account account : accounts) {
			accountRepo.deleteAccount(account);
			deleted = true;
		}

		return deleted;
	}

	public Account getAccountByIdService(long accountNo) {
		return accountRepo.getAccountById(accountNo);
	}

	public Account updateAccountService(Account account) {
		// TODO Auto-generated method stub
		return accountRepo.updateAccount(account);
	}

}
