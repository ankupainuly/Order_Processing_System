package com.shop.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public static Connection getConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
	
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/OP","root","ankur123");
		
	
		return connection;
		
	}
}
