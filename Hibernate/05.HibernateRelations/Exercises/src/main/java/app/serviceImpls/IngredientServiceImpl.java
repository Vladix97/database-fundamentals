package app.serviceImpls;

import app.daos.IngredientDao;
import app.entities.ingridients.AbstractIngredient;
import app.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientDao ingredientDao;

    @Autowired
    public IngredientServiceImpl(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Override
    public void persist(AbstractIngredient ingredient) {
        this.ingredientDao.saveAndFlush(ingredient);
    }
}
