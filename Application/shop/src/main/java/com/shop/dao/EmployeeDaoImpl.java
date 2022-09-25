package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.JDBC.DBConnection;
import com.shop.JDBC.DBUtility;
import com.shop.model.Customer;
import com.shop.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	DBConnection db= new DBConnection();
	
	@Override
	public boolean employeeLoginValidate(Employee employee) {
		// TODO Auto-generated method stub
		PreparedStatement pst= db.getPreparedStatement("select * from employee where employeeid=? and password=?");
		boolean status = false;
		try {
			pst.setInt(1, employee.getEmployeeid());
			pst.setString(2, employee.getPassword());
			
			ResultSet rs= pst.executeQuery();
			status=rs.next();
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
	public Employee getEmployee(int employeeId) {
		Employee employee = new Employee();
				try {
					Connection connection  = DBUtility.getConnection();
					String Query  = "select * from employee where employeeid = "+employeeId;
					PreparedStatement preparedStatement =  connection.prepareStatement(Query);
					ResultSet resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						employee.setEmployeeid((int)resultSet.getInt("employeeid"));
						employee.setName(resultSet.getString("name"));
					}	
					preparedStatement.close();
					connection.close();			
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return employee;
	}
	
	

}
