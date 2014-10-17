package com.sapient.vo;

public class PublisherContact {

	private int publisherContactId;
	private String publisherContactStreet;
	private String publisherContactCity;
	private String publisherContactArea;
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
