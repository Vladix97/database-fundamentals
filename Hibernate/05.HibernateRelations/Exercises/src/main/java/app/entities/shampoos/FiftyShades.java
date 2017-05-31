package app.entities.shampoos;


import app.entities.batches.ProductionBatch;
import app.entities.enums.Size;
import app.entities.labels.ClassicLabel;

import javax.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@DiscriminatorValue(value = "FS")
public class FiftyShades extends AbstractShampoo {

    private static final String BRAND = "FiftyShades";

    private static final BigDecimal PRICE = new BigDecimal("6.69");

    private static final Size SIZE = Size.SMALL;

    private static final ClassicLabel LABEL = new ClassicLabel(
                                "Fifty Shades", "Tie the aroma");

    public FiftyShades(
            ProductionBatch batch) {
        super(BRAND, PRICE, SIZE, LABEL, batch);
    }
}
