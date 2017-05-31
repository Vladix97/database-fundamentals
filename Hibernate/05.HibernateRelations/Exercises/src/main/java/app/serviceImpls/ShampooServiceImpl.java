package app.serviceImpls;

import app.daos.IngredientDao;
import app.daos.ShampooDao;
import app.entities.ingridients.AbstractIngredient;
import app.entities.shampoos.AbstractShampoo;
import app.services.IngredientService;
import app.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooDao shampooDao;

    @Autowired
    public ShampooServiceImpl(ShampooDao shampooDao) {
        this.shampooDao = shampooDao;
    }

    @Override
    public void persist(AbstractShampoo shampoo) {
        this.shampooDao.saveAndFlush(shampoo);
    }
}
