package app.terminal;

import app.entities.ingridients.AbstractIngredient;
import app.entities.ingridients.AmmoniumChloride;
import app.entities.ingridients.Lavender;
import app.entities.ingridients.Mint;
import app.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final IngredientService ingredientService;

    @Autowired
    public Terminal(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... strings) throws Exception {
        AbstractIngredient mint = new Mint();
        AbstractIngredient lavender = new Lavender();

        AbstractIngredient chloride = new AmmoniumChloride();

        this.ingredientService.persist(mint);
        this.ingredientService.persist(lavender);
        this.ingredientService.persist(chloride);
    }
}
