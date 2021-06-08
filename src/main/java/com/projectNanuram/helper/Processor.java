    package com.projectNanuram.helper;

    import com.projectNanuram.entity.Address;
    import com.projectNanuram.entity.Family;
    import com.projectNanuram.entity.MobileNumbers;
    import com.projectNanuram.entity.Person;
    import org.springframework.web.multipart.commons.CommonsMultipartFile;

    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.text.ParseException;
    import java.util.ArrayList;
    import java.util.List;

    public class Processor {

        public static List<Person> personprocessor(List<Person> personList , Family family)  {

            try{
                if (personList != null) {
                    for (Person person : personList) {
                        if (person != null) {
                            int age = AgeCalculator.age(person.getDOB());
                            person.setAge(age);

                            ageProcessor(person);

                            String id = person.getPersonId();
                            if(id == null || id.isEmpty()){

                                String pId = IdentityHelper.personIdGenerator();
                                person.setPersonId(pId);
                            }

//                            if (person.getFamily() == null || person.getFamily().getFamilyId()==null || person.getFamily().getFamilyId().isEmpty())
                            person.setFamily(family);

                            List<MobileNumbers> mobileNumbersList = person.getMobileNumbers();

                            person.setMobileNumbers(mobilenumberProcessor(mobileNumbersList, person) );

                            person.setImgUrl(imageProcessor(person));

                        }

                    }

                }
            }catch (ParseException e){
                e.printStackTrace();
            }
            return personList;
        }

        private static String imageProcessor(Person person) {
            String path = null;
            try{
            CommonsMultipartFile file = person.getImageFile();
            path = "H:\\uploads\\"+file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(bytes);
            fos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return path;
        }

        private static List<MobileNumbers> mobilenumberProcessor(List<MobileNumbers> mobileNumbersList , Person person) {
            List<MobileNumbers> newlist = new ArrayList<>();
            if(!mobileNumbersList.isEmpty()){
                for (MobileNumbers number : mobileNumbersList) {
                    if (number.getMobileNumber() != null && !number.getMobileNumber().isEmpty()) {

                        if (number.getPrimaryString().equalsIgnoreCase("true")) {
                            number.setPrimary(true);
                        } else {
                            number.setPrimary(false);
                        }
                        number.setPerson(person);
                        number.setId(person.getPersonId() + mobileNumbersList.indexOf(number));
                        newlist.add(number);
                    }
                }

            }

            return newlist;

        }

        private static void ageProcessor(Person person){

            int age = person.getAge();
            if (person.getGender().equalsIgnoreCase("Male")) {

                System.out.println(person.getDOB().getClass());
                System.out.println(person.getDOB());
                if (age < 18) person.setBoy(true);
                else person.setMan(true);
                if(person.isMan() && age >= 60) person.setSenior(true);
            }

            if(person.getGender().equalsIgnoreCase("Female")){
                if (age < 18) person.setGirl(true);
                else person.setWoman(true);
                if(person.isWoman() && age >= 60) person.setSenior(true);

            }

            if(person.getStatus().equalsIgnoreCase("head")){
                person.setHead(true);
            }

        }

        public static List<Address> addressProcessor(List<Address> addressList , Family family){

            List<Address> newList = new ArrayList<>();

            if(!addressList.isEmpty()){

                for(Address address : addressList) {

                    if(!address.getFirstName().isEmpty() && (!address.getAddress1().isEmpty() || !address.getAddress2().isEmpty())){
                        address.setFamily(family);
                        newList.add(address);

                    }
                }

            }
            return newList;
        }
    }
