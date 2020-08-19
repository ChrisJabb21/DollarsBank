package com.dollarsbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollarsbank.dao.AccountDAO;
import com.dollarsbank.dao.AccountDAOImpl;
import com.dollarsbank.dao.CustomerDAO;
import com.dollarsbank.dao.CustomerDAOimpl;
import com.dollarsbank.dao.Operations;
import com.dollarsbank.dao.TransactionsDAOImpl;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.Transaction;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String send = new String("login.jsp");

		//implementation helper classes for persisting the data 
		CustomerDAO<Customer> userDAOImpl = new CustomerDAOimpl();
		AccountDAO<Account> acctDAOImpl = new AccountDAOImpl();
		Operations<Transaction> transDAOImpl = new TransactionsDAOImpl();

		//Check for if customer username and mobile contact number is valid.
		//get method to search input
		if(userDAOImpl.get(request.getParameter("username"))==null & userDAOImpl.get(request.getParameter("mobile"))==null){
			request.getSession().invalidate();
			request.getSession(true);
			request.getSession().setAttribute("accountExists", true);
			send = new String("signup.jsp");
		} else {
			//Set customer/user fields with request param input and 
			//use helper class to create and add customer
			Customer c = new Customer();
			c.setFirstName(request.getParameter("firstName"));
			c.setLastName(request.getParameter("lastName"));
			c.setUserName(request.getParameter("username"));
			c.setPassword(request.getParameter("pass1"));
			c.setAddress(request.getParameter("address"));
			c.setContactNumber(request.getParameter("mobile"));
			userDAOImpl.create(c); 


			//create saving account using customer credentials
			c = userDAOImpl.get(request.getParameter("username"));
			Account a = new SavingsAccount();
			a.setUserId(c.getId());
			a.setBalance(Float.valueOf(request.getParameter("balance")));
			acctDAOImpl.create(a);
			a = acctDAOImpl.get(c.getId());
			
			
			//TODO add checkingAccount implementation to create and link a checking account for the same user

			
			//Set transaction and add it to db with implemenation helper class.
			Transaction t = new Transaction();
			t.setUserId(c.getId());
			t.setAccountId(a.getId());
			t.setInitialBalance(0.0f);
			t.setAmount(a.getBalance()); //Investigate and test
			t.setRemainingBalance(a.getBalance());
			transDAOImpl.create(t); 


		}
		response.sendRedirect(send);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
