package com.shop.JDBC;

import com.shop.dao.JdbcProductDao;
import com.shop.service.ProductServiceImpl;

public class ProductFactory {
	
	public static Object getInstance(String type) {
		if(type.equals("dao"))
			return new JdbcProductDao();
		if(type.equals("service"))
			return new ProductServiceImpl();
		
		return null;
	
	}
}