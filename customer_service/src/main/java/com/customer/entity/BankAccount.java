package com.customer.entity;

public class BankAccount {
	
	private long AccountNo;
	private String AccountType;
	private long IFSC_Code;
	private boolean DebitCardIssued;
	private boolean CreditCardIssued;
	private int CustomerID;
	
	
	
	public BankAccount(long accountNo, String accountType, long iFSC_Code, boolean debitCardIssued,
			boolean creditCardIssued, int customerID) {
		super();
		AccountNo = accountNo;
		AccountType = accountType;
		IFSC_Code = iFSC_Code;
		DebitCardIssued = debitCardIssued;
		CreditCardIssued = creditCardIssued;
		CustomerID = customerID;
	}
	
	public BankAccount() {
			
	}
	
	public long getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(long accountNo) {
		AccountNo = accountNo;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public long getIFSC_Code() {
		return IFSC_Code;
	}
	public void setIFSC_Code(long iFSC_Code) {
		IFSC_Code = iFSC_Code;
	}
	public boolean isDebitCardIssued() {
		return DebitCardIssued;
	}
	public void setDebitCardIssued(boolean debitCardIssued) {
		DebitCardIssued = debitCardIssued;
	}
	public boolean isCreditCardIssued() {
		return CreditCardIssued;
	}
	public void setCreditCardIssued(boolean creditCardIssued) {
		CreditCardIssued = creditCardIssued;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	
	

}
