package com.projectNanuram.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;
import com.projectNanuram.helper.DataHelper;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class BeanProvider {

    @Bean
    public Family familyBeanProvider(){
        return new Family();
    }

    @Bean
    public DataHelper dataHelper(){ return new DataHelper(); }

    @Bean
    public ObjectMapper mapper(){ return new ObjectMapper(); }

    @Bean
    public Person personBeanProvider(){
        return new Person();
    }

//    @Bean
//    public EntityManager entityManagerProvider(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
//        EntityManager em = emf.createEntityManager();
//        return em;
//    }



}
