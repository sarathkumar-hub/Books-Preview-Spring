package com.sapient.web;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.dao.DaoI;
import com.sapient.vo.Author;
import com.sapient.vo.Book;
import com.sapient.vo.Publisher;
import com.sapient.vo.Store;

@Controller
public class AddController {
	
	@Autowired
	@Qualifier(value="daoImpl")
	private DaoI daoI;
	
	public void setDaoI(DaoI daoI) {
		this.daoI = daoI;
	}
	
	@RequestMapping(value="/addall.add", method=RequestMethod.GET)
	public String viewAllAddOptions(){
		return "AddAll";
	}
	
	@RequestMapping(value="/addbook.add", method=RequestMethod.GET)
	public String addBook(Model model){
		List<Publisher> publishersList = daoI.getAllPublishers(true, true);
		model.addAttribute("publishersList", publishersList);
		Book book = new Book();
		model.addAttribute("book", book);
		return "AddBook";
	}
	
	@RequestMapping(value="/addbook.add", method=RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("book") @Valid Book book,BindingResult bindingResult, Model model){
		ModelAndView mview = new ModelAndView();
		if(bindingResult.hasErrors()){
			List<Publisher> publishersList = daoI.getAllPublishers(true, true);
			model.addAttribute("publishersList", publishersList);
			mview.setViewName("AddBook");
			return mview;
		}else{
			int primaryKey = daoI.addBook(book);
			if(primaryKey!=-1){
				List<Book> books = daoI.getAllBooks(true, true, true);
				model.addAttribute("allbooks", books);
				model.addAttribute("currentbook", book);
				mview.setViewName("BookById");
				return mview;
			}else{
				List<Publisher> publishersList = daoI.getAllPublishers(true, true);
				model.addAttribute("publishersList", publishersList);
				mview.setViewName("AddBook");
				return mview;
			}
		}
	}
	
	@RequestMapping(value="/addpublisher.add", method=RequestMethod.GET)
	public String addPublisher(Model model){
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		return "AddPublisher";
	}
	
	@RequestMapping(value="/addpublisher.add", method=RequestMethod.POST)
	public ModelAndView addPublisher(@ModelAttribute("publisher") @Valid Publisher publisher,BindingResult bindingResult, Model model){
		ModelAndView mview = new ModelAndView();
		if(bindingResult.hasErrors()){
			mview.setViewName("AddPublisher");
			return mview;
		}else{
			int primaryKey = daoI.addPublisher(publisher);
			if(primaryKey!=-1){
				mview.setViewName("PublisherByName");
				List<Publisher> publishers = daoI.getAllPublishers(true, true);
				model.addAttribute("allpublishers", publishers);
				model.addAttribute("currentpublisher", publisher);
				return mview;
			}else{
				mview.setViewName("AddPublisher");
				return mview;
			}
		}
	}

	@RequestMapping(value="/addauthor.add", method=RequestMethod.GET)
	public String addAuthor(Model model){
		model.addAttribute("author", new Author());
		return "AddAuthor";
	}
	
