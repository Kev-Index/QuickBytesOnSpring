package com.quickbytes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RequestItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestItemId;
	
	@ManyToOne //fk
	private Request request;
	
	@ManyToOne //fk
	private Item item;

	public RequestItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestItem(Long requestItemId, Request request, Item item) {
		super();
		this.requestItemId = requestItemId;
		this.request = request;
		this.item = item;
	}

	public Long getRequestItemId() {
		return requestItemId;
	}

	public void setRequestItemId(Long requestItemId) {
		this.requestItemId = requestItemId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "RequestItem [requestItemId=" + requestItemId + ", request=" + request + ", item=" + item + "]";
	}
}
