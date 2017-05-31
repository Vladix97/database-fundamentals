package app.daos;

import app.entities.ingridients.AbstractIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface IngredientDao extends JpaRepository<AbstractIngredient, Long> {

    List<AbstractIngredient> getAbstractIngredientByPriceIsNullOrderByNameDesc();

    List<AbstractIngredient> getAbstractIngredientByNameStartingWith(String prefix);

    List<AbstractIngredient> getAbstractIngredientByNameIn(String... names);

    @Query(value = "SELECT i FROM AbstractIngredient AS i WHERE i.name IN :names ORDER BY i.id DESC")
    List<AbstractIngredient> getAllIngredientIn(@Param(value = "names") String... names);

    @Query(value = "SELECT i FROM AbstractIngredient AS i WHERE i.price > :price")
    List<AbstractIngredient> getAllIngredientWithPriceHigherThan(@Param(value = "price") BigDecimal price);

    @Query(value = "SELECT s.brand, i.name FROM AbstractShampoo AS s INNER JOIN s.ingredients AS i")
    List<AbstractIngredient> getAllIngredientsNamesAndShampooBrands();
}
