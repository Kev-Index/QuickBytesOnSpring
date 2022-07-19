package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(nullable=false)
	private float totalPrice;
	
	@Column(nullable=false)
	private String status;
	
	@Column(nullable=false)
	private String orderTime;
	
	@Column(nullable=false)
	private String endTime;
	
	@OneToOne //fk
	private Customer customer;
	
	@OneToOne //fk
	private Vendor vendor;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderId, float totalPrice, String status, String orderTime, String endTime, Customer customer,
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

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
