package com.quickbytes.dto;

public class ItemDto {
	private Long itemId;
	private String Name;
	private Float Price;
	private Integer Quantity;
	

	private Long vendorId;
	private Integer vendorBusinessId;
	private String vendorName;
	
	private Long vendorUserId;
	private String vendorUsername;
	private String vendorUserRole;
	
	public ItemDto(Long itemId, String name, Float price, Integer quantity, Long vendorId, Integer vendorBusinessId,
			String vendorName, Long vendorUserId, String vendorUsername, String vendorUserRole) {
		super();
		this.itemId = itemId;
		Name = name;
		Price = price;
		Quantity = quantity;
		this.vendorId = vendorId;
		this.vendorBusinessId = vendorBusinessId;
		this.vendorName = vendorName;
		this.vendorUserId = vendorUserId;
		this.vendorUsername = vendorUsername;
		this.vendorUserRole = vendorUserRole;
	}
	public ItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", Name=" + Name + ", Price=" + Price + ", Quantity=" + Quantity
				+ ", vendorId=" + vendorId + ", vendorBusinessId=" + vendorBusinessId + ", vendorName=" + vendorName
				+ ", vendorUserId=" + vendorUserId + ", vendorUsername=" + vendorUsername + ", vendorUserRole="
				+ vendorUserRole + "]";
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public Integer getVendorBusinessId() {
		return vendorBusinessId;
	}
	public void setVendorBusinessId(Integer vendorBusinessId) {
		this.vendorBusinessId = vendorBusinessId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Long getVendorUserId() {
		return vendorUserId;
	}
	public void setVendorUserId(Long vendorUserId) {
		this.vendorUserId = vendorUserId;
	}
	public String getVendorUsername() {
		return vendorUsername;
	}
	public void setVendorUsername(String vendorUsername) {
		this.vendorUsername = vendorUsername;
	}
	public String getVendorUserRole() {
		return vendorUserRole;
	}
	public void setVendorUserRole(String vendorUserRole) {
		this.vendorUserRole = vendorUserRole;
	}
	
}