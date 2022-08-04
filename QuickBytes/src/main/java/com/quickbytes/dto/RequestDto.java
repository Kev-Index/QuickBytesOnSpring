package com.quickbytes.dto;

import java.time.LocalDate;

import com.quickbytes.enums.RequestStatus;

public class RequestDto {

	private Long requestId;
	private Float totalPrice;
	private RequestStatus status;
	private LocalDate orderTime;
	private LocalDate endTime;
	private Long customerId;
	private Integer customerEmployeeId;
	private String customerFirstName;
	private String customerLastName;
	private Float customerBalance;
	private Long customerUserId;
	private String customerUsername;
	private String customerUserRole;
	private Long vendorId;
	private Integer vendorBusinessId;
	private String vendorName;
	private Long vendorUserId;
	private String vendorUsername;
	private String vendorUserRole;
	
	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDto(Long requestId, Float totalPrice, RequestStatus status, LocalDate orderTime, LocalDate endTime,
			Long customerId, Integer customerEmployeeId, String customerFirstName, String customerLastName,
			Float customerBalance, Long customerUserId, String customerUsername, String customerUserRole, Long vendorId,
			Integer vendorBusinessId, String vendorName, Long vendorUserId, String vendorUsername,
			String vendorUserRole) {
		super();
		this.requestId = requestId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderTime = orderTime;
		this.endTime = endTime;
		this.customerId = customerId;
		this.customerEmployeeId = customerEmployeeId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerBalance = customerBalance;
		this.customerUserId = customerUserId;
		this.customerUsername = customerUsername;
		this.customerUserRole = customerUserRole;
		this.vendorId = vendorId;
		this.vendorBusinessId = vendorBusinessId;
		this.vendorName = vendorName;
		this.vendorUserId = vendorUserId;
		this.vendorUsername = vendorUsername;
		this.vendorUserRole = vendorUserRole;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public LocalDate getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDate orderTime) {
		this.orderTime = orderTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerEmployeeId() {
		return customerEmployeeId;
	}

	public void setCustomerEmployeeId(Integer customerEmployeeId) {
		this.customerEmployeeId = customerEmployeeId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public Float getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(Float customerBalance) {
		this.customerBalance = customerBalance;
	}

	public Long getCustomerUserId() {
		return customerUserId;
	}

	public void setCustomerUserId(Long customerUserId) {
		this.customerUserId = customerUserId;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerUserRole() {
		return customerUserRole;
	}

	public void setCustomerUserRole(String customerUserRole) {
		this.customerUserRole = customerUserRole;
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

	@Override
	public String toString() {
		return "RequestDto [requestId=" + requestId + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", orderTime=" + orderTime + ", endTime=" + endTime + ", customerId=" + customerId
				+ ", customerEmployeeId=" + customerEmployeeId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerBalance=" + customerBalance
				+ ", customerUserId=" + customerUserId + ", customerUsername=" + customerUsername
				+ ", customerUserRole=" + customerUserRole + ", vendorId=" + vendorId + ", vendorBusinessId="
				+ vendorBusinessId + ", vendorName=" + vendorName + ", vendorUserId=" + vendorUserId
				+ ", vendorUsername=" + vendorUsername + ", vendorUserRole=" + vendorUserRole + "]";
	}
}
