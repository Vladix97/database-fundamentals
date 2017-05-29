package app.entities.ingridients;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Ingredient extends Serializable {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);
}
