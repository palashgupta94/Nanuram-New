package com.projectNanuram.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.List;

//@Transactional
@Entity

public class Person {

    private static final String COLUMN_Name = "familyId";

    @Id
    private String personId;


    @NotBlank(message = "First name could not be empty or null")
    private String firstName;

    @Nullable
    private String middleName;


    @NotNull(message = "Second name could not be empty or null")
    private String lastName;


    @NotNull(message = "Status could not be empty or null")
    private String status;


    @NotNull(message = "Relation could not be empty or null")
    private String relationWithHead;


    @NotNull(message = "Gender could not be empty or null")
    private String gender;


//    @Past (message = "Date of birth could not be empty or null")
    private String DOB;


    @NotNull(message = "Age could not be empty or null")

    private int age;

    @Nullable
    private String familyGotra;

    @Nullable
    private String motherGotra;


    @NotNull(message = "Education could not be empty or null")
    private String educationalStatus;


    @NotNull(message = "Occupation could not be empty or null")
    private String occupation;


    private String imgUrl;

    @Transient
    private CommonsMultipartFile imageFile;

    @NotNull(message = "Marital Status could not be empty or null")
    private String maritalStatus;

    @AssertFalse()
    @Transient
    private boolean isSpeciallyAble;

    @NotNull
    @Value("No")

    private String specialAbility;

    @Transient
    private String fullName;
    
    private boolean isMan;
    private boolean isWoman;
    private boolean isGirl;
    private boolean isBoy;
    private boolean isSenior;
    private boolean isHead=false;

    @OneToMany (cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "person")
    private List<MobileNumbers> mobileNumbers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = COLUMN_Name)
//    @NotNull
    private Family family;

    public Person() {
    }

    public Person(@NotNull(message = "First name could not be empty or null") String firstName,
                  @Nullable String middleName,
                  @NotNull(message = "Second name could not be empty or null") String lastName,
                  @NotNull(message = "Status could not be empty or null") String status,
                  @NotNull(message = "Relation could not be empty or null") String relationWithHead,
                  @NotNull(message = "Gender could not be empty or null") String gender,
                  @Past(message = "Date of birth could not be empty or null") String DOB, @NotNull int age,
                  @Nullable String familyGotra, @Nullable String motherGotra,
                  @NotNull(message = "Education could not be empty or null") String educationalStatus,
                  @NotNull(message = "Occupation could not be empty or null") String occupation, String imgUrl,
                  @NotNull(message = "Marital Status could not be empty or null") String maritalStatus,
                   boolean isSpeciallyAble ,
                   boolean isHead) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.status = status;
        this.relationWithHead = relationWithHead;
        this.gender = gender;
        this.DOB = DOB;
        this.age = age;
        this.familyGotra = familyGotra;
        this.motherGotra = motherGotra;
        this.educationalStatus = educationalStatus;
        this.occupation = occupation;
        this.imgUrl = imgUrl;
        this.maritalStatus = maritalStatus;
        this.isSpeciallyAble = isSpeciallyAble;
        this.isHead = isHead;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(@Nullable String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelationWithHead() {
        return relationWithHead;
    }

    public void setRelationWithHead(String relationWithHead) {
        this.relationWithHead = relationWithHead;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Nullable
    public String getFamilyGotra() {
        return familyGotra;
    }

    public void setFamilyGotra(@Nullable String familyGotra) {
        this.familyGotra = familyGotra;
    }

    @Nullable
    public String getMotherGotra() {
        return motherGotra;
    }

    public void setMotherGotra(@Nullable String motherGotra) {
        this.motherGotra = motherGotra;
    }

    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public CommonsMultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(CommonsMultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isSpeciallyAble() {
        return isSpeciallyAble;
    }

    public void setSpeciallyAble(boolean speciallyAble) {
        isSpeciallyAble = speciallyAble;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        isGirl = girl;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setBoy(boolean boy) {
        isBoy = boy;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    public List<MobileNumbers> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumbers> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                ", relationWithHead='" + relationWithHead + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                ", age=" + age +
                ", familyGotra='" + familyGotra + '\'' +
                ", motherGotra='" + motherGotra + '\'' +
                ", educationalStatus='" + educationalStatus + '\'' +
                ", occupation='" + occupation + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", isSpeciallyAble=" + isSpeciallyAble +
                ", specialAbility='" + specialAbility + '\'' +
                ", isMan=" + isMan +
                ", isWoman=" + isWoman +
                ", isGirl=" + isGirl +
                ", isBoy=" + isBoy +
                ", isSenior=" + isSenior +
                "' isHead=" + isHead +
                ", mobileNumbers=" + mobileNumbers +
                ", family=" + family +
                '}';
    }
}
