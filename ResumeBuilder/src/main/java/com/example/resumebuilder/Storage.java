package com.example.resumebuilder;
import java.util.*;

public class Storage {
    List<List<String>> personalDetails = new ArrayList<>();
    List<List<String>> tenthAcademicDetails = new ArrayList<>();
    List<List<String>> twelfthAcademicDetails = new ArrayList<>();
    List<List<String>> degreeAcademicDetails = new ArrayList<>();
    List<List<String>> mastersAcademicDetails = new ArrayList<>();
    List<List<String>> project_details = new ArrayList<>();
    List<List<String>> internship_details = new ArrayList<>();
    List<List<String>> experience_details = new ArrayList<>();
    public void addPersonalDetails() {
        PersonalDetails pd = new PersonalDetails();
        List<String> list = new ArrayList<>();
        list.add(pd.getName());
        list.add(pd.getDateOfBirth());
        list.add(pd.getMobileNo());
        list.add(pd.getGmailId());
        list.add(pd.getAddress());
        list.add(pd.getCareerObjective());
        if(!pd.getGithubLink().isEmpty()) {
            list.add(pd.getGithubLink());
        }
        if(!pd.getLinkedInLink().isEmpty()) {
            list.add(pd.getLinkedInLink());
        }
        list.add(pd.getExtracurricularActivities());
        list.add(pd.getInterestsAndHobbies());
        personalDetails.add(list);
    }
    public void addTenthAcademicDetails() {
        AcademicDetails ad = new AcademicDetails();
        AcademicDetails.TenthDetails td = new AcademicDetails.TenthDetails(ad);
        List<String> list = new ArrayList<>();
        list.add(Double.toString(td.getTenthPercentage()));
        list.add(td.getTenthSchoolName());
        list.add(td.getTenthBoard());
        list.add(Integer.toString(td.getTenthStartYear()));
        list.add(Integer.toString(td.getTenthEndYear()));
        tenthAcademicDetails.add(list);
    }
    public void addTwelfthAcademicDetails() {
        AcademicDetails ad = new AcademicDetails();
        AcademicDetails.TwelfthDetails twd = new AcademicDetails.TwelfthDetails(ad);
        List<String> list = new ArrayList<>();
        list.add(Double.toString(twd.getTwelfthPercentage()));
        list.add(twd.getTwelfthCollegeName());
        list.add(twd.getTwelfthBoard());
        list.add(Integer.toString(twd.getTwelfthStartYear()));
        list.add(Integer.toString(twd.getTwelfthEndYear()));
        twelfthAcademicDetails.add(list);
    }
    public void addBachelorDegreeDetails() {
        AcademicDetails ad = new AcademicDetails();
        AcademicDetails.BachelorDegreeDetails bd = new AcademicDetails.BachelorDegreeDetails(ad);
        List<String> list = new ArrayList<>();
        list.add(Double.toString(bd.getBachelorDegreeGPA()));
        list.add(bd.getBachelorDegreeCollegeName());
        list.add(bd.getBachelorDegreeCourse());
        list.add(Integer.toString(bd.getBachelorDegreeStartYear()));
        list.add(Integer.toString(bd.getBachelorDegreeEndYear()));
        degreeAcademicDetails.add(list);
    }
    public void addMasterDegreeDetails() {
        AcademicDetails ad = new AcademicDetails();
        AcademicDetails.MasterDegreeDetails md = new AcademicDetails.MasterDegreeDetails(ad);
        List<String> list = new ArrayList<>();
        list.add(Double.toString(md.getMasterDegreeGPA()));
        list.add(md.getMasterDegreeCollegeName());
        list.add(md.getMasterDegreeCourse());
        list.add(Integer.toString(md.getMasterDegreeStartYear()));
        list.add(Integer.toString(md.getMasterDegreeEndYear()));
        mastersAcademicDetails.add(list);
    }
    public void addProjectDetails() {
        Project_Internship_Experience pie = new Project_Internship_Experience();
        Project_Internship_Experience.Project pieP = new Project_Internship_Experience.Project(pie);
        List<String> list1 = new ArrayList<>();
        list1.add(pieP.getProjectName());
        list1.add(pieP.getProjectDescription());
        project_details.add(list1);
    }
    public void addInternshipDetails() {
        Project_Internship_Experience pie = new Project_Internship_Experience();
        Project_Internship_Experience.Internship pieI = new Project_Internship_Experience.Internship(pie);
        List<String> list = new ArrayList<>();
        list.add(pieI.getInternshipDetails());
        internship_details.add(list);
    }
    public void addExperienceDetails() {
        Project_Internship_Experience pie = new Project_Internship_Experience();
        Project_Internship_Experience.Experience pieE = new Project_Internship_Experience.Experience(pie);
        List<String> list = new ArrayList<>();
        list.add(pieE.getCompanyName());
        list.add(pieE.getRole());
        list.add(pieE.getShareExperience());
        list.add(Integer.toString(pieE.getYears()));
        experience_details.add(list);
    }
}
