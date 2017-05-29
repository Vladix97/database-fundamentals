package app.entities.ingridients;

public interface ChemicalIngredient extends Ingredient {

    String getChemicalFormula();

    void setChemicalFormula(String chemicalFormula);
}
