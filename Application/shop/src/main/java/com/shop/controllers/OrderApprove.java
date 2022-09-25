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
 * Servlet implementation class OrderApprove
 */
@WebServlet("/OrderApprove")
public class OrderApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ProductService service = (ProductService)ProductFactory.getInstance("service");
			String order = request.getParameter("orderId");
			int  orderId = Integer.parseInt(order);
			service.approveOrder(orderId);
			
			HttpSession session = request.getSession(false);
			int customerId= (Integer)session.getAttribute("customerId");
			List<Order> orders = service.getQoutes(customerId);
			session.setAttribute("orderKey", orders);
			
			RequestDispatcher rd = request.getRequestDispatcher("DisplayQuotes.jsp");
			
			rd.forward(request, response);
				
	}

}
