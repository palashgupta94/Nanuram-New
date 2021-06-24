package com.projectNanuram.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class MobileNumbers {
    private static final String COLUMN_Name = "personId";

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true)
    private String id;

    @Column(name = "mobile_number" , unique = false)
    @Nullable
    @NotEmpty
    private String mobileNumber;
    @Column(name = "number_type")
    private NumberType type;
    @NotNull
    private boolean isPrimary;
    @Transient
//    @NotNull
    private String primaryString;

    @ManyToOne
    @JoinColumn(name = COLUMN_Name)
    private Person person;


    //No arg constructor
    public MobileNumbers() {

    }

    public MobileNumbers(@Nullable String mobileNumber, NumberType type, @NotNull boolean isPrimary) {
//       this.id = id;
        this.mobileNumber = mobileNumber;
        this.type = type;
        this.isPrimary = isPrimary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public NumberType getType() {
        return type;
    }

    public void setType(NumberType type) {
        this.type = type;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPrimaryString() {
        return primaryString;
    }

    public void setPrimaryString(String primaryString) {
        this.primaryString = primaryString;
    }

    @Override
    public String toString() {
        return "MobileNumbers{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", type=" + type +
                ", isPrimary=" + isPrimary +
                ", person=" + person +
                '}';
    }
}

