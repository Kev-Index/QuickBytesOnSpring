package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.quickbytes.enums.Order_Status;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(nullable=false)
	private Float totalPrice;
	
	@Column(nullable=false)
	private Order_Status status;
	
	@Column(nullable=false)
	private String orderTime;
	
	@Column(nullable=false)
	private String endTime;
	
	@OneToOne //fk
	@Column(nullable=false)
	private Customer customer;
	
	@OneToOne //fk
	@Column(nullable=false)
	private Vendor vendor;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderId, Float totalPrice, Order_Status status, String orderTime, String endTime, Customer customer,
			Vendor vendor) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderTime = orderTime;
		this.endTime = endTime;
		this.customer = customer;
		this.vendor = vendor;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order_Status getStatus() {
		return status;
	}

	public void setStatus(Order_Status status) {
		this.status = status;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", status=" + status + ", orderTime="
				+ orderTime + ", endTime=" + endTime + "]";
	}
}
