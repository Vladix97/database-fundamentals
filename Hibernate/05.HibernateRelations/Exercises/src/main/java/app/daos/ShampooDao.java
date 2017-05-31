package app.daos;

import app.entities.batches.Batch;
import app.entities.batches.ProductionBatch;
import app.entities.enums.Size;
import app.entities.labels.ClassicLabel;
import app.entities.labels.Label;
import app.entities.shampoos.AbstractShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ShampooDao extends JpaRepository<AbstractShampoo, Long> {

    List<AbstractShampoo> getAbstractShampooByBrand(String brand);

    List<AbstractShampoo> getAbstractShampooByBrandAndSize(String brand, Size size);

    List<AbstractShampoo> getAbstractShampooBySizeOrLabelOrderByPriceAsc(Size size, ClassicLabel label);

    List<AbstractShampoo> getAbstractShampoosByPriceIsAfterOrderByBrandDesc(BigDecimal price);

    int countAbstractShampooByPriceBefore(BigDecimal price);

    @Query(value = "SELECT s FROM AbstractShampoo AS s WHERE s.label = :label")
    List<AbstractShampoo> getShampoosByLabel(@Param(value = "label") ClassicLabel label);

    @Query(value = "SELECT s FROM AbstractShampoo AS s INNER JOIN s.ingredients AS i WHERE i.name IN :names")
    List<AbstractShampoo> getShampoosAndIngredientsIn(@Param(value = "names") String... names);

    @Query(value = "SELECT COUNT(s.id) FROM AbstractShampoo AS s GROUP BY s.id HAVING COUNT(s.id) = :n")
    List<AbstractShampoo> getShampoosWithIngredientsLessThanNumber(@Param(value = "n") long n);

    @Query(value = "SELECT s FROM AbstractShampoo AS s INNER JOIN s.batch AS b WHERE b.batchDate < :date")
    List<AbstractShampoo> getShampoosWithBatchWithDateBefore(@Param(value = "date") Date date);

    @Query(value = "SELECT s FROM AbstractShampoo AS s GROUP BY s.id HAVING COUNT(s.id) < :n")
    List<AbstractShampoo> getShampoosWithSumOfIngredientsLessThan(@Param(value = "n") long n);

    @Query(value = "SELECT s FROM AbstractShampoo AS s INNER JOIN s.label AS l WHERE s.batch = :production AND l.subtitle <> :subtitle")
    List<AbstractShampoo> getShampoosWithBatchIdAndWithDifferentLabels(
            @Param(value = "production") ProductionBatch productionBatch, @Param(value = "subtitle") String labelSubtitle);

}
