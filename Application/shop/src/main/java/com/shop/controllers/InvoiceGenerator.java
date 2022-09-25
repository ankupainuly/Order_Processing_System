
package com.shop.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.JDBC.InvoiceStore;


/**
 * Servlet implementation class InvoiceGenerator
 */
@WebServlet("/InvoiceGenerator")
public class InvoiceGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String order = request.getParameter("orderId");
		int  orderId = Integer.parseInt(order);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		InvoiceStore.addDate(orderId, date);
		HttpSession session = request.getSession(false);
		session.setAttribute("orderId", orderId);
		RequestDispatcher rd = request.getRequestDispatcher("OrderApprove");
		rd.forward(request, response);
	}

}
