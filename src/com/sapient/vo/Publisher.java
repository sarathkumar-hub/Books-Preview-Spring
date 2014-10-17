package com.sapient.vo;

import java.util.Set;

/**
 * @author Sarath Kumar
 *
 */
public class Publisher {

	private int publisherId;
	private String publisherName;
	private PublisherContact publisherContact;
	private Set<Book> publisherBooks;

	public Set<Book> getPublisherBooks() {
		return publisherBooks;
	}

	public void setPublisherBooks(Set<Book> publisherBooks) {
		this.publisherBooks = publisherBooks;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public PublisherContact getPublisherContact() {
		return publisherContact;
	}

	public void setPublisherContact(PublisherContact publisherContact) {
		this.publisherContact = publisherContact;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName="
				+ publisherName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + publisherId;
		result = prime * result
				+ ((publisherName == null) ? 0 : publisherName.hashCode());
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
		Publisher other = (Publisher) obj;
		if (publisherId != other.publisherId)
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.equals(other.publisherName))
			return false;
		return true;
	}

}
