package com.revature;

import java.util.List;

import com.revature.daos.AuthorDAO;
import com.revature.daos.BookDAO;
import com.revature.models.Author;
import com.revature.models.Book;

//changes made since the original HelloHibernate:
	//changed FetchType for Author from LAZY to EAGER (found in models.Book). 
	//added a field in Author to reference Books with a OneTOMany relationship (found in models.Author) 
		//thus, we had to change the boilerplate code and the Author constructor in the Launcher
	//created the AuthorDAO
	//fixed the infinite loop by changing the toString() method in Book.
	//did some more experiments in the Launcher
	

public class Launcher {

	private static BookDAO bDAO = new BookDAO();
	private static AuthorDAO aDAO = new AuthorDAO();

	public static void main(String[] args) {
		

		Author a1 = new Author("Ben", "Petruzziello", 1998, null);
		Author a2 = new Author("Pen", "Betruzziello", 1889, null);
		//why null? It'll get populated once we attach books to an Author! Upon Book creation.
		

		Book b1 = new Book("CoolBook", "Fantasy", a1);
		Book b2 = new Book("OldBook", "NonFiction", a2);

		//insert our new books using the BookDAO method
		bDAO.insertBook(b1);
		bDAO.insertBook(b2);
		
		//use the findAll method of the BookDAO to populate a List of Books
		List<Book> books = bDAO.findAllBooks();
		
		Author a3 = new Author("Bon", "Potruzziello", 1700, null);
		
		aDAO.insertAuthor(a3);
		
		//print out all the books in the List.
		for(Book b : books) {
			System.out.println(b);
		}
		
		List<Author> authors = aDAO.findAllAuthors();
		
		for(Author a : authors) {
			System.out.println(a);
		}
		
		System.out.println(aDAO.selectAuthorById(3));
		
	}

}
