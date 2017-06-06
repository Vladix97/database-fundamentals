package app.daos;

import app.entities.Book;
import app.entities.Category;
import app.entities.enums.AgeRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    @Query(value = "SELECT b FROM Book AS b WHERE b.copies < 5000 AND b.editionType = 'GOLD'")
    List<Book> findAllGoldenEditionTypeWithLessThan5000Copies();

    @Query(value = "SELECT b FROM Book AS b WHERE b.price < 5 OR b.price > 40")
    List<Book> findAllBelow5AndAfter40Price();

    List<Book> findAllByReleaseDateNot(Date date);

    List<Book> findByCategoriesIn(Category... categories);

    List<Book> findByReleaseDateBefore(Date date);

    List<Book> findByTitleIsContaining(String string);

    @Query(value = "SELECT b FROM Book AS b INNER JOIN b.author AS a WHERE a.lastName LIKE :string")
    List<Book> findByAuthorLastNameStartingWith(@Param(value = "string") String string);

    @Query(value = "SELECT COUNT(b.id) FROM Book AS b WHERE LENGTH(b.title) > :n")
    int countByTitleLongerThat(@Param(value = "n") int n);

    @Query(value = "SELECT a, SUM(b.copies) AS copies FROM Book AS b INNER JOIN b.author AS a GROUP BY a ORDER BY copies DESC")
    List<Object[]> findAllAuthorsBySumOfCopies();

    @Query(value = "SELECT c, COUNT(b) FROM Book AS b INNER JOIN b.categories AS c GROUP BY c")
    List<Object[]> findCountOfBooksByCategory();

    List<Book> findByCategories(Category category);

    @Modifying
    @Query(value = "UPDATE Book AS b SET b.copies = b.copies + :copies WHERE b.releaseDate > :date")
    void increaseBookCopiesAfterDate(@Param(value = "date") Date date, @Param(value = "copies") int copies);
}
