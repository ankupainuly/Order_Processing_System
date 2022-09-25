package com.shop.Controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.QuoteDao;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		//doGet(request, response);
		
		QuoteDao quotedao = new QuoteDao();
		String[] productId =request.getParameterValues("isSelected");
		System.out.println(Arrays.toString(productId) + "---------");
		String[] orderQuantity= request.getParameterValues("orderQuantity");
		System.out.println(Arrays.toString(orderQuantity) + "---------");
		
		ArrayList<String> list = new ArrayList<String>();
		for (String s : orderQuantity) {
		    if (!s.equals("")) {
		        list.add(s);
		    }
		}
		orderQuantity = list.toArray(new String[list.size()]);	
		
		int customerid=Integer.parseInt(request.getParameter("customerid"));
		
		int orderId = quotedao.InsertIntoOrders(customerid);
		
		
		quotedao.InsertIntoOrderedProducts(orderId,productId,orderQuantity);
		double shippingCost=quotedao.CalculateShippingCost(orderId);
		double orderValue =quotedao.CalculateQuoteValue(orderId);
		quotedao.updateIntoOrders(orderId, shippingCost, orderValue);
		
		request.getSession().setAttribute("orderid", orderId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCart");
		
		if(dispatcher!=null) {
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

//}
