package com.dollarsbank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dollarsbank.connections.ConnectionFactory;
import com.dollarsbank.model.Transaction;

public class TransactionsDAOImpl implements TransactionsDAO<Transaction> {

	@Override
	public Transaction get(int id) {
		Transaction t = new Transaction();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM transaction where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t.setId(rs.getInt("id"));
				t.setUserId(rs.getInt("customerTransactionId"));
				t.setAccountId(rs.getInt("AccountTransactionId"));
				t.setAmount(rs.getFloat("amount"));
				t.setInitialBalance(rs.getFloat("initialBalance"));
				t.setRemainingBalance(rs.getFloat("remainingBalance"));
				t.setTimestamp(rs.getTimestamp("dateCreated"));				
			}
			return t;
			
		} catch(SQLException e) {
			System.out.println("issue with getting transaction");
			e.printStackTrace();
		}
		return t;
	}
	
	@Override
	public ArrayList<Transaction> getAll() {
		ArrayList<Transaction> transactions = new ArrayList<>();
		try {
			//
			ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("select * from transaction order by id DESC;");
			while(rs.next()) {
				Transaction t = new Transaction();
				t.setId(rs.getInt("id"));
				t.setUserId(rs.getInt("userTransactionId"));
				t.setAccountId(rs.getInt("accountTransactionId"));
				t.setAmount(rs.getFloat("amount"));
				t.setInitialBalance(rs.getFloat("initialBalance"));
				t.setRemainingBalance(rs.getFloat(6));
				t.setTimestamp(rs.getTimestamp(7));
				transactions.add(t);
			}
		return transactions;
		} catch(SQLException e) {
			System.out.println("issue with getting all transactions");
			e.printStackTrace();
		}
		return transactions;
	}
	
	@Override
	public ArrayList<Transaction> getAll(int userId) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from transaction where userTransactionId=? ORDER BY id DESC LIMIT 5");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Transaction t = new Transaction();
				t.setId(rs.getInt(1));
				t.setUserId(rs.getInt(2));
				t.setAccountId(rs.getInt(3));
				t.setAmount(rs.getFloat(4));
				t.setInitialBalance(rs.getFloat(5));
				t.setRemainingBalance(rs.getFloat(6));
				t.setTimestamp(rs.getTimestamp(7));
				transactions.add(t);
			}
			return transactions;
		} catch(SQLException e) {
			System.out.println("issue with getting all transactions by userId.");
			e.printStackTrace();
		}
		return transactions;
	}

	
	// how to insert Enum into preparedStatement
	//TODO handle logic of setting type of transaction by enum
	//TODO test if I am able to generate enum in constructor as i pass in a amount value
	@Override
	public void create(Transaction t) {
		try {
		PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("insert into transaction (userTransactionId, accountTransactionId, amount, initialBalance, remainingBalance) values (?,?,?,?,?)");
		ps.setInt(1,t.getUserId());
		ps.setInt(2,t.getAccountId());
		ps.setFloat(3,t.getAmount());
		ps.setFloat(4,t.getInitialBalance());
		ps.setFloat(5,t.getRemainingBalance());
		ps.execute();
		//
		} catch(SQLException e) {
			System.out.println("issue with creating transaction");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Transaction t) {

		try {
			PreparedStatement ps = ConnectionFactory.getConnection()
			.prepareStatement("update transaction set userTransitionId=?, accountTransactionId=?, amount=?, initialBalance=?, remainingBalance=?, type=? where id=?");
			ps.setInt(1,t.getUserId());
			ps.setInt(2,t.getAccountId());
			ps.setFloat(3,t.getAmount());
			ps.setFloat(4,t.getInitialBalance());
			ps.setFloat(5,t.getRemainingBalance());
			ps.execute();
			//
			} catch(SQLException e) {
				System.out.println("issue with updating transaction");
				e.printStackTrace();
			}



		
	}
}
