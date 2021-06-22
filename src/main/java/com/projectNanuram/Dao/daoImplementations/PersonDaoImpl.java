package com.projectNanuram.Dao.daoImplementations;

import com.projectNanuram.Dao.daoInterfaces.PersonDao;
import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.MobileNumbers;
import com.projectNanuram.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private SessionFactory sessionFactory;

//    private EntityManager manager = sessionFactory.createEntityManager();

    @Override
    public Person getPersonDetails(String personId) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select p from Person p where p.personId=:personId";
        Query query = session.createQuery(hql);
        query.setParameter("personId" , personId);
        Person person = (Person) query.getResultList().get(0);
        return person;
    }

    @Override
    public List<MobileNumbers> getMobileNumber(String personId) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select mn from MobileNumbers as mn where mn.person.personId=:personId";
        Query query = session.createQuery(hql);
        query.setParameter("personId" , personId);
        List<MobileNumbers> mobileNumbers = query.getResultList();
        return mobileNumbers;
    }

    @Override
    public Person getPersonDetailsByMobileNumber(String mobileNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select p from Person p where p.personId=:mobileNumber";
        Query query = session.createQuery(hql);
        query.setParameter("mobileNumber" , mobileNumber);
        Person person = (Person) query.getResultList().get(0);
        return person;
    }

    @Override
    public Family getFamilyDetails(String personId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select f from Family as f where f.familyId=(select p.family.familyId from Person as p where p.personId=:personId)";
        Query query = session.createQuery(hql);
        query.setParameter("personId" , personId);
        Family family = (Family) query.getResultList().get(0);
        return family;
    }

    @Override
    public List<Address> getAddress(String personId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select ad from Address as ad where ad.familyAd.familyId=(select p.family.familyId from Person as p where p.personId=:personId)";
        Query query = session.createQuery(hql);
        query.setParameter("personId" , personId);
        List<Address> addresses = (List<Address>) query.getResultList();
        return addresses;
    }

    @Override
    public List<Address> getAddressByMobileNumber(String mobileNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select ad from Address as ad where ad.familyAd.familyId=(select p.family.familyId from Person as p where p.personId=(select mn.person.personId from MobileNumbers as mn where mn.mobileNumber=:mobileNumber))";
        Query query = session.createQuery(hql);
        query.setParameter("mobileNumber" , mobileNumber);
        List<Address> addresses = (List<Address>) query.getResultList();
        return addresses;
    }

    public List<Person> getHeads(){

        Session session = sessionFactory.getCurrentSession();
        String hql = "select p from Person as p where p.isHead=true";
        Query query = session.createQuery(hql);
        List<Person> heads = (List<Person>)query.getResultList();
        return heads;

    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
    }

    @Override
    public Person updatePerson(String id) {
        return null;
    }

    @Override
    public void delete(String PersonId) {

    }
}
