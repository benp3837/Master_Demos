package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Book;
import com.revature.utils.HibernateUtil;

public class BookDAO {
	
	//we're going to have a bunch of DAO methods that incorporate Session methods
	//read up on the session methods in the notes to understand what's going on and what our options are
	
	public void insertBook(Book book) {
		
		//Open a Session object to establish a database connection.
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC!
		
		ses.save(book); //Refer to the notes - this is one Session method for insert operations
		HibernateUtil.closeSession(); //close our session
		
		//THAT'S THE WHOLE INSERT METHOD!!
		//DAO methods are so much cleaner with Hibernate than JDBC
	}
	
	
	public void updateBook(Book book) {
		
		Session ses = HibernateUtil.getSession();
		
		//anyone remember what methods I can use to update? We have update, but we also have...
		ses.merge(book); //this will update the entire book
			
		//update would throw an error if the book object already existed in Hibernate's cache
		//hence why we say merge is safer
	}
	
	
	public Book selectBookById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Book book = ses.get(Book.class, id);
		
		return book;
	}
	
	
	public List<Book> findAllBooks(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language. Remember, it references the Java Class.
		//e.g. "Book" in our models package, instead of "books" in our database entities.
		List<Book> bookList = ses.createQuery("FROM Book").list();
		//BTW, this warning is complaining about the version type, it wants me to specify a generic but it's not necessary.
		//Would probably need to cast it, not sure cause it's not important lol
		
		return bookList;
	}
	
	
	//aren't all of these methods massively easier than JDBC?
	
	
}
