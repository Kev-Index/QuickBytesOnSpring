package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderSet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderSetId;
	
	@ManyToOne //fk
	@Column(nullable=false)
	private Order order;
	
	@ManyToOne //fk
	@Column(nullable=false)
	private Set set;

	public OrderSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderSet(Long orderSetId, Order order, Set set) {
		super();
		this.orderSetId = orderSetId;
		this.order = order;
		this.set = set;
	}

	public Long getOrderSetId() {
		return orderSetId;
	}

	public void setOrderSetId(Long orderSetId) {
		this.orderSetId = orderSetId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "OrderSet [orderSetId=" + orderSetId + ", order=" + order + "]";
	}
	
}
