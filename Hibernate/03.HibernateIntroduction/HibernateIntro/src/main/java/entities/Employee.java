package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by vladix on 5/24/17.
 */
@Entity
@Table(name = "employees", schema = "soft_uni", catalog = "")
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String jobTitle;
    private Timestamp hireDate;
    private BigDecimal salary;
    private Department departmentsByDepartmentId;
    private Employee employeesByManagerId;
    private Address addressesByAddressId;

    @Id
    @Column(name = "employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "job_title")
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "hire_date")
    public Timestamp getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "salary")
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (middleName != null ? !middleName.equals(employee.middleName) : employee.middleName != null) return false;
        if (jobTitle != null ? !jobTitle.equals(employee.jobTitle) : employee.jobTitle != null) return false;
        if (hireDate != null ? !hireDate.equals(employee.hireDate) : employee.hireDate != null) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public Department getDepartmentsByDepartmentId() {
        return this.departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Department departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    public Employee getEmployeesByManagerId() {
        return this.employeesByManagerId;
    }

    public void setEmployeesByManagerId(Employee employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddressesByAddressId() {
        return this.addressesByAddressId;
    }

    public void setAddressesByAddressId(Address addressesByAddressId) {
        this.addressesByAddressId = addressesByAddressId;
    }
}
