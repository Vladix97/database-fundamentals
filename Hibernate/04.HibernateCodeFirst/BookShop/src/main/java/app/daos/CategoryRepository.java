package app.daos;

import app.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByNameIn(String... categories);

    @Query(value = "SELECT c.name, SUM(b) FROM Category AS c INNER JOIN c.books AS b GROUP BY c.id")
    List<Object[]> findTotalProfitByCategory();
}
