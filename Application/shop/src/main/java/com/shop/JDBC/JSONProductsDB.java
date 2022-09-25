package com.shop.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.shop.dao.ProductJson;
import com.shop.model.Product;


public class JSONProductsDB {
	
	private Connection con=null;
	private PreparedStatement pstmt = null;
	
	public void addProductsToDB()
	{
		DBConnection con = new DBConnection();
		try {
		List<Product> products=new ProductJson().readJsonFile();
		for(Product product:products)
		{
			
			String sql = "INSERT INTO AAKASH.products(productid, name, price,category,total_quantity) VALUES (?,?,?,?,?)";
			pstmt = con.getPreparedStatement(sql);
			pstmt.setInt(1, product.getProdId());
			pstmt.setString(2, product.getName());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getCategory());
			pstmt.setInt(5,product.getQuantity());
			pstmt.executeUpdate();
			//System.out.println(product +"\nInserted records into the table...");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
