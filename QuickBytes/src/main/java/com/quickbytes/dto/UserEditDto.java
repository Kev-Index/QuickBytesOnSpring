package com.quickbytes.dto;

public class UserEditDto{
	private String userName; 
	
	
	public UserEditDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public UserEditDto(String userName) {
		super();
		this.userName = userName;
	}



}