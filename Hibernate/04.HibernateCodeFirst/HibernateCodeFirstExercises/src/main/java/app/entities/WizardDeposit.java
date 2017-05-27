package app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wizard_deposit")
public class WizardDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    private Integer age;

    @Column(name = "magic_wand_creator", columnDefinition = "TEXT", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_want_size", columnDefinition = "SMALLINT UNSIGNED")
    private Integer magicWandSize;

    @Column(name = "deposit_group", columnDefinition = "TEXT", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date", columnDefinition = "DATETIME")
    private Date depositStartDate;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    @Column(name = "deposit_interest")
    private Double depositInterest;

    @Column(name = "deposit_charge")
    private Double depositCharge;

    @Column(name = "deposit_expiration_date")
    private Date depositExpirationDate;

    @Column(name = "is_deposit_expired")
    private Boolean isDepositExpired;

    public WizardDeposit() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return this.magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Integer getMagicWandSize() {
        return this.magicWandSize;
    }

    public void setMagicWandSize(Integer magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return this.depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public Date getDepositStartDate() {
        return this.depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public Double getDepositAmount() {
        return this.depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Double getDepositInterest() {
        return this.depositInterest;
    }

    public void setDepositInterest(Double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public Double getDepositCharge() {
        return this.depositCharge;
    }

    public void setDepositCharge(Double depositCharge) {
        this.depositCharge = depositCharge;
    }

    public Date getDepositExpirationDate() {
        return this.depositExpirationDate;
    }

    public void setDepositExpirationDate(Date depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public Boolean getDepositExpired() {
        return this.isDepositExpired;
    }

    public void setDepositExpired(Boolean depositExpired) {
        isDepositExpired = depositExpired;
    }

}
