package com.projectNanuram.service;

import com.projectNanuram.Dao.daoInterfaces.FamilyDao;
import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import javax.transaction.Transactional;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyDao familyDao;

    @Override
    @Transactional
    public List<Family> getAllFamilyDetails() {
        return familyDao.getAllFamilyDetails();
    }

//    @Override
//    public Family getFamilyDetails(String personId) {
//
//       return  familyDao.getFamilyDetails(personId);
//    }

    @Transactional
    @Override
    public Family getFamilyById(String familyId) {
        return familyDao.getFamilyById(familyId);
    }

    @Override
    @Transactional
    public int getTotalMemberCount(String familyId) {
        return familyDao.getTotalMemberCount(familyId);
    }

    @Override
    @Transactional
    public List<Person> getMembersDetails(String familyId) {
        return familyDao.getMembersDetails(familyId);
    }

    @Override
    @Transactional
    public List<Address> getFamilyAddress(String familyId) {
        return familyDao.getFamilyAddress(familyId);
    }

    @Override
    @Transactional
    public List<Family> getFamilyByAddress(String city) {
        return familyDao.getFamilyByAddress(city);
    }


    @Override
    @Transactional
    public Family getFamilyDetails(String personId) {
        return familyDao.getFamilyDetails(personId);
    }

    @Override
    @Transactional
    public Person getHeadOfTheFamily(String familyId) {
        return familyDao.getHeadOfTheFamily(familyId);
    }

    @Override
    @Transactional
    public void saveFamily(Family family) {
        familyDao.saveFamily(family);
    }

    @Override
    @Transactional
    public Family updateFamilyDetails(String familyId) {
        return familyDao.updateFamilyDetails(familyId);
    }

    @Override
    @Transactional
    public void deleteFamily(String familyId) {
        familyDao.deleteFamily(familyId);
    }
}
