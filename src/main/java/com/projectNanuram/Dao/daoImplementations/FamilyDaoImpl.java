package com.projectNanuram.Dao.daoImplementations;

import com.projectNanuram.Dao.daoInterfaces.FamilyDao;
import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FamilyDaoImpl implements FamilyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Family> getAllFamilyDetails() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Family> cq = cb.createQuery(Family.class);
        Root<Family> root = cq.from(Family.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Family getFamilyById(String familyId) {

        Session session = sessionFactory.getCurrentSession();
//        Family family = session.byId(Family.class).load(familyId);
        Family family = session.byId(Family.class).load(familyId);
        return family;
    }

    @Override
//    @Transactional
    public int getTotalMemberCount(String familyId) {
        Session session = sessionFactory.getCurrentSession();
        String queryString = "select f.totalMembers from Family as f where f.familyId = :familyId";  //working
        Query query = session.createQuery(queryString);
        query.setParameter("familyId" , familyId);
        int result = (int)query.getResultList().get(0);
        return result;
    }


    @Override
//    @Transactional
    public List<Person> getMembersDetails(String familyId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select p from Person p where p.family.familyId= :familyId" ; //working
        Query query = session.createQuery(hql);
        query.setParameter("familyId" , familyId);
        List<Person> members = query.getResultList();
        return members;
    }

    @Override
//    @Transactional
    public List<Address> getFamilyAddress(String familyId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Address as ad where ad.familyAd.familyId=:familyId"; //working
        Query query = session.createQuery(hql);
        query.setParameter("familyId" , familyId);
        List<Address> addresses = query.getResultList();
        return addresses;
    }

    @Override
//    @Transactional
    public List<Family> getFamilyByAddress(String city) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select f from Family as f where f.familyId in (select ad.familyAd.familyId from Address as ad where city=:city)";
        Query query = session.createQuery(hql);
        query.setParameter("city" , city);
        List<Family> families = query.getResultList();
        return families;
    }
//
//    public Family getFamilyByAddress(Address address){
//
//       Session session = sessionFactory.getCurrentSession();
//       String hql = "";
//       Query query = session.createQuery(hql);
//       Family family = (Family) query.getSingleResult();
//       return family;
//    }

    @Override
    public Family getFamilyDetails(String personId) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select f from Family as f where f.familyId=(select p.family.familyId from Person as p where p.personId=:personId)";
        Query query = session.createQuery(hql);
        query.setParameter("personId" , personId);
        Family family = (Family)query.getSingleResult();
        return family;
    }

    @Override
    public Person getHeadOfTheFamily(String familyId) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select p from Person as p where p.family.familyId=:familyId and p.isHead=true";
        Query query = session.createQuery(hql);
        query.setParameter("familyId" , familyId);
        Person person = (Person)query.getResultList().get(0);
        return person;

    }

    @Override
//    @Transactional
    public void saveFamily(Family family) {

//        if(family != null) System.out.println(family);

//        try{
//            Session session = sessionFactory.getCurrentSession();
//            session.saveOrUpdate(family);
//        }catch (HibernateException he){
//            Session session = sessionFactory.openSession();
//            session.saveOrUpdate(family);
//        }

//        finally{
////            sessionFactory.close();
//        }

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(family);
    }

    @Override
    public Family updateFamilyDetails(String familyId) {
        return null;
    }

    @Override
    public void deleteFamily(String familyId) {

    }

}
