package com.dollarsbank.model;
import java.util.Date;

/*Common super class for Account and if we decide to have other types of accounts.*/
public interface Account {	
	//make inheritable common attributes all types of accounts would have.

	public enum AccountType {CHECKINGS,SAVINGS,OTHER, UNSPECIFIED}
	public int getId();
	public void setId(int id);
	public int getUserId();
	public void setUserId(int userId);
	public float getBalance();
	public void setBalance(float balance);
	public Date getDateCreated();
	public void setDateCreated(Date timestamp);
	public AccountType getType();
	public void setType(AccountType type);
}

