package com.projectNanuram.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Family {

    @Id
    @NotNull
    private String familyId;

    private int totalMembers;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "family")
    private List<Person> members = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "familyAd")
    private List<Address> addresses = new ArrayList<>();

    public Family(){}

    public Family(String familyId) {
        this.familyId = familyId;
//        this.totalMembers = totalMembers;
//        this.members = member;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public List<Person> getMember() {
        return members;
    }

    public void setMember(List<Person> members) {
        this.members = members;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyId=" + familyId +
                ", totalMembers=" + totalMembers +
                ", member=" + members +
                '}';
    }
}