package com.projectNanuram.entity;


import java.util.List;

public class PersonWrapper {

    private List<Person> members;
    private List<Address> addresses;

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
