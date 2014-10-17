package com.sapient.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/viewbooks.htm", method = RequestMethod.GET)
	public String ViewAllBooks(Model model) {
		List<Book> book = dao.getAllBooks();
		model.addAttribute("book", book);
		List<Author> author = dao.getAllAuthors();
		model.addAttribute("author", author);
		List<Publisher> publisher = dao.getAllPublishers();
		model.addAttribute("publisher", publisher);
		return "AllBooks";

	}

	@RequestMapping(value = "/viewauthors.htm", method = RequestMethod.GET)
	public String ViewAllAuthors(Model model) {
		List<Author> author = dao.getAllAuthors();
		model.addAttribute("author", author);
		return "AllAuthors";
	}

	@RequestMapping(value = "/viewpublishers.htm", method = RequestMethod.GET)
	public String ViewAllPublisher(Model model) {
		List<Publisher> publisher = dao.getAllPublishers();
		model.addAttribute("publisher", publisher);
		return "AllPublishers";
	}

	@RequestMapping(value = "/viewstores.htm", method = RequestMethod.GET)
	public String ViewAllStores(Model model) {
		List<Store> store = dao.getAllStores();
		model.addAttribute("store", store);
		return "AllStores";
	}

}
