package com.sapient.dao;

import java.util.List;

import com.sapient.vo.Author;
import com.sapient.vo.Book;
import com.sapient.vo.Publisher;
import com.sapient.vo.Store;

public interface DaoI {
	
	public List<Book> getAllBooks();
	public List<Book> getAllBooks(boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	
	public List<Author> getAllAuthors();
	public List<Author> getAllAuthors(boolean fetchContact, boolean fetchBooks);
	
	public List<Store> getAllStores();
	public List<Store> getAllStores(boolean fetchContact, boolean fetchBooks);
	
	public List<Publisher> getAllPublishers();
	public List<Publisher> getAllPublishers(boolean fetchContact, boolean fetchBooks);
	
	public List<Book> getBooksByAuthor(Author author);
	public List<Book> getBooksByAuthor(Author author, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	public List<Book> getBooksByAuthor(int authorId);
	public List<Book> getBooksByAuthor(int authorId, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	
	public List<Book> getBooksByStore(Store store);
	public List<Book> getBooksByStore(Store store, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	public List<Book> getBooksByStore(int storeId);
	public List<Book> getBooksByStore(int storeId, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	
	public List<Store> getStoresByBook(Book book);
	public List<Store> getStoresByBook(Book book, boolean fetchContact, boolean fetchBooks);
	public List<Store> getStoresByBook(int bookId);
	public List<Store> getStoresByBook(int bookId, boolean fetchContact, boolean fetchBooks);
	
	public List<Author> getAuthorsByBook(Book book);
	public List<Author> getAuthorsByBook(Book book, boolean fetchContact, boolean fetchBooks);
	public List<Author> getAuthorsByBook(int bookId);
	public List<Author> getAuthorsByBook(int bookId,  boolean fetchContact, boolean fetchBooks);
	
	public Publisher getPublisherByBook(Book book);
	public Publisher getPublisherByBook(Book book, boolean fetchContact, boolean fetchBooks);
	public Publisher getPublisherByBook(int bookId);
	public Publisher getPublisherByBook(int bookId, boolean fetchContact, boolean fetchBooks);

	public List<Book> getBooksByPublisher(Publisher publisher);
	public List<Book> getBooksByPublisher(Publisher publisher, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	public List<Book> getBooksByPublisher(int publisherId);
	public List<Book> getBooksByPublisher(int publisherId, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	
	public Book getBookById(int bookId);
	public Book getBookById(int bookId, boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores);
	
	public Author getAuthorById(int authorId);
	public Author getAuthorById(int authorId, boolean fetchContact, boolean fetchBooks);
	
	public Store getStoreById(int storeId);
	public Store getStoreById(int storeId, boolean fetchContact, boolean fetchBooks);
	
	public Publisher getPublisherById(int publisherId);
	public Publisher getPublisherById(int publisherId, boolean fetchContact, boolean fetchBooks);
	
	public boolean editBook(Book book);
	public boolean editBook(Book book, boolean editPublisher, boolean editAuthor, boolean editStores);
	
	public boolean editAuthor(Author author);
	public boolean editAuthor(Author author, boolean editContact, boolean editBooks);
	
	public boolean editPublisher(Publisher publisher);
	public boolean editPublisher(Publisher publisher, boolean editContact, boolean editBooks);
	
	public boolean editStore(Store store);
	public boolean editStore(Store store, boolean editContact, boolean editBooks);
	
	public boolean addStore(Store store);
	public boolean addBook(Book book);
	public boolean addPublisher(Publisher publisher);
	public boolean addAuthor(Author author);
	
	public boolean addStoreForBook(Store store, Book book);
	public boolean addStoreForBook(int storeId, int bookId);
	
	public boolean addAuthorForBook(Author author, Book book);
	public boolean addAuthorForBook(int authorId, int bookId);
	
	public boolean deleteStoreForBook(Store store, Book book);
	public boolean deleteStoreForBook(int storeId, int bookId);
	
	public boolean deleteAuthorForBook(Author author, Book book);
	public boolean deleteAuthorForBook(int authorId, int bookId);
	
	public boolean deleteStore(Store store);
	public boolean deleteStore(int storeId);
	
	public boolean deleteBook(Book book);
	public boolean deleteBook(int bookId);	

	public boolean deleteAuthor(Author author);	
	public boolean deleteAuthor(int authorId);
	
	public boolean uploadImageForBook(Book book, String imageFileName);
	public boolean uploadImageForBook(int bookId, String imageFileName);
	
	public boolean editImageForBook(int bookId, String imageFileName);
	public boolean editImageForBook(Book book, String imageFileName);
	
	public boolean deleteImageForBook(Book book);
	public boolean deleteImageForBook(int bookId);
	
}
