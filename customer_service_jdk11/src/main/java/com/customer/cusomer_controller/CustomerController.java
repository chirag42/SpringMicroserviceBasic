package com.customer.cusomer_controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		Customer customer = null;
		try {
			List accounts = null;
			customer = service.selectCustomerByIdService(custId); // FROM THE DB
			accounts = this.restTemplate.getForObject("http://localhost:9002/account/getAccount/" + custId, List.class);
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

		// return null;
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

	@PutMapping("/updateCustomer")
	@ResponseBody
	public String updateCustomer(@RequestBody Customer customer) {
		String message = "Customer Not Found";
		Customer customerUpdateObj = service.selectCustomerByIdService(customer.getCustId());
		if (customerUpdateObj != null) {
			service.updateCustomerService(customer);
			message = "Customer Updated Successfully";
		}

		return message;

	}
	
	@PatchMapping("/patchCustomer/{custId}")
	@ResponseBody
	public String patchCustomer(@PathVariable int custId, @RequestBody Map<Object, Object> patchFields) {
		String message = "Customer Not Found";
		Customer customerUpdateObj = service.selectCustomerByIdService(custId);
		if (customerUpdateObj != null) {
			patchFields.forEach((key ,value) -> {
				Field patchFieldForCustomerObj = ReflectionUtils.findField(Customer.class, (String) key);
				patchFieldForCustomerObj.setAccessible(true);
				ReflectionUtils.setField(patchFieldForCustomerObj, customerUpdateObj, value);
			});
			service.updateCustomerService(customerUpdateObj);
			message = "Customer Updated Successfully";
		}
		
		return message;
	}
	

	@DeleteMapping("/deleteCustomer/{custId}")
	public String deleteCustomer(@PathVariable int custId) {
		String message = "Customer Not Found";
		boolean deleted = false;
		Customer customerUpdateObj = service.selectCustomerByIdService(custId);
		if (customerUpdateObj != null) {
			try {
				this.restTemplate.delete("http://localhost:9002/account/deleteCustomerAccount/" + custId);
				deleted = service.deleteCustomerService(custId);
				if (deleted == true) {

					message = "Customer Deleted Successfully.";
				}
			} catch (Exception e) {
				return "Account Service under Maintainence. Make sure the account service is up in order to delete this Customer. "
						+ "This is an example of Synchronous Communication between two Microservices. We can use Asynchronous communication between microservices "
						+ "so that Account service downtime will not affect the Customer service. Async communication can be implemented using Messaging Queues.";
			}
		}
		return message;
	}

}
