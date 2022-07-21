package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderCombo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderComboId;
	
	@ManyToOne //fk
	@Column(nullable=false)
	private Order order;
	
	@ManyToOne //fk
	@Column(nullable=false)
	private Combo combo;

	public OrderCombo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCombo(Long orderComboId, Order order, Combo combo) {
		super();
		this.orderComboId = orderComboId;
		this.order = order;
		this.combo = combo;
	}

	public Long getOrderComboId() {
		return orderComboId;
	}

	public void setOrderComboId(Long orderComboId) {
		this.orderComboId = orderComboId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	@Override
	public String toString() {
		return "OrderCombo [orderComboId=" + orderComboId + ", order=" + order + "]";
	}
	
}
