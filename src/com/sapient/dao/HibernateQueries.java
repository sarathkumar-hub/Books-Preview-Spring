package com.sapient.dao;

public interface HibernateQueries {
	
	public static String getAllBooks = "from Book";
	public static String getAllAuthors = "from Author";
	public static String getAllStores = "from Store";
	public static String getAllPublishers = "from Publisher";
	public static String getBookByAuthor = "from Author A where A.authorId=:authorId";
	public static String getBookByPublisher = "from Publisher P where P.publisherId=:publisherId";
	public static String getBookByStore = "from Store S where S.storeId=:storeId";
	public static String getStoresByBook = "from Book B where B.bookId=:bookId";
	public static String getAuthorsByBook = "from Book B where B.bookId=:bookId";
	public static String getPublisherByBook = "from Book B where B.bookId=:bookId";
	
	public static String getBookById = "from Book B where B.bookId=:bookId";
	public static String getStoreById = "from Store S where S.storeId=:storeId";
	public static String getAuthorById = "from Author A where A.authorId=:authorId";
	public static String getPublisherById = "from Publisher P where P.publisherId=:publisherId";
	
}
