package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RequestCombo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestComboId;
	
	@ManyToOne //fk
	private Request request;
	
	@ManyToOne //fk
	private Combo combo;

	public RequestCombo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestCombo(Long requestComboId, Request request, Combo combo) {
		super();
		this.requestComboId = requestComboId;
		this.request = request;
		this.combo = combo;
	}

	public Long getRequestComboId() {
		return requestComboId;
	}

	public void setRequestComboId(Long requestComboId) {
		this.requestComboId = requestComboId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	@Override
	public String toString() {
		return "RequestCombo [requestComboId=" + requestComboId + ", request=" + request + "]";
	}
	
}
