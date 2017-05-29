package app.entities.ingridients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "LD")         // SINGE_TABLE
//@Table(name = "lavender")               // TABLE_PER_CLASS & JOINED
//@PrimaryKeyJoinColumn(name = "id")      // JOINED
public class Lavender extends AbstractIngredient {

    private static final String NAME = "Lavender";

    private static final BigDecimal PRICE = new BigDecimal("2");

    public Lavender() {
        super(NAME, PRICE);
    }
}
