package com.sapient.web;

import java.util.List;

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
public class EditController {
	
	@Autowired
	@Qualifier(value="daoImpl")
	private DaoI daoI;
	
	public void setDaoI(DaoI daoI) {
		this.daoI = daoI;
	}
	
	@RequestMapping(value="/edit.edit", method=RequestMethod.GET)
	public String viewedit(){
		return "EditHome";
	}

	@RequestMapping(value="/editauthor.edit", method=RequestMethod.GET)
	public String editAuthor(@RequestParam("authorId") String authorId, Model model) {
		if(authorId!=null) {
			Author author = daoI.getAuthorById(new Integer(authorId), true, true);
			if(author!=null) {
				model.addAttribute("author", author);
				return "EditAuthor";
			}
			else {
				return "redirect:selectauthor.edit";
			}
		}
		else {
			return "redirect:selectauthor.edit";
		}
	}
	
	@RequestMapping(value="/editauthor.edit", method=RequestMethod.POST)
	public ModelAndView editAuthor(@ModelAttribute Author author, @Valid Author auth,BindingResult bindingResult, Model model) {
		ModelAndView mview = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mview.setViewName("EditAuthor");
			return mview;
		}
		else {
			boolean result = daoI.editAuthor(author, true, true);
			if(result){
				ModelAndView modelView = new ModelAndView("AuthorByName");
				List<Author> authors = daoI.getAllAuthors(true, true);
				model.addAttribute("allauthors", authors);
				author = daoI.getAuthorById(author.getAuthorId(), true, true);
				model.addAttribute("currentauthor", author);
				return modelView;
			}else{
				mview.setViewName("EditAuthor");
				return mview;
			}
		}
	}
	
	@RequestMapping(value="/selectauthor.edit", method=RequestMethod.GET)
	public String selectAuthor(Model model) {
		List<Author> authorsList = daoI.getAllAuthors();
		if(authorsList!=null) {
			model.addAttribute("authorsList", authorsList);
			return "SelectAuthor";
		}else {
			return "redirect:Home";
		}
	}
	
	@RequestMapping(value="/editpublisher.edit", method=RequestMethod.GET)
	public String editpublisher(@RequestParam("publisherId") String publisherId, Model model) {
		if(publisherId!=null) {
			Publisher publisher = daoI.getPublisherById(new Integer(publisherId), true, false);
			if(publisher!=null) {
				model.addAttribute("publisher", publisher);
				return "EditPublisher";
			}
			else {
				return "redirect:selectpublisher.edit";
			}
		}
		else {
			return "redirect:selectpublisher.edit";
		}
	}
	
	@RequestMapping(value="/editpublisher.edit", method=RequestMethod.POST)
	public ModelAndView editpublisher(@ModelAttribute Publisher publisher, @Valid Publisher publish,BindingResult bindingResult, Model model) {
		ModelAndView mview = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mview.setViewName("EditPublisher");
			return mview;
		}
		else {
			boolean result = daoI.editPublisher(publisher, true, true);
			if(result){
				mview.setViewName("PublisherByName");
				List<Publisher> publishers = daoI.getAllPublishers(true, true);
				model.addAttribute("allpublishers", publishers);
				publisher = daoI.getPublisherById(publisher.getPublisherId(), true, true);
				model.addAttribute("currentpublisher", publisher);
				return mview;
			}else{
				mview.setViewName("EditAuthor");
				return mview;
			}
		}
	}
	
	@RequestMapping(value="/selectpublisher.edit", method=RequestMethod.GET)
	public String editpublisher(Model model) {
		List<Publisher> publishersList = daoI.getAllPublishers();
		if(publishersList!=null) {
			model.addAttribute("publishersList", publishersList);
			return "SelectPublisher";
		}else {
			return "redirect:Home";
		}
	}
	
	@RequestMapping(value="/editstore.edit", method=RequestMethod.GET)
	public String editstore(@RequestParam("storeId") String storeId, Model model) {
		if(storeId!=null) {
			Store store = daoI.getStoreById(new Integer(storeId), true, true);
			if(store!=null) {
				model.addAttribute("store", store);
				return "EditStore";
			}
			else {
				return "redirect:selectstore.edit";
			}
		}
		else {
			return "redirect:selectstore.edit";
		}
	}
	
	@RequestMapping(value="/editstore.edit", method=RequestMethod.POST)
	public ModelAndView viewStore(@ModelAttribute Store store, @Valid Store stor,BindingResult bindingResult, Model model) {
		ModelAndView mview = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mview.setViewName("EditStore");
			return mview;
		}
		else {
			boolean result = daoI.editStore(store, true, true);
			if(result){
				List<Store> stores = daoI.getAllStores(true, true);
				model.addAttribute("allstores", stores);
				store = daoI.getStoreById(store.getStoreId(), true, true);
				model.addAttribute("currentstore", store);
				mview.setViewName("StoreByName");
				return mview;
			}else{
				mview.setViewName("EditStore");
				return mview;
			}
		}
	}
	
	@RequestMapping(value="/selectstore.edit", method=RequestMethod.GET)
	public String selectStore(Model model) {
		List<Store> storesList = daoI.getAllStores();
		if(storesList!=null) {
			model.addAttribute("storesList", storesList);
			return "SelectStore";
		}else {
			return "redirect:Home";
		}
	}
	
	@RequestMapping(value="/editbook.edit", method=RequestMethod.GET)
	public String editBook(@RequestParam("bookId") String bookId, Model model) {
		if(bookId!=null) {
			Book book = daoI.getBookById(new Integer(bookId), true, true, true);
			List<Publisher> publishersList = daoI.getAllPublishers();
			if(book!=null && publishersList!=null) {
				model.addAttribute("book", book);
				model.addAttribute("publishersList", publishersList);
				return "EditBook";
			}
			else {
				return "redirect:selectbook.edit";
			}
		}
		else {
			return "redirect:selectbook.edit";
		}
	}
	
	@RequestMapping(value="/editbook.edit", method=RequestMethod.POST)
	public ModelAndView viewBook(@ModelAttribute Book book, @Valid Book bk,@RequestParam("publisherId") int publisherId, BindingResult bindingResult, Model model) {
		ModelAndView mview = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mview.setViewName("EditBook");
			return mview;
		}
		else {
			book.setBookPublisher(daoI.getPublisherById(publisherId, true, true));
			boolean result = daoI.editBook(book, true, false, false);
			if(result){
				List<Book> books = daoI.getAllBooks(true, true, true);
				model.addAttribute("allbooks", books);
				book = daoI.getBookById(book.getBookId(), true, true, true);
				model.addAttribute("currentbook", book);
				mview.setViewName("BookById");
				return mview;
			}else{
				mview.setViewName("EditBook");
				return mview;
			}
		}
	}
	
	@RequestMapping(value="/selectbook.edit", method=RequestMethod.GET)
	public String selectBook(Model model) {
		List<Book> booksList = daoI.getAllBooks();
		if(booksList!=null) {
			model.addAttribute("booksList", booksList);
			return "SelectBook";
		}else {
			return "redirect:Home";
		}
	}
	
}
