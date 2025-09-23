package com.example.resumebuilder;
import java.util.*;

public class Project_Internship_Experience {
    public static class Project {
        private String projectName;
        private String projectDescription;
        public String getProjectName() {
            return projectName;
        }
        public String getProjectDescription() {
            return projectDescription;
        }
        public void setProjectName(String name) {
            this.projectName = name;
        }
        public void setProjectDescription(String desc) {
            this.projectDescription = desc;
        }
        public Project(String name, String desc) {
            this.projectName = name;
            this.projectDescription = desc;
        }
        public Project(Project_Internship_Experience pid){};
    }
    public static class Internship {
        private String internshipDetails;
        public String getInternshipDetails() {
            return internshipDetails;
        }
        public void setInternshipDetails(String des) {
            this.internshipDetails = des;
        }
        public Internship(String details) {
            this.internshipDetails = details;
        }
        public Internship(Project_Internship_Experience pie){};
    }
    public static class Experience {
        private String companyName;
        private String role;
        private int years;
        private String shareExperience;
        public String getCompanyName() {
            return companyName;
        }
        public String getRole() {
            return role;
        }
        public int getYears() {
            return years;
        }
        public String getShareExperience() {
            return shareExperience;
        }
        public void setCompanyName(String name) {
            this.companyName = name;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public void setYears(int years) {
            this.years = years;
        }
        public void setShareExperience(String exp) {
            this.shareExperience = exp;
        }
        public Experience(String name, String role, int years, String exp) {
            this.companyName = name;
            this.role = role;
            this.years = years;
            this.shareExperience = exp;
        }
        public Experience(Project_Internship_Experience pie){};
    }
}
