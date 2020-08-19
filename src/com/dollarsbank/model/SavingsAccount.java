package com.dollarsbank.model;

import java.util.Date;

public class SavingsAccount implements Account {
	
	private int accountId, userId;
	private Date dateCreated;
	private AccountType type;
	//add account type //description
	private float accountBalance;
	
	public SavingsAccount(float balance, int userId, int acctId,  AccountType type, Date dateCreated) 
	{		
		this.userId = userId;
		this.accountId = acctId;
		this.type = type;
		this.accountBalance = balance;
		this.dateCreated = dateCreated;
	}

	public SavingsAccount() {}

	@Override
	public int getId() {
		return accountId;
	}

	@Override
	public void setId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public float getBalance() {
		return accountBalance;
	}
	public void setBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public int getUserId() {
		return userId;
	}
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public Date getDateCreated() {
		return dateCreated;
	}
	@Override
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public void setType(AccountType type) {
		this.type = AccountType.SAVINGS;
	}

	@Override
	public AccountType getType() {
		return type;
	}
}
