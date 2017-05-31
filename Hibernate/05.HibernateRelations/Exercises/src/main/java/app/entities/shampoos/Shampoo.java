package app.entities.shampoos;

import app.entities.batches.ProductionBatch;
import app.entities.enums.Size;
import app.entities.ingridients.AbstractIngredient;
import app.entities.labels.ClassicLabel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo extends Serializable {

    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    ClassicLabel getLabel();

    void setLabel(ClassicLabel label);

    ProductionBatch getBatch();

    void setBatch(ProductionBatch batch);

    Set<AbstractIngredient> getIngredients();

    void setIngredients(Set<AbstractIngredient> ingredients);
}
