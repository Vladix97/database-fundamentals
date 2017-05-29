package app.services;

import app.entities.ingridients.AbstractIngredient;

public interface IngredientService {

    void persist(AbstractIngredient ingredient);
}
