package com.shop.dao;

import com.shop.model.Employee;

public interface EmployeeDao {
	
	public boolean employeeLoginValidate(Employee employee);

	Employee getEmployee(int employeeId);
	

}
