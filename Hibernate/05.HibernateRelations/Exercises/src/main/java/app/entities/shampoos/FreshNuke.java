package app.entities.shampoos;


import app.entities.batches.ProductionBatch;
import app.entities.enums.Size;
import app.entities.labels.ClassicLabel;

import javax.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@DiscriminatorValue(value = "FN")
public class FreshNuke extends AbstractShampoo {

    private static final String BRAND = "FreshNuke";

    private static final BigDecimal PRICE = new BigDecimal("9.33");

    private static final Size SIZE = Size.LARGE;

    private static final ClassicLabel LABEL = new ClassicLabel(
                                "Fresh Nuke", "Explosively cool");

    public FreshNuke(
            ProductionBatch batch) {
        super(BRAND, PRICE, SIZE, LABEL, batch);
    }
}
