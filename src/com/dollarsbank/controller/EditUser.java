package com.dollarsbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollarsbank.dao.CustomerDAO;
import com.dollarsbank.dao.CustomerDAOimpl;
import com.dollarsbank.model.Customer;

/**
 * Servlet implementation class EditUser
 */
@WebServlet(description = "routing to view and update user information", urlPatterns = { "/edit" })
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pass = new String(request.getParameter("password"));
		Customer c = (Customer)request.getSession().getAttribute("customer");
		if (pass.contains("*")) 
			pass = c.getPassword();
		CustomerDAO<Customer> customerDAOImpl = new CustomerDAOimpl();
		c.setFirstName(request.getParameter("firstName"));
		c.setLastName(request.getParameter("lastName"));
		c.setPassword(request.getParameter("password"));
		c.setAddress(request.getParameter("address"));
		c.setContactNumber(request.getParameter("mobile"));
		customerDAOImpl.update(c);
		
		response.sendRedirect("account.jsp");




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
