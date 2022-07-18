package com.account.account_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.account_service.AccountServiceImpl;
import com.account.entity.Account;


@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl service;

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAccount/{custId}")
	public List<Account> getAccount(@PathVariable int custId) {
		System.out.println("getAccount()...method ");

		try {
			return service.selectAccountByCustomerIdService(custId); // FROM THE DB
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/createAccount")
	public String registerCustomer(@RequestBody Account account) {

		System.out.println("inside Register Account");
		Long accountNumber = account.getAccountNumber();
		System.out.println(accountNumber);

		service.saveAccountService(account);
		System.out.println("saved from controller ");
		return "Account creation successfull";

	}

	

	
}
