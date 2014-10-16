package com.sapient.client;

import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sapient.dao.DaoImpl;
import com.sapient.vo.Author;

public class ClientA {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		DaoImpl dao = (DaoImpl) ctx.getBean("daoImpl");
		List<Author> list = dao.getAllAuthors(true, true);
		System.out.println(list.get(0).getAuthorBooks().toString());
		/*Store p = dao.getStoreById(5, true, true);
		System.out.println(p.toString());
		System.out.println(p.getStoreContact());
		System.out.println(p.getBooks());*/
	}

}