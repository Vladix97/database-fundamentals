package app.entities.ingridients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "SB")                 // SINGE_TABLE
//@Table(name = "strawberry")                     // TABLE_PER_CLASS & JOINED
//@PrimaryKeyJoinColumn(name = "id")              // JOINED
public class Strawberry extends AbstractIngredient {

    private static final String NAME = "Strawberry";

    private static final BigDecimal PRICE = new BigDecimal("4.85");

    public Strawberry() {
        super(NAME, PRICE);
    }
}
