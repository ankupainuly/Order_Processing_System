package com.shop.service;

import java.util.List;

import com.shop.model.Order;
import com.shop.model.Product;


public interface ProductService {
	public List<Product> fetchAll();
	public List<Order> getQoutes(int customerId);
	public void approveOrder(int orderId);
	public List<Order> getOrders(int customerId);
	public List<Product> fetchProductList(int orderId);
}
