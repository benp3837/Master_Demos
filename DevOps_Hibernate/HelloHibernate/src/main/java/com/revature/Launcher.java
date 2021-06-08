package com.revature;

import java.util.List;

import com.revature.daos.BookDAO;
import com.revature.models.Author;
import com.revature.models.Book;

public class Launcher {

	private static BookDAO bDAO = new BookDAO();
	
	//we're going to use the main method to insert Books into our Database
	public static void main(String[] args) {
		
		//Think of the Book objects first, then make these
		//This is just to make the Book instantiation easier... 
		//but you could also just instantiate them in the Book constructors.
		Author a1 = new Author("Ben", "Petruzziello", 1998);
		Author a2 = new Author("Pen", "Betruzziello", 1889);
		
		//(Get them to call out some real books to use)
		Book b1 = new Book("CoolBook", "Fantasy", a1);
		Book b2 = new Book("OldBook", "NonFiction", a2);

		//insert our new books using the BookDAO method
		bDAO.insertBook(b1);
		bDAO.insertBook(b2);
		
		//use the findAll method of the BookDAO to populate a List of Books
		List<Book> books = bDAO.findAllBooks();
		
		//print out all the books in the List.
		for(Book b : books) {
			System.out.println(b);
		}
		
	}

}
