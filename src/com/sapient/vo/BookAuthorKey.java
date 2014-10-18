package com.sapient.vo;

import java.io.Serializable;

public class BookAuthorKey implements Serializable{
	
	private int bookId;
	private int authorId;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	

}
