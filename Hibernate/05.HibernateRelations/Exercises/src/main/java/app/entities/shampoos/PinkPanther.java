package app.entities.shampoos;


import app.entities.batches.ProductionBatch;
import app.entities.enums.Size;
import app.entities.labels.ClassicLabel;

import javax.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@DiscriminatorValue(value = "PP")
public class PinkPanther extends AbstractShampoo {

    private static final String BRAND = "PinkPanther";

    private static final BigDecimal PRICE = new BigDecimal("8.50");

    private static final Size SIZE = Size.MEDIUM;

    private static final ClassicLabel LABEL = new ClassicLabel(
                                "Pink Panther", "Pleasure in pink");

    public PinkPanther(
            ProductionBatch batch) {
        super(BRAND, PRICE, SIZE, LABEL, batch);
    }
}
