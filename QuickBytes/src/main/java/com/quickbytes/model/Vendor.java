package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "vendors")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendorId;
	
	@Column(nullable=false)
	private Long businessId;
	
	@Column(length=45, nullable=false)
	private String name;
	
	@OneToOne
	private UserInfo user;
	
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public Vendor() {
		super();
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vendor(Long vendorId, Long businessId, String name) {
		super();
		this.vendorId = vendorId;
		this.businessId = businessId;
		this.name = name;
	}

	
	
}