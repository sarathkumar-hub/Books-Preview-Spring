package com.sapient.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class StoreContact {

	private int storeContactId;
	
	@Range(min=7000000000L, max=9999999999L, message="Phone Number must be of 10 digits and within valid Range")
	private long storeContactPhoneNo;
	
	@Size(min=3,max=30)
	@NotEmpty(message="Street cannot be Empty")
	@NotNull(message="Street cannot be Null")
	private String storeContactStreet;
	
	@Size(min=3,max=30)
	@NotEmpty(message="Area cannot be Empty")
	@NotNull(message="Area cannot be Null")
	private String storeContactArea;
	
	@Size(min=3,max=150)
	@NotEmpty(message="City cannot be Empty")
	@NotNull(message="City cannot be Null")
	private String storeContactCity;
	
	public long getStoreContactPhoneNo() {
		return storeContactPhoneNo;
	}

	public void setStoreContactPhoneNo(long storeContactPhoneNo) {
		this.storeContactPhoneNo = storeContactPhoneNo;
	}

	public int getStoreContactId() {
		return storeContactId;
	}

	public void setStoreContactId(int storeContactId) {
		this.storeContactId = storeContactId;
	}

	public String getStoreContactStreet() {
		return storeContactStreet;
	}

	public void setStoreContactStreet(String storeContactStreet) {
		this.storeContactStreet = storeContactStreet;
	}

	public String getStoreContactArea() {
		return storeContactArea;
	}

	public void setStoreContactArea(String storeContactArea) {
		this.storeContactArea = storeContactArea;
	}

	public String getStoreContactCity() {
		return storeContactCity;
	}

	public void setStoreContactCity(String storeContactCity) {
		this.storeContactCity = storeContactCity;
	}

}
