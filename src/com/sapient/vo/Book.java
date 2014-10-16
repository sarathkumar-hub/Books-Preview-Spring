package com.sapient.vo;

import java.util.Set;

public class Book {

	private int bookId;
	private String bookName;
	private double bookPrice;
	private Publisher bookPublisher;
	private Set<Author> bookAuthors;
	private Set<Store> bookStores;

	public Set<Store> getBookStores() {
		return bookStores;
	}

	public void setBookStores(Set<Store> bookStores) {
		this.bookStores = bookStores;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Publisher getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(Publisher bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Set<Author> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(Set<Author> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bookPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (Double.doubleToLongBits(bookPrice) != Double
				.doubleToLongBits(other.bookPrice))
			return false;
		return true;
	}
	
}
