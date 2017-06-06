package app.serviceImpls;

import app.daos.AuthorRepository;
import app.entities.Author;
import app.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public void save(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> findByFirstNameEndingWith(String string) {
        return this.authorRepository.findByFirstNameEndingWith(string);
    }
}
