package app.services;

import app.entities.Author;

import java.util.List;

public interface AuthorService {

    Author findById(long id);

    List<Author> findAll();

    void save(Author author);
}
