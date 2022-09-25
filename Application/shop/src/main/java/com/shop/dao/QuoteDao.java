package com.shop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.shop.JDBC.DBConnection;
import com.shop.JDBC.DBUtility;
import com.shop.model.Cart;
import com.shop.model.Customer;
import com.shop.model.Order;
import com.shop.model.Products;

public class QuoteDao {

	DBConnection dbConnection = new DBConnection();

	public boolean validateCustomer(Customer customer) {
		boolean status = false;

		PreparedStatement preparedstatement = dbConnection
				.getPreparedStatement("SELECT * FROM CUSTOMER WHERE CUSTOMERID = ? ");
		try {
			preparedstatement.setInt(1, customer.getCustomerid());
			// System.out.println(preparedstatement);

			ResultSet resultSet = preparedstatement.executeQuery();
			status = resultSet.next();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			dbConnection.closeConnection();
		}

		return status;
	}

	public double CalculateQuoteValue(int orderId) {
		double orderValue = 0;
		DBConnection dbConnection = new DBConnection();
		String sql = "SELECT O.PRODUCTID,  P.PRODUCTPRICE ,O.QUANTITY FROM ORDEREDPRODUCTS O JOIN PRODUCTS  P ON O.PRODUCTID =P.PRODUCTID WHERE O.ORDERID="+orderId;

		try {
			PreparedStatement prepstatement = dbConnection.getPreparedStatement(sql);
			
			
			ResultSet resultSet = prepstatement.executeQuery();
			
			while(resultSet.next()) {
			
				double price =resultSet.getInt("PRODUCTPRICE");
				int quantity = resultSet.getInt("QUANTITY");
				orderValue= orderValue + (price*quantity);
			}
			prepstatement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return orderValue;
	}

	public double CalculateShippingCost(int orderId) {
		double shippingCost = 0;
		DBConnection dbConnection = new DBConnection();
		String sql = "SELECT O.PRODUCTID, P.PRODUCTCATEGORY,  P.PRODUCTPRICE FROM ORDEREDPRODUCTS O JOIN PRODUCTS  P ON O.PRODUCTID =P.PRODUCTID WHERE ORDERID="+orderId;

		try {
			PreparedStatement prepstatement = dbConnection.getPreparedStatement(sql);
			
			
			ResultSet resultSet = prepstatement.executeQuery();
			
			while(resultSet.next()) {
			
				double price =resultSet.getInt("PRODUCTPRICE");
				if(resultSet.getString("PRODUCTCATEGORY").equalsIgnoreCase("Level1")) {
					shippingCost += 0.05*price;
				}else if(resultSet.getString("PRODUCTCATEGORY").equalsIgnoreCase("Level2")) {
					shippingCost += 0.03*price;
				}else if(resultSet.getString("PRODUCTCATEGORY").equalsIgnoreCase("Level3")) {
					shippingCost += 0.02 *price;
				}
			}
			prepstatement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return shippingCost;
	}

	public List<Products> GetAllProducts() {

		DBConnection dbConnection = new DBConnection();
		List<Products> productData = new ArrayList<Products>();

		Statement statement = dbConnection.getStatement();
		String sql = "SELECT * FROM PRODUCTS";
		try {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Products product = new Products();
				product.setProductId(resultSet.getInt("PRODUCTID"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
				product.setProductCategory(resultSet.getString("productCategory"));
				product.setProductQuantity(resultSet.getInt("productQuantity"));
				product.setOrderQuantity(0);
				productData.add(product);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productData;

	}

	public void InsertIntoOrderedProducts(int orderId,String[] productId, String[] orderQuantity) {

		DBConnection dbConnection = new DBConnection();
		String sql = "INSERT INTO ORDEREDPRODUCTS (ORDERID,PRODUCTID , QUANTITY) " + " VALUES(?,?,?)";

		try {
			PreparedStatement prepstatement = dbConnection.getPreparedStatement(sql);
			// int count=0;

			for (int i = 0; i < productId.length; i++) {
					prepstatement.setInt(1,orderId);
					prepstatement.setInt(2, Integer.parseInt(productId[i]));
					prepstatement.setInt(3, Integer.parseInt(orderQuantity[i]));
					prepstatement.addBatch();
				/*
				 * count++; //execute very 10 rows or less
				 * 
				 * if(count%10 ==0 || count== productId.length) { prepstatement.addBatch(); }
				 */
			}
			prepstatement.executeBatch();
			prepstatement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public int InsertIntoOrders(int customerId) {
		DBConnection dbConnection = new DBConnection();
		String sql = "INSERT INTO ORDERS (ORDERID,DATE,CUSTOMERID,TOTALVALUE,STATUS,SHIPPINGAGAENCY,SHIPPINGCOST) "
				+ " VALUES(?,?,?,?,?,?,?)";
		int orderId=0;
		
		try {
			PreparedStatement prepstatement = dbConnection.getPreparedStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			Customer customer = new Customer();

			prepstatement.setInt(1, (int)System.currentTimeMillis());
			prepstatement.setDate(2, date);
			prepstatement.setInt(3, customerId);
			prepstatement.setInt(4, 0);
			prepstatement.setString(5, "pending");
			prepstatement.setString(6, "BlueDart");
			prepstatement.setInt(7, 0);
			prepstatement.executeUpdate();
			
			ResultSet resultSet =prepstatement.getGeneratedKeys();
			resultSet.next();
			 orderId = resultSet.getInt(1);

			prepstatement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orderId;
	}
	public List<Cart> GetQuoteDetails(int orderId) {

		DBConnection dbConnection = new DBConnection();
		List<Cart> quoteData = new ArrayList<Cart>();

		Statement statement = dbConnection.getStatement();
		String sql = "SELECT O.PRODUCTID, O.ORDERID, O.QUANTITY, P.productCategory, P.productName FROM ORDEREDPRODUCTS O JOIN PRODUCTS  P ON O.PRODUCTID =P.PRODUCTID WHERE ORDERID =" +orderId;
		try {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setProductId(resultSet.getInt("PRODUCTID"));
				cart.setOrderId(resultSet.getInt("ORDERID"));
				cart.setQuantity(resultSet.getInt("QUANTITY"));
				cart.setCategory(resultSet.getString("productcategory"));
				cart.setName(resultSet.getString("productName"));
				quoteData.add(cart);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return quoteData;

	}
	
	public void updateIntoOrders(int orderId,double shippingCost,double orderValue) {
		
		DBConnection dbConnection = new DBConnection();
		
		String sql = "UPDATE ORDERS SET TOTALVALUE=?,SHIPPINGCOST=? WHERE ORDERID =" + orderId ;
		if(orderValue>100000) {
			shippingCost=0;
		}
		try {
			PreparedStatement prepstatement = dbConnection.getPreparedStatement(sql);

			prepstatement.setDouble(1, orderValue);
			prepstatement.setDouble(2, shippingCost);
			prepstatement.executeUpdate();
			prepstatement.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public List<Order> getApprovedOrders() {
		// TODO Auto-generated method stub
		
		
		List<Order> orders = new ArrayList<Order>();
		try {
			DBConnection dbConnection = new DBConnection();
			String Query  = "select * from orders where ( status = 'pending')";
			PreparedStatement preparedStatement =  dbConnection.getPreparedStatement(Query);
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
			dbConnection.closeConnection();
			preparedStatement.close();
			return orders;
			//scanner.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}


}