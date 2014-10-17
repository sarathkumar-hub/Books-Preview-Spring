package com.sapient.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sapient.vo.Author;
import com.sapient.vo.Book;
import com.sapient.vo.Publisher;
import com.sapient.vo.Store;

public class DaoImpl implements DaoI {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// working
	public List<Book> getAllBooks(boolean fetchPublisher, boolean fetchAuthor,
			boolean fetchStores) {
		List<Book> booksList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getAllBooks);
		booksList = query.list();
		if (fetchPublisher || fetchStores || fetchAuthor) {
			for (Book book : booksList) {
				if (fetchPublisher) {
					Hibernate.initialize(book.getBookPublisher());
				}
				if (fetchStores) {
					Hibernate.initialize(book.getBookStores());
				}
				if (fetchAuthor) {
					Hibernate.initialize(book.getBookAuthors());
				}
			}
		}
		transaction.commit();
		session.close();
		return booksList;
	}

	// working
	public List<Author> getAllAuthors(boolean fetchContact, boolean fetchBooks) {
		List<Author> authorsList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getAllAuthors);
		authorsList = query.list();
		if (fetchContact || fetchBooks) {
			for (Author author : authorsList) {
				if (fetchContact) {
					Hibernate.initialize(author.getAuthorContact());
				}
				if (fetchBooks) {
					Hibernate.initialize(author.getAuthorBooks());
				}
			}
		}
		transaction.commit();
		session.close();
		return authorsList;
	}

	// working
	public List<Store> getAllStores(boolean fetchContact, boolean fetchBooks) {
		List<Store> storesList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getAllStores);
		storesList = query.list();

		if(fetchContact || fetchBooks ) {
			for(Store store:storesList){
				if(fetchContact) {
					Hibernate.initialize(store.getStoreContact());
				}
				if (fetchBooks) {
					Hibernate.initialize(store.getBooks());
				}
			}
		}
		transaction.commit();
		session.close();
		return storesList;
	}

	// working
	public List<Publisher> getAllPublishers(boolean fetchContact,
			boolean fetchBooks) {
		List<Publisher> publishersList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getAllPublishers);
		publishersList = query.list();
		if(fetchContact || fetchBooks ) {
			for(Publisher publisher:publishersList){
				if(fetchContact) {
					Hibernate.initialize(publisher.getPublisherContact());
				}
				if (fetchBooks) {
					Hibernate.initialize(publisher.getPublisherBooks());
				}
			}
		}
		transaction.commit();
		session.close();
		return publishersList;
	}

	// working
	public boolean deleteAuthorForBook(Author a, Book b) {
		a = getAuthorById(15, true, true);
		b = getBookById(16, true, true, true);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Set<Author> authors = b.getBookAuthors();
		authors.remove(a);
		transaction.commit();
		session.close();
		return false;
	}

	// working
	public List<Author> getAllAuthors() {
		return getAllAuthors(false, false);
	}

	// working
	public List<Book> getAllBooks() {
		return getAllBooks(false, false, false);
	}

	// working
	public List<Store> getAllStores() {
		return getAllStores(false, false);
	}

	// working
	public List<Publisher> getAllPublishers() {
		return getAllPublishers(false, false);
	}

	// working
	public List<Book> getBooksByAuthor(Author author) {
		return getBooksByAuthor(author, false, false, false);
	}

	// working
	public List<Book> getBooksByAuthor(Author author, boolean fetchPublisher,
			boolean fetchAuthor, boolean fetchStores) {
		return getBooksByAuthor(author.getAuthorId(), fetchPublisher,
				fetchAuthor, fetchStores);
	}

	// working
	public List<Book> getBooksByAuthor(int authorId) {
		return getBooksByAuthor(authorId, false, false, false);
	}

	// working
	public List<Book> getBooksByAuthor(int authorId, boolean fetchPublisher,
			boolean fetchAuthor, boolean fetchStores) {
		Author author = getAuthorById(authorId, false, true);
		List<Book> booksList = null;
		if (author != null && author.getAuthorBooks().size() != 0) {
			booksList = new ArrayList<Book>();
			booksList.addAll(author.getAuthorBooks());
			if (fetchPublisher || fetchAuthor || fetchStores) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				for (Book book : booksList) {
					if (fetchPublisher) {
						Hibernate.initialize(book.getBookPublisher());
					}
					if (fetchAuthor) {
						Hibernate.initialize(book.getBookAuthors());
					}
					if (fetchStores) {
						Hibernate.initialize(book.getBookStores());
					}
				}
				transaction.commit();
				session.close();
			}
		}
		return booksList;
	}

	// working
	public List<Book> getBooksByStore(Store store) {
		return getBooksByStore(store, false, false, false);
	}

	// working
	public List<Book> getBooksByStore(Store store, boolean fetchPublisher,
			boolean fetchAuthor, boolean fetchStores) {
		return getBooksByStore(store.getStoreId(), fetchPublisher, fetchAuthor,
				fetchStores);
	}

	// working
	public List<Book> getBooksByStore(int storeId) {
		return getBooksByStore(storeId, false, false, false);
	}

	// working
	public List<Book> getBooksByStore(int storeId, boolean fetchPublisher,
			boolean fetchAuthor, boolean fetchStores) {
		Store store = getStoreById(storeId, false, true);
		List<Book> booksList = null;
		if (store != null && store.getBooks().size() != 0) {
			booksList = new ArrayList<Book>();
			booksList.addAll(store.getBooks());
			if (fetchPublisher || fetchAuthor || fetchStores) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				for (Book book : booksList) {
					session.merge(book);
					if (fetchPublisher) {
						Hibernate.initialize(book.getBookPublisher());
					}
					if (fetchAuthor) {
						Hibernate.initialize(book.getBookAuthors());
					}
					if (fetchStores) {
						Hibernate.initialize(book.getBookStores());
					}
				}
				transaction.commit();
				session.close();
			}
		}
		return booksList;
	}

	// working
	public List<Store> getStoresByBook(Book book) {
		return getStoresByBook(book, false, false);
	}

	// working
	public List<Store> getStoresByBook(Book book, boolean fetchContact,
			boolean fetchBooks) {
		return getStoresByBook(book.getBookId(), fetchContact, fetchBooks);
	}

	// working
	public List<Store> getStoresByBook(int bookId) {
		return getStoresByBook(bookId, false, false);
	}

	// working
	public List<Store> getStoresByBook(int bookId, boolean fetchContact,
			boolean fetchBooks) {
		Book book = getBookById(bookId, false, false, true);
		List<Store> storesList = null;
		if (book != null && book.getBookStores().size() != 0) {
			storesList = new ArrayList<Store>();
			storesList.addAll(book.getBookStores());
			if (fetchContact || fetchBooks) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				for (Store store : storesList) {
					session.merge(store);
					if (fetchContact) {
						Hibernate.initialize(store.getStoreContact());
					}
					if (fetchBooks) {
						Hibernate.initialize(store.getBooks());
					}
				}
				transaction.commit();
				session.close();
			}
		}
		return storesList;
	}
	
	// working
	public List<Author> getAuthorsByBook(Book book) {
		return getAuthorsByBook(book, false, false);
	}

	// working
	public List<Author> getAuthorsByBook(Book book, boolean fetchContact,
			boolean fetchBooks) {
		return getAuthorsByBook(book.getBookId(), fetchContact, fetchBooks);
	}

	// working
	public List<Author> getAuthorsByBook(int bookId) {
		return getAuthorsByBook(bookId, false, false);
	}

	// working
	public List<Author> getAuthorsByBook(int bookId, boolean fetchContact,
			boolean fetchBooks) {
		Book book = getBookById(bookId, false, false, true);
		List<Author> authorsList = null;
		if (book != null && book.getBookAuthors().size() != 0) {
			authorsList = new ArrayList<Author>();
			authorsList.addAll(book.getBookAuthors());
			if (fetchContact || fetchBooks) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				for (Author author : authorsList) {
					if (fetchContact) {
						Hibernate.initialize(author.getAuthorContact());
					}
					if (fetchBooks) {
						Hibernate.initialize(author.getAuthorBooks());
					}
				}
				transaction.commit();
				session.close();
			}
		}
		return authorsList;
	}

	// working
	public Publisher getPublisherByBook(Book book) {
		return getPublisherByBook(book, false, false);
	}

	// working
	public Publisher getPublisherByBook(Book book, boolean fetchContact,
			boolean fetchBooks) {
		return getPublisherByBook(book.getBookId(), fetchContact, fetchBooks);
	}

	// working
	public Publisher getPublisherByBook(int bookId) {
		return getPublisherByBook(bookId, false, false);
	}

	// working
	public Publisher getPublisherByBook(int bookId, boolean fetchContact,
			boolean fetchBooks) {
		Book book = getBookById(bookId, true, false, false);
		if (book != null) {
			return book.getBookPublisher();
		}
		return null;
	}

	// working
	public List<Book> getBooksByPublisher(Publisher publisher) {
		return getBooksByPublisher(publisher, false, false, false);
	}

	// working
	public List<Book> getBooksByPublisher(Publisher publisher,
			boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores) {
		return getBooksByPublisher(publisher.getPublisherId(), fetchPublisher,
				fetchAuthor, fetchStores);
	}

	// working
	public List<Book> getBooksByPublisher(int publisherId) {
		return getBooksByPublisher(publisherId, false, false, false);
	}

	// working
	public List<Book> getBooksByPublisher(int publisherId,
			boolean fetchPublisher, boolean fetchAuthor, boolean fetchStores) {
		Publisher publisher = getPublisherById(publisherId, false, true);
		List<Book> booksList = null;
		if (publisher != null && publisher.getPublisherBooks().size() != 0) {
			booksList = new ArrayList<Book>();
			booksList.addAll(publisher.getPublisherBooks());
			if (fetchPublisher || fetchAuthor || fetchStores) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				for (Book book : booksList) {
					session.merge(book);
					if (fetchPublisher) {
						Hibernate.initialize(book.getBookPublisher());
					}
					if (fetchAuthor) {
						Hibernate.initialize(book.getBookAuthors());
					}
					if (fetchStores) {
						Hibernate.initialize(book.getBookStores());
					}
				}
				transaction.commit();
				session.close();
			}
		}
		return booksList;
	}

	// working
	public Book getBookById(int bookId) {
		return getBookById(bookId, false, false, false);
	}

	// working
	public Book getBookById(int bookId, boolean fetchPublisher,
			boolean fetchAuthor, boolean fetchStores) {
		List<Book> booksList = null;
		Book book = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getBookById);
		query.setInteger("bookId", bookId);
		booksList = query.list();
		if (booksList != null && booksList.size() != 0) {
			book = booksList.get(0);
			if (fetchPublisher) {
				Hibernate.initialize(book.getBookPublisher());
			}
			if (fetchAuthor) {
				Hibernate.initialize(book.getBookAuthors());
			}
			if (fetchStores) {
				Hibernate.initialize(book.getBookStores());
			}
		}
		transaction.commit();
		session.close();
		return book;
	}

	// working
	public Author getAuthorById(int authorId) {
		return getAuthorById(authorId, false, false);
	}

	// working
	public Author getAuthorById(int authorId, boolean fetchContact,
			boolean fetchBooks) {
		List<Author> authorsList = null;
		Author author = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getAuthorById);
		query.setInteger("authorId", authorId);
		authorsList = query.list();
		if (authorsList != null && authorsList.size() != 0) {
			author = authorsList.get(0);
			if (fetchContact) {
				Hibernate.initialize(author.getAuthorContact());
			}
			if (fetchBooks) {
				Hibernate.initialize(author.getAuthorBooks());
			}
		}
		transaction.commit();
		session.close();
		return author;
	}

	// working
	public Store getStoreById(int storeId) {
		return getStoreById(storeId, false, false);
	}

	// working
	public Store getStoreById(int storeId, boolean fetchContact,
			boolean fetchBooks) {
		List<Store> storesList = null;
		Store store = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getStoreById);
		query.setInteger("storeId", storeId);
		storesList = query.list();
		if (storesList != null && storesList.size() != 0) {
			store = storesList.get(0);
			if (fetchContact) {
				Hibernate.initialize(store.getStoreContact());
			}
			if (fetchBooks) {
				Hibernate.initialize(store.getBooks());
			}
		}
		transaction.commit();
		session.close();
		return store;
	}

	// working
	public Publisher getPublisherById(int publisherId) {
		return getPublisherById(publisherId, false, false);
	}

	// working
	public Publisher getPublisherById(int publisherId, boolean fetchContact,
			boolean fetchBooks) {
		List<Publisher> publishersList = null;
		Publisher publisher = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(HibernateQueries.getPublisherById);
		query.setInteger("publisherId", publisherId);
		publishersList = query.list();
		if (publishersList != null && publishersList.size() != 0) {
			publisher = publishersList.get(0);
			if (fetchContact) {
				Hibernate.initialize(publisher.getPublisherContact());
			}
			if (fetchBooks) {
				Hibernate.initialize(publisher.getPublisherBooks());
			}
		}
		transaction.commit();
		session.close();
		return publisher;
	}

	// working
	public boolean editBook(Book book) {
		return editBook(book, false, false, false);
	}

	// working
	public boolean editBook(Book editedBook, boolean editPublisher,
			boolean editAuthor, boolean editStores) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Book book = getBookById(editedBook.getBookId(), editPublisher,
				editAuthor, editStores);
		Boolean result = false;
		if (book != null) {
			book.setBookName(editedBook.getBookName());
			book.setBookPrice(editedBook.getBookPrice());
			if (editPublisher) {
				book.setBookPublisher(editedBook.getBookPublisher());
			}
			if (editStores) {
				book.setBookStores(editedBook.getBookStores());
			}
			if (editAuthor) {
				book.setBookAuthors(editedBook.getBookAuthors());
			}
			session.update(book);
			result = true;
		}
		transaction.commit();
		session.close();
		return result;
	}

	// working
	public boolean editAuthor(Author author) {
		return editAuthor(author, false, false);
	}

	// working
	public boolean editAuthor(Author editedAuthor, boolean editContact,
			boolean editBooks) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Author author = getAuthorById(editedAuthor.getAuthorId(), editContact,
				editBooks);
		Boolean result = false;
		if (author != null) {
			author.setAuthorName(editedAuthor.getAuthorName());
			if (editContact) {
				author.setAuthorContact(editedAuthor.getAuthorContact());
			}
			if (editBooks) {
				author.setAuthorBooks(editedAuthor.getAuthorBooks());
			}
			session.update(author);
			result = true;
		}
		transaction.commit();
		session.close();
		return result;
	}

	// working
	public boolean editPublisher(Publisher publisher) {
		return editPublisher(publisher, false, false);
	}

	// working
	public boolean editPublisher(Publisher editPublisher, boolean editContact,
			boolean editBooks) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Publisher publisher = getPublisherById(editPublisher.getPublisherId(),
				editContact, editBooks);
		Boolean result = false;
		if (publisher != null) {
			publisher.setPublisherName(editPublisher.getPublisherName());
			if (editContact) {
				publisher.setPublisherContact(editPublisher
						.getPublisherContact());
			}
			if (editBooks) {
				publisher.setPublisherBooks(editPublisher.getPublisherBooks());
			}
			session.update(publisher);
			result = true;
		}
		transaction.commit();
		session.close();
		return result;
	}

	// working
	public boolean editStore(Store store) {
		return editStore(store, false, false);
	}

	// working
	public boolean editStore(Store editStore, boolean editContact,
			boolean editBooks) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Store store = getStoreById(editStore.getStoreId(), editContact,
				editBooks);
		Boolean result = false;
		if (store != null) {
			store.setStoreName(editStore.getStoreName());
			if (editContact) {
				store.setStoreContact(editStore.getStoreContact());
			}
			if (editBooks) {
				store.setBooks(editStore.getBooks());
			}
			session.update(store);
			result = true;
		}
		transaction.commit();
		session.close();
		return result;
	}

	// working
	public boolean addStore(Store store) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(store);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	public boolean addBook(Book book) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(book);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	public boolean addPublisher(Publisher publisher) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(publisher);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	//working
	public boolean addAuthor(Author author) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(author);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	// working
	public boolean addStoreForBook(Store store, Book book) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Store> set = book.getBookStores();

		try {

			set.add(store);

			book.setBookStores(set);

			session.update(book);

			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	// working
	public boolean addStoreForBook(int storeId, int bookId) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Store> set;
		try {
			Book book = getBookById(bookId, false, false, true);
			set = book.getBookStores();
			Store store = getStoreById(storeId);
			set.add(store);
			book.setBookStores(set);
			session.update(book);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	// working
	public boolean addAuthorForBook(Author author, Book book) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Author> set = book.getBookAuthors();

		try {

			set.add(author);

			book.setBookAuthors(set);

			session.update(book);

			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	//working
	public boolean addAuthorForBook(int authorId, int bookId) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Author> set;
		try {
			Book book = getBookById(bookId, false, true, false);
			set = book.getBookAuthors();
			Author author = getAuthorById(authorId);
			set.add(author);
			book.setBookAuthors(set);
			session.update(book);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	//working
	public boolean deleteStoreForBook(Store store, Book book) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Store> set = book.getBookStores();

		try {

			set.remove(store);
			

			book.setBookStores(set);

			session.update(book);

			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	//working
	public boolean deleteStoreForBook(int storeId, int bookId) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Store> set;
		try {
			Book book = getBookById(bookId, false, false, true);
			set = book.getBookStores();
			Store store = getStoreById(storeId);
			set.remove(store);
			book.setBookStores(set);
			session.update(book);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	//working
	public boolean deleteAuthorForBook(int authorId, int bookId) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<Author> set;
		try {
			Book book = getBookById(bookId, false, true, false);
			set = book.getBookAuthors();
			Author author = getAuthorById(authorId);
			set.remove(author);
			book.setBookAuthors(set);
			session.update(book);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();

		} finally {
			session.close();
		}
		return false;
	}

	public boolean deleteStore(Store store) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(store);
		}catch(HibernateException e){
			transaction.rollback();
		}finally{
			session.close();
		}
		return false;
	}

	public boolean deleteStore(int storeId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAuthor(Author author) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAuthor(int authorId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean uploadImageForBook(Book book, String imageFileName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean uploadImageForBook(int bookId, String imageFileName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editImageForBook(int bookId, String imageFileName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editImageForBook(Book book, String imageFileName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteImageForBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteImageForBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}


}