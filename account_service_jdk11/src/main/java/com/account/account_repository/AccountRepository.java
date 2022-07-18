package com.account.account_repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.account.entity.Account;

@Repository
public interface AccountRepository {

	public List<Account> selectAccountByCustomerId(int custId);

	public Account saveAccount(Account account);

	

	

}
