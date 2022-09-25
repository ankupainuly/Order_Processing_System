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
import com.shop.model.Product;
import com.shop.service.ProductService;


/**
 * Servlet implementation class FetchDetails
 */
@WebServlet("/FetchDetails")
public class FetchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = (ProductService)ProductFactory.getInstance("service");
		String order = request.getParameter("orderId");
		int  orderId = Integer.parseInt(order);
		HttpSession session = request.getSession(false);
		List<Product> products = service.fetchProductList(orderId);
		request.setAttribute("listKey", products);
		RequestDispatcher rd = request.getRequestDispatcher("OrderDetails.jsp");
		rd.forward(request, response);
	}

}
