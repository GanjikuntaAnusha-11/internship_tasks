package com.example.resumebuilder;
import java.time.LocalDate;
import java.util.*;

public class PersonalDetails {
    private String name;
    private String dateOfBirth;
    private String mobileNo;
    private String address;
    private String gmailId;
    private String githubLink;
    private String linkedInLink;
    private String interestsAndHobbies;
    private String extracurricularActivities;
    private String careerObjective;

    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public String getAddress() {
        return address;
    }
    public String getGmailId() {
        return gmailId;
    }
    public String getGithubLink() {
        return githubLink;
    }
    public String getLinkedInLink() {
        return linkedInLink;
    }
    public String getInterestsAndHobbies() {
        return interestsAndHobbies;
    }
    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }
    public String getCareerObjective() {
        return careerObjective;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String date) {
        this.dateOfBirth = date;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setGmailId(String mail) {
        this.gmailId = mail;
    }
    public void setGithubLink(String link) {
        this.githubLink = link;
    }
    public void setLinkedInLink(String link) {
        this.linkedInLink = link;
    }
    public void setInterestsAndHobbies(String hobbies) {
        this.interestsAndHobbies = hobbies;
    }
    public void setExtracurricularActivities(String activities) {
        this.extracurricularActivities = activities;
    }
    public void setCareerObjective(String obj) {
        this.careerObjective = obj;
    }

    public PersonalDetails(){}
    public PersonalDetails(String name,String mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
    }
    public PersonalDetails(LocalDate date, String address) {
        this.dateOfBirth = date.toString();
        this.address = address;
    }
    public PersonalDetails(String link1, String link2, String link3) {
        this.gmailId = link1;
        this.githubLink = link2;
        this.linkedInLink = link3;
    }
    public PersonalDetails(String[] interestsAndActivities) {
        this.interestsAndHobbies = interestsAndActivities[0];
        this.extracurricularActivities = interestsAndActivities[1];
    }
}
