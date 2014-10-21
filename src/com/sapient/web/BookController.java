package com.sapient.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.dao.DaoI;
import com.sapient.vo.Author;
import com.sapient.vo.Book;
import com.sapient.vo.Publisher;
import com.sapient.vo.Store;

@Controller
public class BookController {
	private DaoI dao;

	@Autowired
	@Qualifier("daoImpl")
	public void setDao(DaoI dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/viewall.htm", method = RequestMethod.GET)
	public String Viewall(){
		return "ViewAll";
	}

	@RequestMapping(value = "/viewallbooks.htm", method = RequestMethod.GET)
	public String ViewAllBooks(Model model) {
		List<Book> book = dao.getAllBooks(true, true, true);
		model.addAttribute("book", book);
		return "AllBook";

	}

	@RequestMapping(value = "/viewallauthors.htm", method = RequestMethod.GET)
	public String ViewAllAuthors(Model model) {
		List<Author> author = dao.getAllAuthors(true, true);
		model.addAttribute("author", author);
		return "AllAuthors";
	}

	@RequestMapping(value = "/viewallpublishers.htm", method = RequestMethod.GET)
	public String ViewAllPublisher(Model model) {
		List<Publisher> publisher = dao.getAllPublishers(true, true);
		model.addAttribute("publisher", publisher);
		return "AllPublishers";
	}

	@RequestMapping(value = "/viewallstores.htm", method = RequestMethod.GET)
	public String ViewAllStores(Model model) {
		List<Store> store = dao.getAllStores(true, true);
		model.addAttribute("store", store);
		return "AllStores";
	}
	
	@RequestMapping(value = "/viewbyid.htm", method = RequestMethod.GET)
	public String viewAllBooks(Model model) {
		return "ViewById";
	}
	
	@RequestMapping(value = "/storesforbook.htm", method = RequestMethod.GET)
	public String ViewAllStoresForBook(Model model, @RequestParam("bookId") int bookId) {
		Set<Store> store = dao.getBookById(bookId, false, false, true).getBookStores();
		model.addAttribute("store", store);
		return "AllStores";
	}
	
	@RequestMapping(value = "/booksforauthor.htm", method = RequestMethod.GET)
	public String ViewAllBooksForAuthor(Model model, @RequestParam("authorId") int authorId) {
		Set<Book> bookSet = dao.getAuthorById(authorId, true, true).getAuthorBooks();
		List<Book> booksList = new ArrayList<Book>();
		Iterator<Book> it = bookSet.iterator();
		Book fetchedBook, book;
		while(it.hasNext()) {
			book = it.next();
			fetchedBook = dao.getBookById(book.getBookId(), true, true, true);
			booksList.add(fetchedBook);
		}
		model.addAttribute("book", booksList);
		return "AllBook";
	}
	
	@RequestMapping(value = "/booksforstore.htm", method = RequestMethod.GET)
	public String ViewAllBooksForStore(Model model, @RequestParam("storeId") int storeId) {
		Set<Book> bookSet = dao.getStoreById(storeId, true, true).getBooks();
		List<Book> booksList = new ArrayList<Book>();
		Iterator<Book> it = bookSet.iterator();
		Book fetchedBook, book;
		while(it.hasNext()) {
			book = it.next();
			fetchedBook = dao.getBookById(book.getBookId(), true, true, true);
			booksList.add(fetchedBook);
		}
		model.addAttribute("book", booksList);
		return "AllBook";
	}
	
	@RequestMapping(value = "/booksforpublisher.htm", method = RequestMethod.GET)
	public String ViewAllStoresForPublisher(Model model, @RequestParam("publisherId") int publisherId) {
		Set<Book> bookSet = dao.getPublisherById(publisherId, true, true).getPublisherBooks();
		List<Book> booksList = new ArrayList<Book>();
		Iterator<Book> it = bookSet.iterator();
		Book fetchedBook, book;
		while(it.hasNext()) {
			book = it.next();
			fetchedBook = dao.getBookById(book.getBookId(), true, true, true);
			booksList.add(fetchedBook);
		}
		model.addAttribute("book", booksList);
		return "AllBook";
	}

	@RequestMapping(value = "/viewbookbyid.htm", method = RequestMethod.GET)
	public String viewBookById(Model model, @RequestParam("bookbyid") int bookId) {
		List<Book> books = dao.getAllBooks(true, true, true);

		model.addAttribute("allbooks", books);

		if (bookId != 0) {
			for (Book book : books) {
				if (book.getBookId() == bookId) {
					// System.out.println(book.getBookId() + " " +
					// book.getBookName() + " " + book.getBookPrice());
					model.addAttribute("currentbook", book);

				}
			}
		}
		return "BookById";
	}

	@RequestMapping(value = "/bookbyid.htm", method = RequestMethod.GET)
	public String viewBookById(Model model) {
		List<Book> books = dao.getAllBooks(true, true, true);

		model.addAttribute("allbooks", books);
		

		Book book = books.get(0);
		model.addAttribute("currentbook", book);

		return "BookById";
	}

	@RequestMapping(value = "/viewauthorbyname.htm", method = RequestMethod.GET)
	public String viewAuthorByName(Model model,
			@RequestParam("authorbyname") int authorId) {
		List<Author> authors = dao.getAllAuthors(true, true);

		model.addAttribute("allauthors", authors);

		if (authorId != 0) {
			for (Author author : authors) {
				if (author.getAuthorId() == authorId) {
					// System.out.println(book.getBookId() + " " +
					// book.getBookName() + " " + book.getBookPrice());
					model.addAttribute("currentauthor", author);

				}
			}
		}
		return "AuthorByName";
	}

	@RequestMapping(value = "/authorbyname.htm", method = RequestMethod.GET)
	public String viewAuthorByName(Model model) {
		List<Author> authors = dao.getAllAuthors(true, true);

		model.addAttribute("allauthors", authors);
		Author author = authors.get(0);
		model.addAttribute("currentauthor", author);

		return "AuthorByName";
	}
	
	@RequestMapping(value = "/viewpublisherbyname.htm", method = RequestMethod.GET)
	public String viewPublisherByName(Model model,
			@RequestParam("publisherbyname") int publisherId) {
		List<Publisher> publishers = dao.getAllPublishers(true, true);

		model.addAttribute("allpublishers", publishers);

		if (publisherId != 0) {
			for (Publisher publisher : publishers) {
				if (publisher.getPublisherId() == publisherId) {
					// System.out.println(book.getBookId() + " " +
					// book.getBookName() + " " + book.getBookPrice());
					model.addAttribute("currentpublisher", publisher);

				}
			}
		}
		return "PublisherByName";
	}

	@RequestMapping(value = "/publisherbyname.htm", method = RequestMethod.GET)
	public String viewPublisherByName(Model model) {
		List<Publisher> publishers = dao.getAllPublishers(true, true);

		model.addAttribute("allpublishers", publishers);
		Publisher publisher = publishers.get(0);
		model.addAttribute("currentpublisher", publisher);

		return "PublisherByName";
	}
	
	@RequestMapping(value = "/viewstorebyname.htm", method = RequestMethod.GET)
	public String viewStoreByName(Model model,
			@RequestParam("storebyname") int storeId) {
		List<Store> stores = dao.getAllStores(true, true);

		model.addAttribute("allstores", stores);

		if (storeId != 0) {
			for (Store store : stores) {
				if (store.getStoreId() == storeId) {
					// System.out.println(book.getBookId() + " " +
					// book.getBookName() + " " + book.getBookPrice());
					model.addAttribute("currentstore", store);

				}
			}
		}
		return "StoreByName";
	}

	@RequestMapping(value = "/storebyname.htm", method = RequestMethod.GET)
	public String viewStoreByName(Model model) {
		List<Store> stores = dao.getAllStores(true, true);

		model.addAttribute("allstores", stores);
		
		Store store = stores.get(0);
		model.addAttribute("currentstore", store);

		return "StoreByName";
	}

}
