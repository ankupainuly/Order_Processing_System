/**
 * 
 */
package com.shop.service;

import java.util.*;

import com.shop.JDBC.ProductFactory;
import com.shop.dao.ProductDao;
import com.shop.model.Order;
import com.shop.model.Product;


public class ProductServiceImpl implements ProductService {
	private ProductDao prodDao = null;
	 public ProductServiceImpl() {
			prodDao = (ProductDao)ProductFactory.getInstance("dao");
		}
	
	@Override
	public List<Product> fetchAll() {
		 
			return	prodDao.getAll() ;
		
		 
	}

	@Override
	public List<Order> getQoutes(int customerId) {
		List<Order> orders = new ArrayList<Order>();
		orders =  prodDao.getQoutes(customerId);
		return orders;
		
	}

	@Override
	public void approveOrder(int orderId) {
		prodDao.updateOrderStatus(orderId);
		
		
	}

	@Override
	public List<Order> getOrders(int customerId) {
		List<Order> orders = new ArrayList<Order>();
		orders = prodDao.getApprovedOrders(customerId);
		return orders;
	}

	@Override
	public List<Product> fetchProductList(int orderId) {
		List<Product> items = new ArrayList<Product>();
		items = prodDao.getProductList(orderId);
		return items;
	}
	//function added for invoice
		public Order fetchOrderDetails(int orderId) {
			Order order = new Order();
			order = prodDao.getOrderDetails(orderId);
			return order;
		}
		
		

}
