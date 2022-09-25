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

import com.shop.JDBC.DBConnection;
import com.shop.dao.QuoteDao;
import com.shop.model.Customer;

/**
 * Servlet implementation class CustomerShowDetails
 */
@WebServlet("/ShowCustomerDetails")
public class CustomerShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerShowDetails() {
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
		
		PrintWriter out =response.getWriter();
		out.print("customer details page");
		int customerid=Integer.parseInt(request.getParameter("customerid"));
		Customer customer = new Customer();
		DBConnection dbConnection = new  DBConnection();
		
		Statement statement =dbConnection.getStatement();
	String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMERID="+customerid;
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				customer.setCustomerid(resultSet.getInt("CUSTOMERID"));
				customer.setName(resultSet.getString("NAME"));
				customer.setGst(resultSet.getInt("GST"));
				customer.setAddress(resultSet.getString("ADDRESS"));
				customer.setCity(resultSet.getString("CITY"));
				customer.setMail(resultSet.getString("MAIL"));

			}
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.setAttribute("customer",customer);
		request.setAttribute("customerid", customerid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCustomerDetails.jsp");
		
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
