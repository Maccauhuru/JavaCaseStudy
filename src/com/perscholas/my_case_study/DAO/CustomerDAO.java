package com.perscholas.my_case_study.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.my_case_study.DAO.MySqlConnection;
import com.perscholas.my_case_study.models.Customer;

public class CustomerDAO {
	
	//*************Register Customer***********************************
		public int registerCustomer(Customer c) throws SQLException {
			
			Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;
		    
		    String SAVE = "INSERT INTO CUSTOMER "
		            + "(name, email, password) "
		            + "VALUES(?, ?, ?)";
		    
		    int ID = -1;
		    String[] COL = {"customer_id"};
		    
		    MySqlConnection mysql = new MySqlConnection();
		    try
		    {
		        conn = mysql.getConnection();
		        stmt = conn.prepareStatement(SAVE, COL);
		        stmt.setString(1, c.getName());
		        stmt.setString(2, c.getEmail());
		        stmt.setString(3, c.getPassword());
		        
		        stmt.executeUpdate();
		        result = stmt.getGeneratedKeys();
		        if(result != null && result.next()) {
		            ID = result.getInt(1);
		        }
		        System.out.println(ID);
		    }
		    catch (ClassNotFoundException | IOException | SQLException e)
		    {
		        e.printStackTrace();
		    }
		    finally {
		    	if (result != null) {
		    		result.close();
		    	}
		    	if (stmt != null) {
		    		stmt.close();
		    	}
		    	if (conn != null) {
		    		conn.close();
		    	}
		    }        
		    
		    
		    return ID; 
		}

	//*************Login Customer***********************************
		public Customer loginCustomer(String email) {
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;
		    Customer currentCustomer = new Customer();
		    
		    String SAVE = "SELECT * FROM CUSTOMER WHERE email = ?";
		    MySqlConnection mysql = new MySqlConnection();
		    
		    try
		    {
		        conn = mysql.getConnection();
		        stmt = conn.prepareStatement(SAVE);
		        stmt.setString(1, email);
		        
		        result = stmt.executeQuery();
		        if (result.next()) {
		        	currentCustomer.setCustomer_id(result.getInt(1));
		        	currentCustomer.setName(result.getString(2));
		        	currentCustomer.setEmail(result.getString(3));
		        	currentCustomer.setPassword(result.getString(4));
		        }
		    }
		    catch (ClassNotFoundException | IOException | SQLException e)
		    {
		        e.printStackTrace();
		    }
		    return currentCustomer;
		}
		
	//*************Get All Customers***********************************
		public List<Customer> getAllCustomers() throws SQLException {
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;
		    Customer thisCustomer = null;
		    List<Customer> allCustomers = null;
		    
		    String SAVE = "SELECT * FROM CUSTOMER";
		    MySqlConnection mysql = new MySqlConnection();
			
		    allCustomers = new ArrayList<Customer>();
		    
		    try
		    {
		        conn = mysql.getConnection();
		        stmt = conn.prepareStatement(SAVE);
		        
		        result = stmt.executeQuery();
		        
		        while (result.next()) {
		        	thisCustomer = new Customer();
		        	thisCustomer.setCustomer_id(result.getInt(1));
		        	thisCustomer.setName(result.getString(2));
		        	thisCustomer.setEmail(result.getString(3));
		        	thisCustomer.setPassword((result.getString(4)));
		        	allCustomers.add(thisCustomer);
		        }
		    }
		    catch (ClassNotFoundException | IOException | SQLException e)
		    {
		        e.printStackTrace();
		    }
	        finally {
	        	if (result != null) {
	        		result.close();
	        	}
	        	if (stmt != null) {
	        		stmt.close();
	        	}
	        	if (conn != null) {
	        		conn.close();
	        	}
	        }
		    
			return allCustomers;
		}
		
		  public static void main(String[] args) throws SQLException {
//			  Customer c = new Customer();
//			  c.setName("Joan");
//			  c.setEmail("joan@doe.com");
//			  c.setPassword("joan1234");
//			  CustomerDAO dao = new CustomerDAO();
//			  dao.registerCustomer(c);
			  
//			  Customer c = new Customer();
//			  c.setEmail("john@doe.com");
//			  CustomerDAO dao = new CustomerDAO();
//			  Customer d = dao.loginCustomer(c.getEmail());
//			  System.out.println(d.getPassword());

//			  List<Customer> allCustomers = null;
//			  CustomerDAO dao = new CustomerDAO();
//			  allCustomers = dao.getAllCustomers();
	//
//			  for (Customer customer: allCustomers) {
//				  System.out.println(customer.toString() + "\n");
//			  }
		}

}
