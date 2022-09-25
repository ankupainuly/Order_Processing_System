package com.shop.service;

import com.shop.dao.EmployeeProfileDAO;
import com.shop.model.Employee;

/*
 * @author shubham kumar
 */


public class EmployeeProfileService {
	EmployeeProfileDAO employeeProfileDAO = new EmployeeProfileDAO();
	
	public Employee getEmployeeDetailsById(int employeeid) {
		return employeeProfileDAO.getEmployeeDetailsById(employeeid);
		
	}

}
