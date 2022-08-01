package com.quickbytes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCombo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemComboId;
	
	@ManyToOne
	private Combo combo;
	
	@ManyToOne
	private Item item;

	public Long getItemComboId() {
		return itemComboId;
	}

	public void setItemComboId(Long itemComboId) {
		this.itemComboId = itemComboId;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemCombo [itemComboId=" + itemComboId + ", combo=" + combo + ", item=" + item + "]";
	}

	public ItemCombo(Long itemComboId, Combo combo, Item item) {
		super();
		this.itemComboId = itemComboId;
		this.combo = combo;
		this.item = item;
	}

	public ItemCombo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

}
