package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;
	
	@OneToOne //fk
	@Column(nullable=false)
	private Order order;
	
	@OneToOne //fk
	@Column(nullable=false)
	private Item item;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long orderItemId, Order order, Item item) {
		super();
		this.orderItemId = orderItemId;
		this.order = order;
		this.item = item;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", order=" + order + ", item=" + item + "]";
	}
}
