package com.quickbytes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany
	List<ItemCombo> itemComboList;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
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

	public List<ItemCombo> getItemComboList() {
		return itemComboList;
	}

	public void setItemComboList(List<ItemCombo> itemComboList) {
		this.itemComboList = itemComboList;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", vendor=" + vendor + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + ", itemComboList=" + itemComboList + "]";
	}

	public Item(Long itemId, Vendor vendor, String name, Float price, Integer quantity, List<ItemCombo> itemComboList) {
		super();
		this.itemId = itemId;
		this.vendor = vendor;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.itemComboList = itemComboList;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
