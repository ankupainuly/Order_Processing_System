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

import com.shop.JDBC.InvoiceStore;
import com.shop.JDBC.ProductFactory;
import com.shop.dao.CustomerDao;
import com.shop.dao.CustomerDaoImpl;
import com.shop.dao.JdbcProductDao;
import com.shop.dao.ProductDao;
import com.shop.model.Customer;
import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.service.ProductService;



/**
 * Servlet implementation class FetchInvoiceDetails
 */
@WebServlet("/FetchInvoiceDetails")
public class FetchInvoiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchInvoiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService service = (ProductService) ProductFactory.getInstance("service");
		ProductDao prdDao = new JdbcProductDao();
		CustomerDao custDao = new CustomerDaoImpl();
		String order = request.getParameter("orderId");
		int orderId = Integer.parseInt(order);

		Order order1 = prdDao.getOrderDetails(orderId);
		Customer customer = custDao.getCustomer(order1.getCustomerId());
		String invoice_date = InvoiceStore.getDate(orderId);
		List<Product> products = prdDao.getProductList(orderId);

		HttpSession session = request.getSession(false);

		request.setAttribute("invoiceId", orderId);

		request.setAttribute("customer_name", customer.getName());
		request.setAttribute("address", customer.getAddress() + ", " + customer.getCity());
		request.setAttribute("email", customer.getMail());
		request.setAttribute("invoice_date", invoice_date);
		request.setAttribute("quote_date", order1.getDate());
		
		request.setAttribute("listKey", products);

		request.setAttribute("total_value", order1.getTotalValue());
		request.setAttribute("total_gst", 0.1 * order1.getTotalValue());
		request.setAttribute("shippingcost", order1.getShippingCost());
		request.setAttribute("total_invoice_value", (1.1) * order1.getTotalValue() + order1.getShippingCost());

		RequestDispatcher rd = request.getRequestDispatcher("Invoice.jsp");
		rd.forward(request, response);
	}

}
