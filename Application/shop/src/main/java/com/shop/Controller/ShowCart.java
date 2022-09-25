package com.shop.Controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.QuoteDao;
import com.shop.model.Cart;
import com.shop.model.Products;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
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
		
		
		QuoteDao quotedao = new QuoteDao();
		int orderId = (int) request.getSession().getAttribute("orderid");
		List <Cart> quoteData = quotedao.GetQuoteDetails(orderId);
		
		request.setAttribute("QuoteData", quoteData);
		request.setAttribute("orderid", orderId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCart.jsp");
		
		if(dispatcher!=null) {
			dispatcher.forward(request, response);
		}
	}

}
