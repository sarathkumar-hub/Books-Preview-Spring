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

import com.sapient.dao.DaoI;
import com.sapient.vo.Author;
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

	@RequestMapping(value="/editAuthor.edit", method=RequestMethod.GET)
	public String editAuthor(@RequestParam("authorId") String authorId, Model model) {
		if(authorId!=null) {
			Author author = daoI.getAuthorById(new Integer(authorId), true, false);
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
	
	@RequestMapping(value="/editAuthor.edit", method=RequestMethod.POST)
	public String editAuthor(@ModelAttribute Author author, @Valid Author auth,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "EditAuthor";
		}
		else {
			return "Success";
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
	
	@RequestMapping(value="/editPublisher.edit", method=RequestMethod.GET)
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
	
	@RequestMapping(value="/editPublisher.edit", method=RequestMethod.POST)
	public String editpublisher(@ModelAttribute Publisher publisher, @Valid Publisher publish,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "EditPublisher";
		}
		else {
			return "Success";
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
	public String viewStore(@ModelAttribute Store store, @Valid Store stor,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "EditStore";
		}
		else {
			return "Success";
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
	
}
