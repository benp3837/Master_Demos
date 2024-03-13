package com.ben.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="books")
@Component
public class Book {

    @Id //This will make this variable the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String name;
    private int pageCount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "authorId")
    private Author author;

    public Book() {
    }

    public Book(String name, int pageCount, Author author) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
    }

    public Book(int bookId, String name, int pageCount, Author author) {
        this.bookId = bookId;
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthorId(Author author) {
        this.author = author;
    }
}
