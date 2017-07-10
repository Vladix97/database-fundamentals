package app.domains.entities.cameras;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractCamera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "make")
    private String make;

    @NotNull
    @Column(name = "model")
    private String model;

    @Column(name = "is_full_frame")
    private Boolean isFullFrame;

    @NotNull
    @Min(100)
    @Column(name = "min_iso")
    private Integer minISO;

    @Column(name = "max_iso")
    private Integer maxISO;

    public AbstractCamera() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getFullFrame() {
        return this.isFullFrame;
    }

    public void setFullFrame(Boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public Integer getMinISO() {
        return this.minISO;
    }

    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    public Integer getMaxISO() {
        return this.maxISO;
    }

    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getMake(), this.getModel());
    }
}
