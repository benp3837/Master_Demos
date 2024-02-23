package com.ben.Controllers;

import com.ben.daos.AuthorDAO;
import com.ben.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorDAO aDAO;

    @Autowired
    public AuthorController(AuthorDAO aDAO) {
        this.aDAO = aDAO;
    }

    record AuthorInput(int authorId, String firstName, String lastName) { }

    @QueryMapping
    public Author authorById(@Argument int id) {

        return aDAO.findById(id).get();
    }

    @QueryMapping
    public List<Author> authors() {
        return aDAO.findAll();
    }

    @MutationMapping
    public Author createAuthor(@Argument AuthorInput author) {
        Author a = new Author(author.authorId(), author.firstName(), author.lastName());

        if(aDAO.save(a) != null) {
            return a;
        }

        return null;
    }

    //TODO: just a thought, the FRONT END is responsible for differentiating update from add. Secure accordingly.
    @MutationMapping
    public Author updateAuthor(@Argument AuthorInput author) {
        Author a = new Author(author.authorId(), author.firstName(), author.lastName());

        if(aDAO.save(a) != null) {
            return a;
        }

        return null;
    }

}
