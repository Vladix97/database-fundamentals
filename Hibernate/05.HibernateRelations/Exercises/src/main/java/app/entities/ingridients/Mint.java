package app.entities.ingridients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "MT")           // SINGE_TABLE
//@Table(name = "mint")                     // TABLE_PER_CLASS & JOINED
//@PrimaryKeyJoinColumn(name = "id")        // JOINED
public class Mint extends AbstractIngredient {

    private static final String NAME = "Mint";

    private static final BigDecimal PRICE = new BigDecimal("3.54");

    public Mint() {
        super(NAME, PRICE);
    }
}
