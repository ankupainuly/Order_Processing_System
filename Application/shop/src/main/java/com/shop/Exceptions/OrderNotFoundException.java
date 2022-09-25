package com.shop.Exceptions;

public class OrderNotFoundException extends Exception{
	int orderId;
	
	public  OrderNotFoundException(int orderId)
	{
		super();
		this.orderId = orderId;
	}
	public void showMessage()
	{
		System.out.println("Order with order Id "+orderId+" is not found");
	}
}
