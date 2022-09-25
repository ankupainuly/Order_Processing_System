package com.shop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.Customer;


/**
 * Servlet implementation class CustomerOrderManagement
 */
@WebServlet("/CustomerOrderManagement")
public class CustomerOrderManagement extends HttpServlet {
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
//		PrintWriter out=response.getWriter();
		HttpSession session= request.getSession(false);
//		System.out.println("Hello");
		try {
		if(session!=null)
		{
		
			int customerId = (Integer)session.getAttribute("customerId");
			Customer customer= (Customer)session.getAttribute("details");
			System.out.println("customer id"+ customerId);
			RequestDispatcher rd= request.getRequestDispatcher("CustomerOrderManagement.jsp");
//			request.setAttribute("customerId", customerId);
			
			//request.setAttribute("custName",customer.getName());
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errormsg", "Session Expired...Login Again!!");
			rd.forward(request, response);
		}
		}
		catch (Exception e) {
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errormsg", "Session Expired...Login Again!!");
			rd.forward(request, response);
			
		}

	}
}
