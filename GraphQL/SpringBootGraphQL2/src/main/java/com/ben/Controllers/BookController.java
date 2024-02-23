package com.ben.Controllers;

import com.ben.Exceptions.IdNoGoodException;
import com.ben.daos.AuthorDAO;
import com.ben.daos.BookDAO;
import com.ben.models.Author;
import com.ben.models.Book;
import com.ben.utils.CustomExceptionResolver;
import graphql.GraphQLError;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Controller;


import java.net.BindException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

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
    public List<Book> books() {
        return bookDAO.findAll();
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
        Author a = authorDAO.findById(authorId).get();

        return bookDAO.findByAuthor(a);

    }

    @MutationMapping
    public Book createBook(@Argument BookInput book) {

        if(book.authorId() <= 0) {
            throw new IdNoGoodException("Author ID must be greater than zero.");
        }

        if(authorDAO.findById(book.authorId()).isEmpty()) {
            throw new IdNoGoodException("Author with ID " + book.authorId() + " not found.");
        }

        Book b = new Book(book.bookId(),
                book.name(),
                book.pageCount(),
                authorController.authorById(book.authorId));

        //TODO: null checks, author ID exists check, greater-than-zero page count check, etc.

        if(bookDAO.save(b) != null) {
            return b;
        }

        return null;
    }

    //TODO: delete Book

    //Utility Methods------------------------------------------------------

    @SchemaMapping
    public Author author(Book book) {
        return authorController.authorById(book.getAuthor().getAuthorId());
    }

    @GraphQlExceptionHandler
    public GraphQLError handleIdNoGood(IdNoGoodException ex) {
        System.out.println("IdNoGoodException CAUGHT!------------------------");
        return GraphQLError.newError().errorType(ErrorType.BAD_REQUEST).message(ex.getMessage()).build();
    }
}
