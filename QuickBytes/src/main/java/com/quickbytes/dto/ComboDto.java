package com.quickbytes.dto;

public class ComboDto {
	private Long comboId;
	private String name;
	private Float price;
	private Integer quantity;
	
	private Long vendorId;
	private Integer vendorBusinessId;
	private String vendorName;
	
	private Long vendorUserId;
	private String vendorUsername;
	private String vendorUserRole;
	

	public ComboDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComboDto(Integer quantity) {
		super();
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ComboDto [comboId=" + comboId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", vendorId=" + vendorId + ", vendorBusinessId=" + vendorBusinessId + ", vendorName=" + vendorName
				+ ", vendorUserId=" + vendorUserId + ", vendorUsername=" + vendorUsername + ", vendorUserRole="
				+ vendorUserRole + "]";
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
