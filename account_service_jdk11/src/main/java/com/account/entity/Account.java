package com.account.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name = "account_microservice")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_NUMBER")
	private long accountNumber;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_IFSC_CODE")
	private String ifscCode;

	@Column(name = "DEBIT_ISSUED")
	private boolean debitIssued;

	@Column(name = "CREDIT_ISSUED")
	private boolean creditIssued;

	@Column(name = "CUSTOMER_ID")
	private int custId;

	public Account() {
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public boolean isDebitIssued() {
		return debitIssued;
	}

	public void setDebitIssued(boolean debitIssued) {
		this.debitIssued = debitIssued;
	}

	public boolean isCreditIssued() {
		return creditIssued;
	}

	public void setCreditIssued(boolean creditIssued) {
		this.creditIssued = creditIssued;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}