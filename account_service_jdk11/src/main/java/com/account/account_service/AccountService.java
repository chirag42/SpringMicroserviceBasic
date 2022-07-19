package com.account.account_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.account.entity.Account;



@Service
public interface AccountService {
	
	public List<Account> selectAccountByCustomerIdService(int custId);
	
	public Account saveAccountService(Account customer);
	
	public boolean deleteAccountByCustomerIdService(List<Account> accounts);
	
	public Account getAccountByIdService(long accountNo);
	
	public Account updateAccountService(Account account);
	
	
}
