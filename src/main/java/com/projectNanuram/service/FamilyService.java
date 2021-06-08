package com.projectNanuram.service;

import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;

import java.util.List;

public interface FamilyService {

//    Family getFamilyDetails();

    public List<Family> getAllFamilyDetails();

    public Family getFamilyById(String familyId);

    public int getTotalMemberCount(String familyId);

    public List<Person> getMembersDetails(String familyId);

    public List<Address> getFamilyAddress(String familyId);

//    public Family getFamilyByAddress(Address address);
    public List<Family> getFamilyByAddress(String city);


    public Family getFamilyDetails(String personId);

    public Person getHeadOfTheFamily(String familyId);

    public void saveFamily(Family family);

    public Family updateFamilyDetails(String familyId);

    public void deleteFamily(String familyId);
}
