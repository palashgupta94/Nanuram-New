package com.projectNanuram.entity;

import javax.persistence.*;

@Entity
public class Address {

    private static final String COLUMN_Name = "familyId";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private AddressType addressType;
    private String address1;
    private String address2;
    private String city;
    private String district;
    private String state;
    private int pinCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = COLUMN_Name)
    private Family familyAd;

    public Address() {
    }

    public Address(String firstName , String lastName , AddressType addressType , String address1, String address2, String city, String district, String state, int pinCode , String country) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.addressType = addressType;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public Family getFamily() {
        return familyAd;
    }

    public void setFamily(Family familyAd) {
        this.familyAd = familyAd;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
