package com.sapient.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * @author Sarath Kumar
 *
 */
public class AuthorContact {

	private int authorContactId;
	
	@Size(min=5,max=150)
	@NotEmpty(message="Name cannot be Empty")
	@NotNull(message="Name cannot be Null")
	private String authorContactEmail;
	
	@Range(min=7000000000L, max=9999999999L, message="Phone Number must be of 10 digits and within valid range")
	private long authorContactPhoneNo;
	
	@Size(min=5,max=30)
	@NotEmpty(message="Street cannot be Empty")
	@NotNull(message="Street cannot be Null")
	private String authorContactStreet;
	
	@Size(min=5,max=30)
	@NotEmpty(message="Area cannot be Empty")
	@NotNull(message="Area cannot be Null")
	private String authorContactArea;
	
	@Size(min=5,max=150)
	@NotEmpty(message="City cannot be Empty")
	@NotNull(message="City cannot be Null")
	private String authorContactCity;

	public int getAuthorContactId() {
		return authorContactId;
	}

	public void setAuthorContactId(int authorContactId) {
		this.authorContactId = authorContactId;
	}

	public String getAuthorContactEmail() {
		return authorContactEmail;
	}

	public void setAuthorContactEmail(String authorContactEmail) {
		this.authorContactEmail = authorContactEmail;
	}

	public long getAuthorContactPhoneNo() {
		return authorContactPhoneNo;
	}

	public void setAuthorContactPhoneNo(long authorContactPhoneNo) {
		this.authorContactPhoneNo = authorContactPhoneNo;
	}

	public String getAuthorContactStreet() {
		return authorContactStreet;
	}

	public void setAuthorContactStreet(String authorContactStreet) {
		this.authorContactStreet = authorContactStreet;
	}

	public String getAuthorContactArea() {
		return authorContactArea;
	}

	public void setAuthorContactArea(String authorContactArea) {
		this.authorContactArea = authorContactArea;
	}

	public String getAuthorContactCity() {
		return authorContactCity;
	}

	public void setAuthorContactCity(String authorContactCity) {
		this.authorContactCity = authorContactCity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((authorContactEmail == null) ? 0 : authorContactEmail
						.hashCode());
		result = prime * result + authorContactId;
		result = prime * result
				+ (int) (authorContactPhoneNo ^ (authorContactPhoneNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorContact other = (AuthorContact) obj;
		if (authorContactEmail == null) {
			if (other.authorContactEmail != null)
				return false;
		} else if (!authorContactEmail.equals(other.authorContactEmail))
			return false;
		if (authorContactId != other.authorContactId)
			return false;
		if (authorContactPhoneNo != other.authorContactPhoneNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthorContact [authorContactId=" + authorContactId
				+ ", authorContactEmail=" + authorContactEmail
				+ ", authorContactPhoneNo=" + authorContactPhoneNo
				+ ", authorContactStreet=" + authorContactStreet
				+ ", authorContactArea=" + authorContactArea
				+ ", authorContactCity=" + authorContactCity + "]";
	}
	
}
