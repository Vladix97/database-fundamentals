package app.entities.batches;

import app.entities.shampoos.AbstractShampoo;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bathes")
public class ProductionBatch implements Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "batch_date")
    private Date batchDate;

    @OneToMany(mappedBy = "id", targetEntity = AbstractShampoo.class)
    private Set<AbstractShampoo> shampoos;

    public ProductionBatch() {
        super();
        this.setShampoos(new HashSet<>());
    }

    public ProductionBatch(Date batchDate) {
        this();
        this.batchDate = batchDate;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Date getBatchDate() {
        return this.batchDate;
    }

    @Override
    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    @Override
    public Set<AbstractShampoo> getShampoos() {
        return this.shampoos;
    }

    @Override
    public void setShampoos(Set<AbstractShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
