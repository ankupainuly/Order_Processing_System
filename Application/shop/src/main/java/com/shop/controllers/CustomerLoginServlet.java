package com.shop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.CustomerDaoImpl;
import com.shop.model.Customer;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		int customerid=Integer.parseInt(request.getParameter("customerid"));
		
		
		String password= request.getParameter("password");
		Customer customer= new Customer();
		customer.setCustomerid(customerid);
		customer.setPassword(password);
		CustomerDaoImpl customerlogin= new CustomerDaoImpl();
		if(customerlogin.customerLoginValidate(customer))
		{
			HttpSession session = request.getSession();
			session.setAttribute("customerId", customerid);
			session.setAttribute("details",customerlogin.getCustomer(customerid));
			response.sendRedirect("CustomerOrderManagement");
			
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("CustomerLogin.jsp");
			request.setAttribute("errormsg", " Incorrect Customer Id or Password!!");
			rd.forward(request, response);
		}
		}
		catch (NumberFormatException e) {
			RequestDispatcher rd= request.getRequestDispatcher("CustomerLogin.jsp");
			request.setAttribute("errormsg", "Please enter Customer Id and Password!");
			rd.forward(request, response);
		}
	}

}
