package com.projectNanuram.helper;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.Set;
import java.util.TreeSet;

public class IdentityHelper {

    static Set<String> personIdSet = new TreeSet<>();
    static Set<String> familyIdSet = new TreeSet<>();

    static int personCount = 5;
    static int familyCount = 5;
    static boolean letters = true;
    static boolean numbers = true;

    public static String personIdGenerator(){

        String personId = RandomStringUtils.random(personCount , letters , numbers);

        if(personIdSet.contains(personId)){
            personIdGenerator();
        }
        else{
            personIdSet.add(personId);

        }
        return personId;
    }

    public static String familyIdGenerator(){

        String familyId = RandomStringUtils.random(familyCount , letters , numbers);

        if(familyIdSet.contains(familyId)){
            familyIdGenerator();
        }
        else{
            familyIdSet.add(familyId);
        }

        return familyId;
    }



}
