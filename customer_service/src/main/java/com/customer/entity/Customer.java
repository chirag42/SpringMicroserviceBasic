package com.customer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="customer_microservice")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID")
	private int custId;

	@Column(name="CUST_CONTACTNUMBER")
	private String custContactnumber;

	@Column(name="CUST_EMAIL")
	private String custEmail;

	@Column(name="CUST_FIRSTNAME")
	private String custFirstname;

	@Column(name="CUST_LASTNAME")
	private String custLastname;

	@Transient
	private List<BankAccount> bankAccounts;


	public Customer() {
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustContactnumber() {
		return this.custContactnumber;
	}

	public void setCustContactnumber(String custContactnumber) {
		this.custContactnumber = custContactnumber;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustFirstname() {
		return this.custFirstname;
	}

	public void setCustFirstname(String custFirstname) {
		this.custFirstname = custFirstname;
	}

	public String getCustLastname() {
		return this.custLastname;
	}

	public void setCustLastname(String custLastname) {
		this.custLastname = custLastname;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}



}