package com.shop.dao;

import java.util.List;

import com.shop.model.Order;
import com.shop.model.Product;



public interface ProductDao {
	public List<Product> getAll();
	public List<Order> getQoutes(int customerId);
	public List<Product> getProductList(int orderId);
	public void updateOrderStatus(int orderId);
	public List<Order> getApprovedOrders(int customerId);
	//function added for invoice
	public Order getOrderDetails(int orderId);
}
