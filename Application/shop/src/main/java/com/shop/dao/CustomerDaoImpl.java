package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.JDBC.DBConnection;
import com.shop.JDBC.DBUtility;
import com.shop.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	DBConnection db= new DBConnection();
	
	@Override
	public boolean customerLoginValidate(Customer customer)
	{
		PreparedStatement pst= db.getPreparedStatement("select * from  customer where customerid=? and password=?");
		boolean status = false;
		try {
			pst.setInt(1, customer.getCustomerid());
			pst.setString(2, customer.getPassword());
			
			ResultSet rs= pst.executeQuery();
			status=rs.next();
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		return status;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Customer customer = new Customer();
				try {
					Connection connection  = DBUtility.getConnection();
					String Query  = "select * from customer where customerId = "+customerId;
					PreparedStatement preparedStatement =  connection.prepareStatement(Query);
					ResultSet resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						customer.setCustomerid((int)resultSet.getInt("customerid"));
						customer.setName(resultSet.getString("name"));
						customer.setGst(resultSet.getInt("gst"));
						customer.setAddress(resultSet.getString("address"));
						customer.setMail(resultSet.getString("mail"));
						customer.setCity(resultSet.getString("city"));
					}	
					preparedStatement.close();
					connection.close();			
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return customer;
	}

	

}
