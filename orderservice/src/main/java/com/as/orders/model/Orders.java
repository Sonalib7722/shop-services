package com.as.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private String customerid;
	private int productid;
	private int cost;
	private String email;
	private long custmobilenumber;
	private String deliverylocation;
	private String supplierid;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCustmobilenumber() {
		return custmobilenumber;
	}
	public void setCustmobilenumber(long custmobilenumber) {
		this.custmobilenumber = custmobilenumber;
	}
	public String getDeliverylocation() {
		return deliverylocation;
	}
	public void setDeliverylocation(String deliverylocation) {
		this.deliverylocation = deliverylocation;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	
}
