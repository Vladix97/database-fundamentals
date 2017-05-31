package app.entities.ingridients;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity

//InheritanceType.SINGLE_TABLE
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredient_type", discriminatorType = DiscriminatorType.STRING)


/*
//InheritanceType.TABLE_PER_CLASS
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
*/

/*
InheritanceType.JOINED
@Table(name = "abstract_ingredients")
@Inheritance(strategy = InheritanceType.JOINED)
*/
public abstract class AbstractIngredient implements Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SINGE_TABLE
//    @GeneratedValue(strategy = GenerationType.TABLE)  // TABLE_PER_CLASS
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // JOINED
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    protected AbstractIngredient() {
        super();
    }

    protected AbstractIngredient(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
