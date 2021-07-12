package com.projectNanuram.controller;

import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.MobileNumbers;
import com.projectNanuram.entity.Person;
import com.projectNanuram.filesGenerator.ExcelGenerator;
import com.projectNanuram.helper.ImageHelper;
import com.projectNanuram.helper.Processor;
import com.projectNanuram.helper.PropertiesResolver;
import com.projectNanuram.helper.ReferenceHelper;
import com.projectNanuram.service.PersonService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    public static final String BLANK_IMAGE = "ina.jpg";


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
//        model.addAttribute("mobileNumber" , person.getMobileNumbers());
        return "updatePerson";

    }

    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute("person") Person person ,  Model model){

        System.out.println("person id --> "+ person.getPersonId());
        String personId1 = person.getPersonId();
        System.out.println(person.getFamily());

        List<MobileNumbers> newMobileNumberList = new ArrayList<>();
        for(MobileNumbers number : person.getMobileNumbers()) {

            if (number.getMobileNumber() != "" && number.getMobileNumber() != null) {

                newMobileNumberList.add(number);
            }
        }
            person.setMobileNumbers(newMobileNumberList);

        for(MobileNumbers mn : person.getMobileNumbers()){
            mn.setId(person.getPersonId()+person.getMobileNumbers().indexOf(mn));
            mn.setPerson(person);

        }
        if(person.getImageFile() == null){
            person.setImgUrl("ina.jpg");
        }

        personService.updatePerson(person);

        model.addAttribute("person" , person);
        return "redirect:/person/getPersonDetails/"+personId1;
    }

    @GetMapping("/getAllHeads")
    public String showHead(Model model){
        List<Person> heads = personService.getHeads();
        System.out.println(heads.size());
        String name="";
        for(Person person : heads){

            name = person.getFirstName();
            if(person.getMiddleName() != null && !person.getMiddleName().equals("")){

                name = name +" "+person.getMiddleName();

            }
            name = name +" "+person.getLastName();

            person.setFullName(name);
            person.setImgUrl(ImageHelper.getHostUrl(person.getImgUrl() , PropertiesResolver.getInstance().getImageProperties().get("family")));

        }
        model.addAttribute("heads",heads);
        return "showHeads";
    }

    @GetMapping("/showFamily/{personId}")
    public String getFamilyDetails(@PathVariable("personId") String personId , Model model){
        Family family = personService.getFamilyDetails(personId);
        System.out.println(family.getMembers().size());
        String name = "";
        for(Person person : family.getMembers()){

            name = person.getFirstName();

            if(person.getMiddleName() != null && !person.getMiddleName().equals("")){
                name = name +" "+person.getMiddleName();
            }

            name = name +" "+person.getLastName();
            person.setFullName(name);
            person.setImgUrl(ImageHelper.getHostUrl(person.getImgUrl() , PropertiesResolver.getInstance().getImageProperties().get("family")));
        }

        model.addAttribute(family);
        return "showFamily";
     }

     @PostMapping("/updatePhoto/{personId}")
//     @ResponseBody
     public String updatePhoto(@PathVariable("personId")String personId, @RequestParam("newImage") CommonsMultipartFile file){

        Person person = personService.getPersonDetails(personId);

//        System.out.println("file name ---> " +file.getOriginalFilename());

        if((file != null) && (file.getSize() > 0)) {

            Processor.imageProcessor(person, file);
            personService.savePerson(person);
        }

         return "redirect:/person/getPersonDetails/"+personId;
     }

     @PostMapping("/deletePhoto/{personId}")
     public String deletePhoto(@PathVariable("personId")String personId){

        Person person = personService.getPersonDetails(personId);

        if(!person.getImgUrl().equalsIgnoreCase(BLANK_IMAGE)) {

            String imgUrl = person.getImgUrl();
            Processor.deleteFile(imgUrl);
            person.setImgUrl("ina.jpg");
            personService.savePerson(person);
        }
         return "redirect:/person/getPersonDetails/"+personId;
     }

     @GetMapping("/exportExcel/{personId}")
     public void generateExcelFile(@PathVariable("personId") String personId , HttpServletResponse response){
        Person person = personService.getPersonDetails(personId);

        String headerKey = "Content-Disposition";
        String headerValue = "attatchment; filename=excel_"+personId+".xlsx";
        response.setHeader(headerKey , headerValue);

         ExcelGenerator excelGenerator = new ExcelGenerator("excel"+personId);
         excelGenerator.export(response , person);
     }

}
