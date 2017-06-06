package app.daos;

import app.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(long id);

    List<Author> findAll();

    List<Author> findByFirstNameEndingWith(String string);
}
