package entities;

import javax.persistence.*;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "employees_projects", schema = "soft_uni", catalog = "")
@IdClass(EmployeesProjectsPK.class)
public class EmployeesProjects {
    private Integer employeeId;
    private Integer projectId;
    private Employee employeesByEmployeeId;

    @Id
    @Column(name = "employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "project_id")
    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesProjects that = (EmployeesProjects) o;

        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
//    public Employee getEmployeesByEmployeeId() {
//        return this.employeesByEmployeeId;
//    }
//
//    public void setEmployeesByEmployeeId(Employee employeesByEmployeeId) {
//        this.employeesByEmployeeId = employeesByEmployeeId;
//    }
}
