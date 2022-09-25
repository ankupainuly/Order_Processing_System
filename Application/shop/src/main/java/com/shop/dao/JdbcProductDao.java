package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.JDBC.DBUtility;
import com.shop.model.Order;
import com.shop.model.Product;




public class JdbcProductDao implements ProductDao {

	@Override
	public List<Product> getAll() {
		List<Product> items = new ArrayList<Product>();
		try {
			Connection connection  = DBUtility.getConnection();
			String loginQuery  = "select * from products";
			PreparedStatement preparedStatement =  connection.prepareStatement(loginQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProdId(resultSet.getInt("productid"));
				product.setName(resultSet.getString("productname"));
				product.setPrice(resultSet.getDouble("productPrice"));
				product.setCategory(resultSet.getString("productCategory"));
				items.add(product);
			}
		
			resultSet.close();
			connection.close();
			preparedStatement.close();
			return items;
			//scanner.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	

	public List<Product> getProductList(int orderId){
		List<Product> items = new ArrayList<Product>();
		try {
			Connection connection  = DBUtility.getConnection();
			String loginQuery  = "select name, category, price,orderid,quantity from products p inner join orderedproducts op on p.productid=op.productid where op.orderid="+orderId;
			PreparedStatement preparedStatement =  connection.prepareStatement(loginQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				items.add(product);
			}
		
			resultSet.close();
			connection.close();
			preparedStatement.close();
			return items;
			//scanner.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
		
	}
	
	@Override
	public List<Order> getQoutes(int customerId) {
		List<Order> orders = new ArrayList<Order>();
		try {
			Connection connection  = DBUtility.getConnection();
			String Query  = "select * from orders where (status  = 'pending' or status = 'completed') and customerid = "+customerId;
			PreparedStatement preparedStatement =  connection.prepareStatement(Query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderid"));
				order.setDate(resultSet.getString("date"));
				order.setTotalValue(resultSet.getDouble("totalvalue"));
				order.setStatus(resultSet.getString("status"));
				order.setShippingAgency((resultSet.getString("shippingagaency")));
				order.setShippingCost(resultSet.getDouble("shippingcost"));
				
				orders.add(order);
			}
		
			resultSet.close();
			connection.close();
			preparedStatement.close();
			return orders;
			//scanner.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public void updateOrderStatus(int orderId) {
		try {
			Connection connection  = DBUtility.getConnection();
			String Query  = "update orders set status = 'pending' where orderId = "+orderId;
			PreparedStatement preparedStatement =  connection.prepareStatement(Query);
			int resultSet = preparedStatement.executeUpdate();
	/*		
		while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderid"));
				order.setDate(resultSet.getString("date"));
				order.setTotalValue(resultSet.getDouble("total_value"));
				order.setStatus(resultSet.getString("status"));
				order.setShippingAgency((resultSet.getString("shipping_agency")));
				order.setShippingCost(resultSet.getDouble("shippingcost"));
			}
	*/
			
			connection.close();
			preparedStatement.close();
			
			//scanner.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getApprovedOrders(int customerId) {
		List<Order> orders = new ArrayList<Order>();
		try {
			Connection connection  = DBUtility.getConnection();
			String Query  = "select * from orders where status  = 'approved' and customerid = "+customerId;
			PreparedStatement preparedStatement =  connection.prepareStatement(Query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderid"));
				order.setDate(resultSet.getString("date"));
				order.setTotalValue(resultSet.getDouble("total_value"));
				order.setStatus(resultSet.getString("status"));
				order.setShippingAgency((resultSet.getString("shipping_agency")));
				order.setShippingCost(resultSet.getDouble("shippingcost"));
				
				orders.add(order);
			}
		
			resultSet.close();
			connection.close();
			preparedStatement.close();
			return orders;
			//scanner.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	@Override
	// function added for invoice
		public Order getOrderDetails(int orderId) {
			Order order = new Order();
			try {
				Connection connection = DBUtility.getConnection();
				String Query = "select * from orders where orderId = " + orderId;
				PreparedStatement preparedStatement = connection.prepareStatement(Query);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					order.setOrderId(resultSet.getInt("orderid"));
					order.setDate(resultSet.getString("date"));
					order.setTotalValue(resultSet.getDouble("total_value"));
					// order.setStatus(resultSet.getString("status"));
					order.setShippingAgency((resultSet.getString("shipping_agency")));
					order.setShippingCost(resultSet.getDouble("shippingcost"));
					order.setCustomerId(resultSet.getInt("customerid"));
				}
				preparedStatement.close();
				connection.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return order;

		}


}
