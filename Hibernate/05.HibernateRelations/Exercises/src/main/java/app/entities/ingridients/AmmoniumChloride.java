package app.entities.ingridients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "AC")     // SINGLE_TABLE
//@Table(name = "ammonium_chloride")    // TABLE_PER_CLASS & JOINED
//@PrimaryKeyJoinColumn(name = "id")    // JOINED
public class AmmoniumChloride extends AbstractChemicalIngredient {

    private static final String NAME = "Ammonium Chloride";

    private static final BigDecimal PRICE = new BigDecimal("0.59");

    private static final String FORMULA = "NH4Cl";

    public AmmoniumChloride() {
        super(NAME, PRICE, FORMULA);
    }
}
