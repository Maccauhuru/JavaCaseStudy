package com.perscholas.my_case_study.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.my_case_study.DAO.CustomerDAO;
import com.perscholas.my_case_study.models.Customer;

/**
 * Servlet implementation class Index
 */
@WebServlet(urlPatterns = {"/","/Index"})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        try {
            switch (action) {
            case "/newCustomerForm":
            	showRegisterForm(request,response);
            	break;
            case "/registerCustomer":
                registerCustomer(request, response);
                break;
            case "/login":
                loginCustomer(request, response);
                break;
            case "/storefront":
            	showStoreFront(request,response);
            	break;
            case "/logout":
            	logout(request,response);
            	break;
            default:
        		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
        		rd.forward(request, response);
        		break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
	}
	
	private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
		rd.forward(request, response);
	}
	
    private void registerCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Customer newCustomer = new Customer(name, email, password);
        CustomerDAO c_dao = new CustomerDAO();
        int returnId = c_dao.registerCustomer(newCustomer);
        System.out.println(returnId);
        response.sendRedirect("main");
    }
    
    private void loginCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer c = new Customer();
		c.setEmail(email);
		CustomerDAO dao = new CustomerDAO();
		Customer d = dao.loginCustomer(c.getEmail());

		if (d.getPassword().equals(password)) {
			session.setAttribute("currentUser", d);
			message = "You are logged in!";
			request.setAttribute("currentUser", session.getAttribute("currentUser"));
			response.sendRedirect("storefront");
		} else {
			message = "Invalid login.";
			session.setAttribute("currentUser", null);
			request.setAttribute("validation", message);
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		}
    }
    
    private void showStoreFront(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("currentUser") != null) {
	    	RequestDispatcher rd = request.getRequestDispatcher("StoreFront.jsp");
			rd.forward(request, response);
		} else {
	    	response.sendRedirect("main");
		}
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect("main");
    }

}