package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.quickbytes.enums.RequestStatus;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	
	@Column(nullable=false)
	private Float totalPrice;
	
	@Column(nullable=false)
	private RequestStatus status;
	
	@Column(nullable=false)
	private String orderTime;
	
	@Column(nullable=false)
	private String endTime;
	
	@ManyToOne //fk
	private Customer customer;
	
	@ManyToOne //fk
	private Vendor vendor;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(Long requestId, Float totalPrice, RequestStatus status, String orderTime, String endTime, Customer customer,
			Vendor vendor) {
		super();
		this.requestId = requestId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderTime = orderTime;
		this.endTime = endTime;
		this.customer = customer;
		this.vendor = vendor;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
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
		return "Request [requestId=" + requestId + ", totalPrice=" + totalPrice + ", status=" + status + ", orderTime="
				+ orderTime + ", endTime=" + endTime + "]";
	}
}
