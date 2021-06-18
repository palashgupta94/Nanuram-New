package com.projectNanuram.service;

import com.projectNanuram.Dao.daoInterfaces.PersonDao;
import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.MobileNumbers;
import com.projectNanuram.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    @Override
    @Transactional
    public Person getPersonDetails(String personId) {
        return personDao.getPersonDetails(personId);
    }

    @Override
    public List<MobileNumbers> getMobileNumber(String personId) {
        return personDao.getMobileNumber(personId);
    }

    @Override
    public Person getPersonDetailsByMobileNumber(String mobileNumber) {
        return personDao.getPersonDetailsByMobileNumber(mobileNumber);
    }

    @Override
    public Family getFamilyDetails(String personId) {
        return personDao.getFamilyDetails(personId);
    }

    @Override
    public List<Address> getAddress(String personId) {
        return personDao.getAddress(personId);
    }

    @Override
    public List<Address> getAddressByMobileNumber(String mobileNumber) {
        return personDao.getAddressByMobileNumber(mobileNumber);
    }

    @Override
    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    @Override
    public Person updatePerson(String id) {
        return personDao.updatePerson(id);
    }

    @Override
    public void delete(String personId) {

        personDao.delete(personId);

    }
}
