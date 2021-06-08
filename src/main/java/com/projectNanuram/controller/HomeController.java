package com.projectNanuram.controller;

import com.projectNanuram.Dao.daoInterfaces.FamilyDao;
import com.projectNanuram.entity.*;
import com.projectNanuram.helper.*;
import com.projectNanuram.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    static {
        System.out.println("Hello");
    }

    @Autowired
    private FamilyDao familyDao;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private Family family;


    @GetMapping("/showForm")
    public String showForm(Model model) {

        PersonWrapper wrapper = new PersonWrapper();

        int rowNum = (int) model.asMap().get("rowValue");
        System.out.println("rownum :" + rowNum);
        model.addAttribute(wrapper);
        model.addAttribute("rowNum", rowNum);

        model.addAttribute("rd", ReferenceHelper.referenceData());
        return "registrationForm";

    }

    @GetMapping("/showCard")
    public String getInputForLoop(Model model) {

        RowHelper helper = new RowHelper();
        Map<String , String> map = (Map<String , String>)ReferenceHelper.referenceData().get("rowMap");
        model.addAttribute("rowHelper",helper);
        model.addAttribute("rowList" , map);
        return "card";

    }

    @PostMapping("/saveCard")
    public String SaveCard(@ModelAttribute("helper") RowHelper helper, RedirectAttributes redirectAttributes) {
        System.out.println(helper.getNumberofRows());
        helper.setNumberofRows(Integer.valueOf(helper.getRows()));
        redirectAttributes.addFlashAttribute("rowValue", helper.getNumberofRows());
        return "redirect:/showForm";

    }


//

    @PostMapping("/save")
    public String save(@ModelAttribute("wrapper") PersonWrapper wrapper, Model model) {

        try {
            String familyId = wrapper.getMembers().get(0).getFamily().getFamilyId();
            if(wrapper.getMembers().get(0).getFamily() == null || wrapper.getMembers().get(0).getFamily().getFamilyId()==null
            || wrapper.getMembers().get(0).getFamily().getFamilyId().isEmpty()) {
                family.setFamilyId(IdentityHelper.familyIdGenerator());
            }
            else{
                family = wrapper.getMembers().get(0).getFamily();
            }


            List<Person> personList = wrapper.getMembers();
            List<Address> addressList = wrapper.getAddresses();

            List<Person>newPersonList = Processor.personprocessor(personList , family);
            family.setMember(newPersonList);
            family.setTotalMembers(newPersonList.size());
            family.setAddresses(Processor.addressProcessor(addressList,family));

            familyService.saveFamily(family);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";

    }

    @GetMapping("/getAllFamilies")
    public void getAllFamily(){

        List<Family> allFamily = familyService.getAllFamilyDetails();
        for(Family family : allFamily){
            System.out.println(family.getTotalMembers());
            System.out.println(family.getFamilyId());
            List<Person> members = family.getMember();

            for(Person person : members){
                System.out.println(person.getFirstName());
            }
        }

    }

    @GetMapping("/search/{familyId}")
    public void getFamilyByFamilyId(@PathVariable("familyId")String familyId){

        Family family = familyService.getFamilyById(familyId);
        System.out.println(family.getTotalMembers());

        List<Person> members = family.getMember();
        for(Person person : members){
            System.out.println(person.getFirstName());
        }

    }

    @GetMapping("/getTotalMemberCount/{familyId}")
    public void getTotalMemberCount(@PathVariable("familyId") String familyId){

        int totalCount = familyService.getTotalMemberCount(familyId);
        System.out.println("from getTotalMemberCount " + totalCount);

    }

    @GetMapping("/getMembersDetails/{familyId}")
    public void getMembersDetails(@PathVariable("familyId") String familyId){

        List<Person> personList = familyService.getMembersDetails(familyId);
        System.out.println("inside getMemberDetails : "+ personList.size());

    }

    @GetMapping("/getFamilyAddress/{familyId}")
    public void getFamilyAddress(@PathVariable("familyId") String familyId){

        List<Address> addresses = familyService.getFamilyAddress(familyId);
        System.out.println("Inside getFamilyAddress : "+ addresses.size());

    }

    @GetMapping("/getFamilyByAddress/{city}")
    public void getFamilyByAddress(@PathVariable("city") String city){

        List<Family> addresses = familyService.getFamilyByAddress(city);
        System.out.println("Inside getFamilyAddress : "+ addresses.size());

    }

    @GetMapping("/getHeadOfTheFamily/{familyId}")
    public void getHeadOfTheFamily(@PathVariable("familyId") String familyId){

        List<Family> addresses = familyService.getFamilyByAddress(familyId);
        System.out.println("Inside getFamilyAddress : "+ addresses.size());

    }

    @GetMapping("/updateFamily/{familyId}")
    public String update(@PathVariable("familyId") String familyId){



        return  null;
    }





}