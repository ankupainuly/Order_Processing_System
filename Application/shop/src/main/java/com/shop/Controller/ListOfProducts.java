package com.shop.Controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.JDBC.DBConnection;
import com.shop.dao.QuoteDao;
import com.shop.model.Cart;
import com.shop.model.Customer;
import com.shop.model.Employee;
import com.shop.model.Products;

/**
 * Servlet implementation class ListOfProducts
 */
@WebServlet("/ListOfProducts")
public class ListOfProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListOfProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int customerid = Integer.parseInt(request.getParameter("customerid"));
		System.out.println(customerid);
		out.print("Product details page");
		QuoteDao quotedao= new QuoteDao();
		List <Products> productData = quotedao.GetAllProducts();
		
		
		request.setAttribute("productData", productData);
		request.setAttribute("customerid", customerid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListOfProducts.jsp");

		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
//			else
//			{
//				RequestDispatcher rd= request.getRequestDispatcher("CustomerVerification");
//				request.setAttribute("errormsg", " Please enter the CustomerID correctly!!");
//				rd.forward(request, response);
//			}
	}

}
