package com.ben.Controllers;

import com.ben.Exceptions.IdNoGoodException;
import com.ben.daos.AuthorDAO;
import com.ben.daos.BookDAO;
import com.ben.models.Author;
import com.ben.models.Book;
import graphql.GraphQLError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class BookController {

    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;
    private final AuthorController authorController;

    @Autowired
    public BookController(BookDAO bookDAO, AuthorDAO authorDAO, AuthorController authorController) {
        this.bookDAO = bookDAO;
        this.authorController = authorController;
        this.authorDAO = authorDAO;
    }

    record BookInput(int bookId, String name, int pageCount, int authorId) { }

    public String hi() {
        return "hi";
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @QueryMapping int numberOfBooks(){
        return bookDAO.findAll().size();
    }

    @QueryMapping
    public Object bookById(@Argument int bookId) {
        try {
            Book b = bookDAO.findById(bookId).get();
            return b;
        }
        catch (NoSuchElementException e) {
            throw new IdNoGoodException("Book with ID " + bookId + " not found.");
        }
    }

    @QueryMapping
    public List<Book> booksByAuthorId(@Argument int authorId) {

        if(authorDAO.findById(authorId).isEmpty()) {
            throw new IdNoGoodException("Author with ID " + authorId + " not found.");
        }

        Author a = authorDAO.findById(authorId).get();

        return bookDAO.findByAuthor(a);

    }

    @MutationMapping
    public Book createBook(@Argument BookInput bookInput) {

        if(bookInput.authorId() <= 0) {
            throw new IdNoGoodException("Author ID must be greater than zero.");
        }

        if(authorDAO.findById(bookInput.authorId()).isEmpty()) {
            throw new IdNoGoodException("Author with ID " + bookInput.authorId() + " not found.");
        }

        Book b = new Book(bookInput.bookId(),
                bookInput.name(),
                bookInput.pageCount(),
                authorController.authorById(bookInput.authorId));

        //TODO: null checks, author ID exists check, greater-than-zero page count check, etc.

        if(bookDAO.save(b) != null) {
            return b;
        }

        return null;
    }

    @MutationMapping
    public Object deleteBook(@Argument int bookId) {
        try {
            Book b = bookDAO.findById(bookId).get();
            System.out.println("BOOOOOOOOK: " + b);
            bookDAO.delete(b);
            return b;
        }
        catch (NoSuchElementException e) {
            throw new IdNoGoodException("Book with ID " + bookId + " not found.");
        }
    }

    //Utility Methods------------------------------------------------------

    //This maps Authors to books. When a Book requires an Author, this will be called automatically.
    @SchemaMapping
    public Author author(Book book) {
        return authorController.authorById(book.getAuthor().getAuthorId());
    }

    //We can handle and send back errors in this way.
    //This can get rather bloated... Consider a dedicated Exception handling class in the utils package.
    @GraphQlExceptionHandler
    public GraphQLError handleIdNoGood(IdNoGoodException ex) {
        System.out.println("IdNoGoodException CAUGHT!------------------------");
        return GraphQLError.newError().errorType(ErrorType.BAD_REQUEST).message(ex.getMessage()).build();
    }
}
