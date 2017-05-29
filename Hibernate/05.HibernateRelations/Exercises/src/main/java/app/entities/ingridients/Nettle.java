package app.entities.ingridients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "NT")             // SINGE_TABLE
//@Table(name = "nettle")                     // TABLE_PER_CLASS & JOINED
//@PrimaryKeyJoinColumn(name = "id")          // JOINED
public class Nettle extends AbstractIngredient {

    private static final String NAME = "Nettle";

    private static final BigDecimal PRICE = new BigDecimal("6.12");

    public Nettle() {
        super(NAME, PRICE);
    }
}
