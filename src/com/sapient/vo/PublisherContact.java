package com.sapient.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class PublisherContact {

	private int publisherContactId;
	
	@Size(min=5,max=30)
	@NotEmpty(message="Street cannot be Empty")
	@NotNull(message="Street cannot be Null")
	private String publisherContactStreet;
	
	@Size(min=5,max=150)
	@NotEmpty(message="City cannot be Empty")
	@NotNull(message="City cannot be Null")
	private String publisherContactCity;
	
	@Size(min=5,max=30)
	@NotEmpty(message="Area cannot be Empty")
	@NotNull(message="Area cannot be Null")
	private String publisherContactArea;
	
	@Range(min=7000000000L, max=9999999999L, message="Phone Number must be of 10 digits and within valid Range")
	private long publisherContactPhoneNo;

	public int getPublisherContactId() {
		return publisherContactId;
	}

	public void setPublisherContactId(int publisherContactId) {
		this.publisherContactId = publisherContactId;
	}

	public String getPublisherContactStreet() {
		return publisherContactStreet;
	}

	public void setPublisherContactStreet(String publisherContactStreet) {
		this.publisherContactStreet = publisherContactStreet;
	}

	public String getPublisherContactCity() {
		return publisherContactCity;
	}

	public void setPublisherContactCity(String publisherContactCity) {
		this.publisherContactCity = publisherContactCity;
	}

	public String getPublisherContactArea() {
		return publisherContactArea;
	}

	public void setPublisherContactArea(String publisherContactArea) {
		this.publisherContactArea = publisherContactArea;
	}

	public long getPublisherContactPhoneNo() {
		return publisherContactPhoneNo;
	}

	public void setPublisherContactPhoneNo(long publisherContactPhoneNo) {
		this.publisherContactPhoneNo = publisherContactPhoneNo;
	}

	@Override
	public String toString() {
		return "PublisherContact [publisherContactId=" + publisherContactId
				+ ", publisherContactStreet=" + publisherContactStreet
				+ ", publisherContactCity=" + publisherContactCity
				+ ", publisherContactArea=" + publisherContactArea
				+ ", publisherContactPhoneNo=" + publisherContactPhoneNo + "]";
	}
	
}
