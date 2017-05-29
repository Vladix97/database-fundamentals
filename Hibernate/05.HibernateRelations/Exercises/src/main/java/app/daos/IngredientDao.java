package app.daos;

import app.entities.ingridients.AbstractIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngredientDao extends JpaRepository<AbstractIngredient, Long> {
}
