package com.shop.Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.Employee;

/**
 * Servlet implementation class EmployeeOrderManagement
 */
@WebServlet("/EmployeeOrderManagement")
public class EmployeeOrderManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeOrderManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(false);
//		System.out.println("Hello");
		try {
		if(session!=null)
		{
		
			int employeeId = (Integer)session.getAttribute("employeeId");
			Employee employee= (Employee)session.getAttribute("details");
			System.out.println("customer id"+ employeeId);
			RequestDispatcher rd= request.getRequestDispatcher("EmployeeOrderManagement.jsp");
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