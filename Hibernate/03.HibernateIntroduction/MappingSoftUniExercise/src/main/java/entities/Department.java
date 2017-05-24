package entities;

import javax.persistence.*;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Basic
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public Department() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

}
