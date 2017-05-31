package app.entities.ingridients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
//@Table(name = "abstract_chemical_ingredients") // JOINED
//@PrimaryKeyJoinColumn(name = "id")             // JOINED
public abstract class AbstractChemicalIngredient extends AbstractIngredient implements ChemicalIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    protected AbstractChemicalIngredient() {
        super();
    }

    protected AbstractChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.setChemicalFormula(chemicalFormula);
    }

    @Override
    public String getChemicalFormula() {
        return this.chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
