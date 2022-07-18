package com.customer.cusomer_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.customer.customer_service.CustomerServiceImpl;
import com.customer.entity.BankAccount;
import com.customer.entity.Customer;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl service;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getCust/{custId}")
	public Customer getCustomer(@PathVariable int custId) {
		System.out.println("getEmployee()...method ");
		Customer customer=null;
		try {
			List accounts = null;
			customer = service.selectCustomerByIdService(custId); // FROM THE DB
			accounts = this.restTemplate.getForObject("http://localhost:9002/account/getAccount/"+custId, List.class);
			customer.setBankAccounts(accounts);
			return customer;
		}
//		catch(ResourceAccessException e) {
//			System.out.println("Account Service under Maintainence");
//			return customer;
//		}
		catch (Exception e) {
			System.out.println("Account Service under Maintainence");
			return customer;
			
		}
		
		//return null;
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/register")
	public String registerCustomer(@RequestBody Customer customer) {

		System.out.println("inside Register Cutomer");
		String tempEmailId = customer.getCustEmail();
		System.out.println(tempEmailId);

		if (tempEmailId != null && !"".equals(tempEmailId)) {
			Customer customerObj = service.fetchCustomerByEmailIdService(tempEmailId);
			/* System.out.println(customerObj.getCustEmail()); */

			if (customerObj != null) {

				return "this email already exist please enter again";

			}

		}

		service.saveCustomerService(customer);
		System.out.println("saved from controller ");
		return "Registeration successfull";

	}

	@GetMapping("/fetchEmail/{email}")
	@ResponseBody
	public Customer fetchByEmail(@PathVariable String email) {

		/* String tempEmailId = customer.getCustEmail(); */
		Customer customerObj = service.fetchCustomerByEmailIdService(email);

		return customerObj;

	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {

		return service.updateCustomerService(customer);

	}

	

	
}
