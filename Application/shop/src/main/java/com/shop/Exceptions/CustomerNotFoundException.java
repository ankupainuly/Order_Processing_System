package com.shop.Exceptions;

public class CustomerNotFoundException {
	int customerId;
	
	public CustomerNotFoundException(int customerId)
	{
		this.customerId = customerId;
	}
	
	public void showMessage()
	{
		System.out.println("Customer with Id "+customerId+" is not found");
	}
}
