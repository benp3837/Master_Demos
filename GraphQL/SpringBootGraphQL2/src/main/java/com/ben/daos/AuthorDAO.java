package com.ben.daos;

import com.ben.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer> {
}
