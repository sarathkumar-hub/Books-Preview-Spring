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

	@RequestMapping(value = "/viewallbooks.htm", method = RequestMethod.GET)
	public String ViewAllBooks(Model model) {
		List<Book> book = dao.getAllBooks(true, true, true);
		model.addAttribute("book", book);
		return "AllBooks";

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

}