	@RequestMapping(value="/addauthor.add", method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute("author") @Valid Author author,BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "AddAuthor";
		}else{
			int primaryKey = daoI.addAuthor(author);
			if(primaryKey!=-1){
				Author addedAuthor = daoI.getAuthorById(primaryKey, true, true);
				List<Author> authors = daoI.getAllAuthors(true, true);
				model.addAttribute("allauthors", authors);
				model.addAttribute("currentauthor", addedAuthor);
				return "AuthorByName";
			}else{
				return "AddAuthor";
			}
		}
	}
	
	@RequestMapping(value="/addstore.add", method=RequestMethod.GET)
	public String addStore(Model model){
		model.addAttribute("store", new Store());
		return "AddStore";
	}
	
	@RequestMapping(value="/addstore.add", method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute("store") @Valid Store store,BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "AddStore";
		}else{
			int primaryKey = daoI.addStore(store);
			if(primaryKey!=-1){
				Store addedStore = daoI.getStoreById(primaryKey,true,true);
				List<Store> stores = daoI.getAllStores(true, true);
				model.addAttribute("allstores", stores);
				model.addAttribute("currentstore", addedStore);
				return "StoreByName";
			}else{
				return "AddStore";
			}
		}
	}
	
	@RequestMapping(value="/addbookforauthor.add", method=RequestMethod.GET)
	public String addBookForAuthor(@RequestParam("authorId") int authorId, Model model ){
		List<Book> booksList = daoI.getAllBooks(false, false, false);
		Set<Book> set = new HashSet<Book>(booksList);
		Set<Book> bookSet = daoI.getAuthorById(authorId, false, true).getAuthorBooks();
		Iterator<Book> bookIterator = bookSet.iterator();
		while(bookIterator.hasNext()) {
			set.remove(bookIterator.next());
		}
		model.addAttribute("author", daoI.getAuthorById(authorId, false, false));
		model.addAttribute("booksList", set);
		return "AddBookForAuthor";
	}
	
	@RequestMapping(value="/addbookforauthor.add", method=RequestMethod.POST)
	public ModelAndView addBookForAuthor(@RequestParam("authorId") int authorId,@RequestParam("bookId") int bookId, Model model ){
		ModelAndView modelAndView = new ModelAndView();
		boolean result = daoI.addAuthorForBook(authorId, bookId);
		if(result) {
			List<Author> authors = daoI.getAllAuthors(true, true);
			model.addAttribute("allauthors", authors);
			Author author = daoI.getAuthorById(authorId, true, true);
			model.addAttribute("currentauthor", author);
			modelAndView.setViewName("AuthorByName");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("redirect:selectauthor.edit");
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/addauthorforbook.add", method=RequestMethod.GET)
	public String addAuthorForBook(@RequestParam("bookId") int bookId, Model model ){
		List<Author> authorsList = daoI.getAllAuthors(false, false);
		Set<Author> set = new HashSet<Author>(authorsList);
		Set<Author> authorSet = daoI.getBookById(bookId, false, true, false).getBookAuthors();
		Iterator<Author> bookIterator = authorSet.iterator();
		while(bookIterator.hasNext()) {
			set.remove(bookIterator.next());
		}
		model.addAttribute("book", daoI.getBookById(bookId));
		model.addAttribute("authorsList", set);
		return "AddAuthorForBook";
	}
	
	@RequestMapping(value="/addauthorforbook.add", method=RequestMethod.POST)
	public ModelAndView addAuthorForBook(@RequestParam("authorId") int authorId,@RequestParam("bookId") int bookId, Model model ){
		ModelAndView modelAndView = new ModelAndView();
		boolean result = daoI.addAuthorForBook(authorId, bookId);
		if(result) {
			List<Book> books = daoI.getAllBooks(true, true, true);
			model.addAttribute("allbooks", books);
			Book book = daoI.getBookById(bookId, true, true, true);
			model.addAttribute("currentbook", book);
			modelAndView.setViewName("BookById");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("redirect:selectbook.edit");
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/addbookforstore.add", method=RequestMethod.GET)
	public String addBookForStore(@RequestParam("storeId") int storeId, Model model ){
		List<Book> storesList = daoI.getAllBooks();
		Set<Book> set = new HashSet<Book>(storesList);
		Set<Book> bookSet = daoI.getStoreById(storeId, true, true).getBooks();
		Iterator<Book> bookIterator = bookSet.iterator();
		while(bookIterator.hasNext()) {
			set.remove(bookIterator.next());
		}
		model.addAttribute("store", daoI.getStoreById(storeId, false, false));
		model.addAttribute("booksList", set);
		return "AddBookForStore";
	}
	
	@RequestMapping(value="/addbookforstore.add", method=RequestMethod.POST)
	public ModelAndView addBookForStore(@RequestParam("storeId") int storeId,@RequestParam("bookId") int bookId, Model model ){
		ModelAndView modelAndView = new ModelAndView();
		boolean result = daoI.addStoreForBook(storeId, bookId);
		if(result) {
			List<Store> stores = daoI.getAllStores(true, true);
			model.addAttribute("allstores", stores);
			Store store = daoI.getStoreById(storeId, true, true);
			model.addAttribute("currentstore", store);
			modelAndView.setViewName("StoreByName");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("redirect:selectstore.edit");
			return modelAndView;
		}
	}
	
}
