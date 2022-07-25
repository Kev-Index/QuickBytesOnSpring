package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(nullable=false)
	private Long vendorId;

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

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
	
	
	
	
	
}