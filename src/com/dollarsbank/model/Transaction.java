package com.dollarsbank.model;

import static com.dollarsbank.model.TransactionType.*;

import java.util.Date;

public class Transaction {

	private int id, userId, accountId;
	private float amount, initialBalance, remainingBalance;
	private TransactionType type;
	private Date timestamp;

	public Transaction() {};
	public Transaction(int id, int userId, int accountId, float amount, float initialBalance, float remainingBalance,
			TransactionType type, Date timestamp) {
		this.id = id;
		this.userId = userId;
		this.accountId = accountId;
		this.amount = amount;
		this.initialBalance = initialBalance;
		this.remainingBalance = remainingBalance;
		this.timestamp = timestamp;


		//TODO: Try to convert to string and
		if (amount < 0) {
			this.type = WITHDRAW;
		}
		else if (amount > 0) {
			this.type = DEPOSIT;
		}
		else {
			this.type = UNSPECIFIED;
		}

	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType t) {
		this.type = t;
	}

	/*
	 * public void setType() { Transaction.type = WITHDRAW; }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(float initialBalance) {
		this.initialBalance = initialBalance;
	}

	public float getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(float remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


}