package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Author;
import com.revature.utils.HibernateUtil;

public class AuthorDAO {

	public void insertAuthor(Author author) {
		
		//Open a Session object to establish a database connection.
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC!
		ses.save(author); //Refer to the notes - this is one Session method for insert operations
		HibernateUtil.closeSession(); //close our session
		
	}
	
	
	public void updateAuthor(Author author) {
		
		Session ses = HibernateUtil.getSession();
		ses.merge(author); //this will update the entire author
			
		//update would throw an error if the author object already existed in Hibernate's cache
		//hence why we say merge is safer
	}
	
	
	public Author selectAuthorById(int id) {
		
		Session ses = HibernateUtil.getSession();
		Author author = ses.get(Author.class, id);	
		return author;
		
	}
	
	
	public List<Author> findAllAuthors(){
		
		Session ses = HibernateUtil.getSession();
		List<Author> authorList = ses.createQuery("FROM Author").list();
		return authorList;
		
	}
	
}
