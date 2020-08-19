package com.dollarsbank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dollarsbank.connections.ConnectionFactory;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.SavingsAccount;

//Maybe Change to SavingsAccountImpl unless find a better solution to boilerplate code.
//Create and add enum for account type='SAVINGS
//DAO CRUD Implemenation class
public class AccountDAOImpl implements AccountDAO<Account> {
		
	@Override
	public Account get(int userId) {
		SavingsAccount sa = new SavingsAccount();
		try {
																
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM accounts Where userId=? and visible=1");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sa.setId(rs.getInt("id"));
				sa.setUserId(rs.getInt("userid"));
				sa.setBalance(rs.getFloat("balance"));
				sa.setDateCreated(rs.getTimestamp("dateCreated"));
			}
			return sa;
		} catch(SQLException e) {
			System.out.println("Issue with retrieving data database");
			e.printStackTrace();
		}
		return sa;
	} 
	
	@Override
	public ArrayList<Account> getAll() {
		
		ArrayList<Account> accounts = new ArrayList<>();
		try {
			ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM accounts WHERE visible=1");
			while(rs.next()) {
				SavingsAccount sa = new SavingsAccount();
				sa.setId(rs.getInt("id"));
				sa.setUserId(rs.getInt("userId"));
				sa.setBalance(rs.getFloat("balance"));
				sa.setDateCreated(rs.getTimestamp("dateCreated"));			
				accounts.add(sa);
			}	
			return accounts;
		} catch(SQLException e) {
			System.out.println("Issue with getting (sa) in implementation");
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	

	@Override
	public ArrayList<Account> getAll(int userId) {
		ArrayList<Account> accounts = new ArrayList<>();
		try {
			ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM accounts WHERE visible=1 and userId=?");
			while(rs.next()) {
				SavingsAccount sa = new SavingsAccount();
				sa.setId(rs.getInt("id"));
				sa.setUserId(rs.getInt("userId"));
				sa.setBalance(rs.getFloat("balance"));
				sa.setDateCreated(rs.getTimestamp("dateCreated"));			
				accounts.add(sa);
			}	
			return accounts;
		} catch(SQLException e) {
			System.out.println("Issue with getting (sa) in implementation");
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public void create(Account a) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("INSERT INTO accounts (userId, balance, type) VALUES (?,?,?)");
			ps.setInt(1, a.getUserId());
			ps.setFloat(2, a.getBalance());
			ps.setObject(3, Account.AccountType.SAVINGS.toString());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("issue with creating account in SA implmenantation");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Account a) {
		
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE accounts SET userId=?, balance=?, type=? WHERE id=?");
			ps.setInt(1, a.getUserId());
			ps.setFloat(2, a.getBalance());
			ps.setObject(3, Account.AccountType.SAVINGS.toString());
			ps.setInt(4, a.getId());
			ps.execute();
		}
		catch (SQLException e) {
			System.out.println("issue with updating account in implmenantation");
			e.printStackTrace();
		}
	}





}
