package com.ben.daos;

import com.ben.models.Author;
import com.ben.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {

    List<Book> findByAuthor(Author author);

}
