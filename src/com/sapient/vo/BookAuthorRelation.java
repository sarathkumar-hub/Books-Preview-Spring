package com.sapient.vo;

public class BookAuthorRelation {
	
	private BookAuthorKey key;
	
	private Book book;
	private Author author;
	public BookAuthorKey getKey() {
		return key;
	}
	public void setKey(BookAuthorKey key) {
		this.key = key;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

}
