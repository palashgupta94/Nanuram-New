package com.projectNanuram.service;

import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.MobileNumbers;
import com.projectNanuram.entity.Person;

import java.util.List;

public interface PersonService {

    public Person getPersonDetails(String personId);

    public List<MobileNumbers> getMobileNumber(String personId);

    public Person getPersonDetailsByMobileNumber(String mobileNumber);

    public Family getFamilyDetails(String personId);

    public List<Address> getAddress(String personId);

    public List<Address> getAddressByMobileNumber(String mobileNumber);

    public void savePerson(Person person);

    public Person updatePerson(String id);

    public void delete(String PersonId);

    public List<Person> getHeads();
}
