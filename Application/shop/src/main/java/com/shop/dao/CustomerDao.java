package com.shop.dao;

import com.shop.model.Customer;

public interface CustomerDao {
	
	public boolean customerLoginValidate(Customer customer);
	public Customer getCustomer(int customerId);

}
