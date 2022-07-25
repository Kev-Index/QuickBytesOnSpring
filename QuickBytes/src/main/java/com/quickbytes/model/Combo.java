package com.quickbytes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Combo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comboId;
	
	private String name;
	
	@OneToMany
	List<ItemCombo> itemComboList;

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

	public List<ItemCombo> getItemComboList() {
		return itemComboList;
	}

	public void setItemComboList(List<ItemCombo> itemComboList) {
		this.itemComboList = itemComboList;
	}

	@Override
	public String toString() {
		return "Combo [comboId=" + comboId + ", name=" + name + ", itemComboList=" + itemComboList + "]";
	}

	public Combo(Long comboId, String name, List<ItemCombo> itemComboList) {
		super();
		this.comboId = comboId;
		this.name = name;
		this.itemComboList = itemComboList;
	}

	public Combo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
