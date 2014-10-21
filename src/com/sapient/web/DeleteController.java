package com.sapient.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.dao.DaoI;
import com.sapient.vo.Store;

@Controller
public class DeleteController {
	
	@Autowired
	@Qualifier(value="daoImpl")
	private DaoI daoI;
	
	public void setDaoI(DaoI daoI) {
		this.daoI = daoI;
	}

	@RequestMapping(value="/bookforstore.delete", method=RequestMethod.POST)
	public String deleteBookForStore(@RequestParam("bookId") String bookId, @RequestParam("storeId") String storeId, Model model){
		boolean result = daoI.deleteStoreForBook(new Integer(storeId), new Integer(bookId));
		if(result){
			List<Store> stores = daoI.getAllStores(true, true);
			model.addAttribute("allstores", stores);
			Store store = daoI.getStoreById(new Integer(storeId), true, true);
			model.addAttribute("currentstore", store);
			return "StoreByName";
		}
		else {
			if(storeId!=null) {
				Store store = daoI.getStoreById(new Integer(storeId), true, true);
				if(store!=null) {
					model.addAttribute("store", store);
					return "EditStore";
				}
				else {
					return "redirect:selectstore.edit";
				}
			}else {
				return "redirect:selectstore.edit";
			}
		}
	}
	
	@RequestMapping(value="/storeforbook.delete", method=RequestMethod.POST)
	public String deleteStoreForBook(@RequestParam("bookId") String bookId, @RequestParam("storeId") String storeId){
		return "";
	}
	
	@RequestMapping(value="/bookforauthor.delete", method=RequestMethod.POST)
	public String deleteAuthorForBook(@RequestParam("authorId") String authorId, @RequestParam("bookId") String bookId){
		boolean result = daoI.deleteAuthorForBook(new Integer(authorId), new Integer(bookId));
		if(result){
			return "Success";
		}
		return "Home";
	}
	
}
