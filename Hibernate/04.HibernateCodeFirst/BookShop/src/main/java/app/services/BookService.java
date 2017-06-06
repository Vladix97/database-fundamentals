package app.services;

import app.entities.Book;
import app.entities.Category;
import app.entities.enums.AgeRestriction;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookService {

    void save(Book book);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllGoldenEditionTypeWithLessThan5000Copies();

    List<Book> findAllBelow5AndAfter40Price();

    List<Book> findAllByReleaseDateNot(Date date);

    List<Book> findByCategoriesIn(Category... categories);

    List<Book> findByReleaseDateBefore(Date date);

    List<Book> findByTitleIsContaining(String string);

    List<Book> findByAuthorLastNameStartingWith(String string);

    int countByTitleLongerThat(int n);

    List<Object[]> findAllAuthorsBySumOfCopies();

    List<Object[]> findCountOfBooksByCategory();

    List<Book> findByCategory(Category category);

    void increaseBookCopiesAfterDate(Date date, int copies);
}
