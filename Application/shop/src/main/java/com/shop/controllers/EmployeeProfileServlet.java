package com.shop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/EmployeeProfileServlet")
public class EmployeeProfileServlet extends HttpServlet {
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
		PrintWriter out=response.getWriter();
		HttpSession session= request.getSession(false);
	try {
		if(session!=null)
		{
			RequestDispatcher rd= request.getRequestDispatcher("EmployeeProfile.jsp");
			request.setAttribute("profileid", (int)session.getAttribute("empid"));
			request.setAttribute("welcomemsg","Welcome to your Profile!!!!");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errormsg", "Session Expired...Login Again!!");
			rd.forward(request, response);
		}
	    }
		catch (NullPointerException e) {
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errormsg", "Session Expired...Login Again!!");
			rd.forward(request, response);
			
		}
		
	}

}
