package com.quickbytes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendorId;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(Long vendorId, String name) {
		super();
		this.vendorId = vendorId;
		this.name = name;
	}



	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + "]";
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
}
