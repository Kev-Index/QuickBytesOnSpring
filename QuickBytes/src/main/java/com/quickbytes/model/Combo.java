package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "combos")
public class Combo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comboId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private float price;
	
	@Column(nullable=false)
	private Integer available;
	
	@OneToOne
	private Vendor vendor;

	public Combo(Long comboId, String name, float price, Integer available, Vendor vendor) {
		super();
		this.comboId = comboId;
		this.name = name;
		this.price = price;
		this.available = available;
		this.vendor=vendor;
	}

	public Combo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getComboId() {
		return comboId;
	}

	public void setComboId(Long comboId) {
		this.comboId = comboId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}


	
	
	
	
}
