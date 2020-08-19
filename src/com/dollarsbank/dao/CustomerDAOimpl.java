package com.dollarsbank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dollarsbank.connections.ConnectionFactory;
import com.dollarsbank.model.Customer;

public class CustomerDAOimpl implements CustomerDAO<Customer> {

    @Override
    public Customer get(int id) {
        Customer c = null; 
        try{
        	c = new Customer();
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM customer WHERE id=? and visible=1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setUserName(rs.getString(4));
                c.setPassword(rs.getString(5));
                c.setAddress(rs.getString(6));
                c.setContactNumber(rs.getString(7));
                c.setDate(rs.getDate(8));
            }
            return c;
         } catch(SQLException e) {
             System.out.println("issue with getting customer by id");
             e.printStackTrace();
         }
        return c;
    }

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("select * from customer where visible=1");
            while(rs.next()){
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setUserName(rs.getString(4));
                c.setPassword(rs.getString(5));
                c.setAddress(rs.getString(6));
                c.setContactNumber(rs.getString(7));
                c.setDate(rs.getTimestamp(8));
                customers.add(c);
            }
            return customers;
        } catch(SQLException e) {
            System.out.println("issue with getting all the customers");
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void create(Customer c) {
        try{
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("INSERT INTO customer (firstname, lastname, username, password, address, mobile) VALUES (?,?,?,?,?,?)");
        ps.setString(1, c.getFirstName());
        ps.setString(2, c.getLastName());
        ps.setString(3, c.getUserName());
        ps.setString(4, c.getPassword());
        ps.setString(5, c.getAddress());
        ps.setString(6, c.getContactNumber());
        ps.execute();
        } catch(SQLException e) {
            System.out.println("issue occured with creating a customer");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer c) {
       try {
        PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE customer SET firstname=?, lastname=?, username=?, password=?, address=?, mobile=? WHERE id=?");
        ps.setString(1, c.getFirstName());
        ps.setString(2, c.getLastName());
        ps.setString(3, c.getUserName());
        ps.setString(4, c.getPassword());
        ps.setString(5, c.getAddress());
        ps.setString(6, c.getContactNumber());
        ps.setInt(7, c.getId());
        ps.execute(); 
    } 
    catch(SQLException e) {
        System.out.println("issue occcured with updating a customer");
        e.printStackTrace();
        }
    }

    @Override
    public Customer get(String username) {
        Customer c = null;
		try {
			c = new Customer();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from customer where username=? AND visible=true");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				c.setContactNumber(rs.getString("mobile"));
				c.setDate(rs.getTimestamp("dateCreated"));
			}
			return c;
		} catch(SQLException e) {
			System.out.println("issue with get operation in CustomerCRUD");
			e.printStackTrace();
		}
		return c;
    }

    @Override
    public Customer get(char[] mobile) {
        Customer c = new Customer();
		try {
			c = new Customer();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from customer where username=? AND visible=true");
			ps.setString(1, mobile.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				c.setContactNumber(rs.getString("mobile"));
				c.setDate(rs.getTimestamp("dateCreated"));
			}
			return c;
		} catch(SQLException e) {
			System.out.println("issue with get operation in CustomerCRUD");
			e.printStackTrace();
		}
		return c;
    }

}
