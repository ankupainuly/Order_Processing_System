package com.shop.Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.QuoteDao;
import com.shop.model.Customer;

/**
 * Servlet implementation class CustomerVerification
 */
@WebServlet("/CustomerVerification")
public class CustomerVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerVerification() {
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
		// TODO Auto-generated method stub\
		
		
		
		int customerid=Integer.parseInt(request.getParameter("customerid"));
	
		Customer customer= new Customer();
		customer.setCustomerid(customerid);
		QuoteDao customerVerify= new QuoteDao();
			try {
				if(customerVerify.validateCustomer(customer))
				{
					request.setAttribute("customerid",customerid);
					RequestDispatcher rd= request.getRequestDispatcher("ShowCustomerDetails");
					rd.forward(request, response);
					
				}
				else
				{
					request.setAttribute("errormsg", "Please enter valid Customer ID.");
					RequestDispatcher rd= request.getRequestDispatcher("CustomerDetails.jsp");
					rd.forward(request, response);
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}

