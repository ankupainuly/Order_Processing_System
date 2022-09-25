package com.shop.model;

import java.util.ArrayList;

public class Order {
	private int orderId;
	private String date;
	private double totalValue;
	private ArrayList<Product> productIdList;
	private String status;
	private int customerId;
	private String shippingAgency;
	private double shippingCost;
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public void setShippingAgency(String shippingAgency) {
		this.shippingAgency = shippingAgency;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getShippingAgency() {
		return shippingAgency;
	}
	public void setShipAgency(String shipAgency) {
		this.shippingAgency = shipAgency;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", totalValue=" + totalValue + ", productIdList="
				+ productIdList + ", status=" + status + ", customerId=" + customerId + ", shippingAgency="
				+ shippingAgency + ", shippingCost=" + shippingCost + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((productIdList == null) ? 0 : productIdList.hashCode());
		result = prime * result + ((shippingAgency == null) ? 0 : shippingAgency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(shippingCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(totalValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId != other.customerId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderId != other.orderId)
			return false;
		if (productIdList == null) {
			if (other.productIdList != null)
				return false;
		} else if (!productIdList.equals(other.productIdList))
			return false;
		if (shippingAgency == null) {
			if (other.shippingAgency != null)
				return false;
		} else if (!shippingAgency.equals(other.shippingAgency))
			return false;
		if (Double.doubleToLongBits(shippingCost) != Double.doubleToLongBits(other.shippingCost))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(totalValue) != Double.doubleToLongBits(other.totalValue))
			return false;
		return true;
	}
	
	

}
