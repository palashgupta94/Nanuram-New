package com.projectNanuram.controller;

import com.projectNanuram.entity.Person;
import com.projectNanuram.helper.ImageHelper;
import com.projectNanuram.helper.PropertiesResolver;
import com.projectNanuram.helper.ReferenceHelper;
import com.projectNanuram.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping("/getPersonDetails/{personId}")
    public String getPersonDetails(@PathVariable("personId") String personId ,  Model model){
        Person person = personService.getPersonDetails(personId);
        String fullName = person.getFirstName();
        if(person.getMiddleName() != null && !person.getMiddleName().equals("")){
            fullName = fullName +" "+person.getMiddleName();
        }
        fullName = fullName + " " + person.getLastName();
        person.setFullName(fullName);

        person.setImgUrl(ImageHelper.getHostUrl(person.getImgUrl() , PropertiesResolver.getInstance().getImageProperties().get("person")));

        if(person.isSpeciallyAble()){
            person.setSpecialAbility("Yes");
        }
        else{
            person.setSpecialAbility("No");
        }

        System.out.println(person.getImgUrl());

        model.addAttribute(person);
        return "personProfile";
    }

    @GetMapping("/showUpdate/{personId}")
    public String showUpdate(@PathVariable("personId") String personId , Model model){

        Person person = personService.getPersonDetails(personId);
        String fullName = person.getFirstName();
        if(person.getMiddleName() != null && !person.getMiddleName().equals("")){
            fullName = fullName +" "+person.getMiddleName();
        }
        fullName = fullName + " " + person.getLastName();
        person.setFullName(fullName);

        person.setImgUrl(ImageHelper.getHostUrl(person.getImgUrl() , PropertiesResolver.getInstance().getImageProperties().get("personUpdate")));

        if(person.isSpeciallyAble()){
            person.setSpecialAbility("Yes");
        }
        else{
            person.setSpecialAbility("No");
        }

        System.out.println(person.getImgUrl());

        model.addAttribute("rd" , ReferenceHelper.referenceData());
        model.addAttribute(person);
        return "updatePerson";

    }

    @GetMapping("/updatePerson/{personId}")
    public String updatePerson(@PathVariable("personId") String personId , Model model){

        Person person = personService.updatePerson(personId);
        model.addAttribute(person);
        return "personProfile";
    }

}
