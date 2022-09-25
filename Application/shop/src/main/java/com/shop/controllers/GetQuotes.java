package com.shop.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.JDBC.ProductFactory;
import com.shop.model.Order;
import com.shop.service.ProductService;



/**
 * Servlet implementation class GetQuotes
 */
@WebServlet("/GetQuotes")
public class GetQuotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = (ProductService)ProductFactory.getInstance("service");
		
		HttpSession session = request.getSession(false);
		int customerId = (Integer) session.getAttribute("customerId");
		//System.out.println(customerId+"------------");
		List<Order> items = service.getQoutes(customerId);
		System.out.println(items);
		session.setAttribute("orderKey", items);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayQuotes.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
