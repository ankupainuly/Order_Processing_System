package com.shop.Controller;

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
import com.shop.dao.QuoteDao;
import com.shop.model.Order;
import com.shop.service.ProductService;

/**
 * Servlet implementation class GetAllOrder
 */
@WebServlet("/GetAllOrder")
public class GetAllOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllOrder() {
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
		//int customerId = (Integer)request.getAttribute("customerId");
		List<Order> orders = quotedao.getApprovedOrders();
		
		request.setAttribute("orderKey", orders);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayOrders.jsp");
		rd.forward(request, response);
	}

}
