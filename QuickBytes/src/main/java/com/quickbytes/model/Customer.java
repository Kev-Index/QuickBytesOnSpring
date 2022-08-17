package com.quickbytes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	//@Column(nullable = false) Te
	private int employeeId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private float balance;
	@OneToOne
	private UserInfo userId;
	
	/*
	 * START OF EXTRA CUSTOMER INFORMATION
	 * */
	
	// Personal Information
	@Column(nullable = true)
	private String middleName;
	@Column(nullable = true)
	private String email;
	@Column(nullable = true)
	private String phoneNumber;
	@Column(nullable = true)
	private String birthday;
	@Column(nullable = true)
	private String preferedName;
	
	// Billing Address
	@Column(nullable = true)
	private String addressLine1;
	@Column(nullable = true)
	private String addressLine2;
	@Column(nullable = true)
	private String suite;
	@Column(nullable = true)
	private String country;
	@Column(nullable = true)
	private String state;
	@Column(nullable = true)
	private String city;
	@Column(nullable = true)
	private String postalCode;
	
	// Verifications
	@Column(nullable = true)
	private boolean termsAccepted;
	@Column(nullable = true)
	private boolean emailVerified;
	@Column(nullable = true)
	private boolean twoFactorAuth;
	@Column(nullable = true)
	private boolean phoneVerified;
	
	/*
	 * END OF EXTRA CUSTOMER INFORMATION
	 * */
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, int employeeId, String firstName, String lastName, Float balance, UserInfo userId,
			String middleName, String email, String phoneNumber, String birthday, String preferedName,
			String addressLine1, String addressLine2, String suite, String country, String state, String city,
			String postalCode, boolean termsAccepted, boolean emailVerified, boolean twoFactorAuth,
			boolean phoneVerified) {
		super();
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.userId = userId;
		this.middleName = middleName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.preferedName = preferedName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.suite = suite;
		this.country = country;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
		this.termsAccepted = termsAccepted;
		this.emailVerified = emailVerified;
		this.twoFactorAuth = twoFactorAuth;
		this.phoneVerified = phoneVerified;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public UserInfo getUserId() {
		return userId;
	}

	public void setUserId(UserInfo userId) {
		this.userId = userId;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPreferedName() {
		return preferedName;
	}

	public void setPreferedName(String preferedName) {
		this.preferedName = preferedName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isTermsAccepted() {
		return termsAccepted;
	}

	public void setTermsAccepted(boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isTwoFactorAuth() {
		return twoFactorAuth;
	}

	public void setTwoFactorAuth(boolean twoFactorAuth) {
		this.twoFactorAuth = twoFactorAuth;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", employeeId=" + employeeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", balance=" + balance + ", userId=" + userId + ", middleName="
				+ middleName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", birthday=" + birthday
				+ ", preferedName=" + preferedName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", suite=" + suite + ", country=" + country + ", state=" + state + ", city=" + city + ", postalCode="
				+ postalCode + ", termsAccepted=" + termsAccepted + ", emailVerified=" + emailVerified
				+ ", twoFactorAuth=" + twoFactorAuth + ", phoneVerified=" + phoneVerified + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
