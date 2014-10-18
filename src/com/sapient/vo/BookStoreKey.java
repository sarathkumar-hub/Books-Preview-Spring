package com.sapient.vo;

import java.io.Serializable;

public class BookStoreKey implements Serializable{
	private int bookId;
	private int storeId;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
}
