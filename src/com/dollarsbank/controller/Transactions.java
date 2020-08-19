package com.dollarsbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollarsbank.dao.AccountDAO;
import com.dollarsbank.dao.AccountDAOImpl;
import com.dollarsbank.dao.TransactionsDAO;
import com.dollarsbank.dao.TransactionsDAOImpl;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.Transaction;

/**
 * Servlet implementation class Transactions
 */
@WebServlet("/transactions")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transactions() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String send = new String("savings.jsp"); 
		Customer c = (Customer)request.getSession().getAttribute("customer");
		Transaction t; 
		TransactionsDAO<Transaction> transDAO;
		Account a;
		AccountDAO<Account> acctDAO;
		if(request.getParameter("saveTrans")!=null) {
			t = new Transaction();
			transDAO = new TransactionsDAOImpl();
			acctDAO = new AccountDAOImpl();
			a = acctDAO.get(c.getId());
			float temp = Float.valueOf(request.getParameter("saveTrans")),
					start = a.getBalance(),
					total = start-temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(-temp);
			t.setInitialBalance(start);
			t.setRemainingBalance(total);
			a.setBalance(total);
			acctDAO.update(a);
			transDAO.create(t);
		}
		
		//TODO Checking account Transaction and implementation


		//for savings account
		if(request.getParameter("saveWithdraw")!=null) {
			t = new Transaction();
			transDAO = new TransactionsDAOImpl();
			acctDAO = new AccountDAOImpl();
			a = acctDAO.get(c.getId());
			float temp = Float.valueOf(request.getParameter("saveWithdraw")), start = a.getBalance(), total = start-temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(-temp);
			t.setInitialBalance(start);
			t.setRemainingBalance(total);
			a.setBalance(total);
			acctDAO.update(a);
			transDAO.create(t);
			send = new String("savings.jsp"); 
		}

		if(request.getParameter("saveDeposit")!=null) {
			t = new Transaction();
			transDAO = new TransactionsDAOImpl();
			acctDAO = new AccountDAOImpl();
			a = acctDAO.get(c.getId());
			float temp = Float.valueOf(request.getParameter("saveDeposit")), start = a.getBalance(), total = start+temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(temp);
			t.setInitialBalance(start);
			t.setRemainingBalance(total);
			a.setBalance(total);
			acctDAO.update(a);
			transDAO.create(t);
			send = new String("savings.jsp");


				
		}
		response.sendRedirect(send);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
