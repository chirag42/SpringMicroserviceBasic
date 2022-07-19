package com.account.account_repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.account.entity.Account;

@Repository
public interface AccountRepository {

	public List<Account> selectAccountByCustomerId(int custId);

	public Account saveAccount(Account account);

	public void deleteAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public Account getAccountById(long accountNumber);

}
