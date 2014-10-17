package com.sapient.vo;

/**
 * @author Sarath Kumar
 *
 */
public class AuthorContact {

	private int authorContactId;
	private String authorContactEmail;
	private long authorContactPhoneNo;
	private String authorContactStreet;
	private String authorContactArea;
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
