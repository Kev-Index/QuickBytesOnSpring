package com.quickbytes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	
	@ManyToOne
	private Vendor vendor;
	
	private String name;
	private Float price;
	private Integer quantity;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Long itemId, Vendor vendor, String name, Float price, Integer quantity) {
		super();
		this.itemId = itemId;
		this.vendor = vendor;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [ItemId=" + itemId + ", vendor=" + vendor + ", name=" + name + ", Price=" + price + ", quantity="
				+ quantity + "]";
	}
	public Long getId() {
		return itemId;
	}
	public void setId(Long itemId) {
		this.itemId = itemId;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
