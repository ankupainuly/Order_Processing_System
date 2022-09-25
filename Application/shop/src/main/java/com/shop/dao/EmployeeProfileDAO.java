package com.shop.dao;
/*
 * @author shubham kumar
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.shop.JDBC.DBConnection;
import com.shop.model.Employee;

public class EmployeeProfileDAO {

	DBConnection db = new DBConnection();
	boolean sessionStatus = false;

	public Employee getEmployeeDetailsById(int employeeid) {
		Employee employee = new Employee();
		PreparedStatement pst = db.getPreparedStatement("select * from employee where employeeid=?");

		try {
			pst.setInt(1, employeeid);
			ResultSet rs = pst.executeQuery();
			sessionStatus = rs.next();

			employee.setName(rs.getString("NAME"));
			employee.setEmployeeid(rs.getInt("EMPLOYEEID"));
			employee.setLastLoginDate(rs.getDate("lastlogindate").toString());
			employee.setLastLoginTime(rs.getTime("lastlogintime").toString());
			// updating last login details after fetching last login detatils.
			this.saveLastLoginDetails(employeeid);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;

	}

	public void saveLastLoginDetails(int employeeid) {
		PreparedStatement pst = db
				.getPreparedStatement("update employee set lastlogindate = ?, lastlogintime = ? where employeeid = ?");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		String nowDate = LocalDate.now().toString();
		String nowTime = LocalTime.now().format(formatter);
		try {
			pst.setString(1, nowDate);
			pst.setString(2, nowTime);
			pst.setInt(3, employeeid);
			
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
