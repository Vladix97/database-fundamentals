package app.serviceImpls;

import app.daos.BookRepository;
import app.entities.Book;
import app.entities.Category;
import app.entities.enums.AgeRestriction;
import app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> findByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findAllGoldenEditionTypeWithLessThan5000Copies() {
        return this.bookRepository.findAllGoldenEditionTypeWithLessThan5000Copies();
    }

    @Override
    public List<Book> findAllBelow5AndAfter40Price() {
        return this.bookRepository.findAllBelow5AndAfter40Price();
    }

    @Override
    public List<Book> findAllByReleaseDateNot(Date date) {
        return this.bookRepository.findAllByReleaseDateNot(date);
    }

    @Override
    public List<Book> findByCategoriesIn(Category... categories) {
        return this.bookRepository.findByCategoriesIn(categories);
    }

    @Override
    public List<Book> findByReleaseDateBefore(Date date) {
        return this.bookRepository.findByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findByTitleIsContaining(String string) {
        return this.bookRepository.findByTitleIsContaining(string);
    }

    @Override
    public List<Book> findByAuthorLastNameStartingWith(String string) {
        return this.bookRepository.findByAuthorLastNameStartingWith(string);
    }

    @Override
    public int countByTitleLongerThat(int n) {
        return this.bookRepository.countByTitleLongerThat(n);
    }

    @Override
    public List<Object[]> findAllAuthorsBySumOfCopies() {
        return this.bookRepository.findAllAuthorsBySumOfCopies();
    }

    @Override
    public List<Object[]> findCountOfBooksByCategory() {
        return this.bookRepository.findCountOfBooksByCategory();
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return this.bookRepository.findByCategories(category);
    }

    public void increaseBookCopiesAfterDate(Date date, int copies) {
        this.bookRepository.increaseBookCopiesAfterDate(date, copies);
    }
}
