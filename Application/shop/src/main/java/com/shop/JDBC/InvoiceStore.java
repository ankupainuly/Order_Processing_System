package com.shop.JDBC;


import java.util.HashMap;

public class InvoiceStore {

	static HashMap<Integer, String> invoiceDate = new HashMap<Integer, String>();

	public static void addDate(Integer orderId, String date) {
		InvoiceStore.invoiceDate.put(orderId, date);
	}

	public static String getDate(Integer orderId) {
		String date = invoiceDate.get(orderId);
		return date;
	}
}
