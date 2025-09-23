package com.example.resumebuilder;

public class AcademicDetails {
    public static class TenthDetails {
        private double tenthPercentage;
        private String tenthSchoolName;
        private String tenthBoard;
        private int tenthStartYear;
        private int tenthEndYear;

        public double getTenthPercentage() {
            return tenthPercentage;
        }
        public String getTenthSchoolName() {
            return tenthSchoolName;
        }
        public String getTenthBoard() {
            return tenthBoard;
        }
        public int getTenthStartYear() {
            return tenthStartYear;
        }
        public int getTenthEndYear() {
            return tenthEndYear;
        }
        public void setTenthPercentage(double percent) {
            this.tenthPercentage = percent;
        }
        public void setTenthSchoolName(String name) {
            this.tenthSchoolName = name;
        }
        public void setTenthBoard(String board) {
            this.tenthBoard = board;
        }
        public void setTenthStartYear(int year) {
            this.tenthStartYear = year;
        }
        public void setTenthEndYear(int year) {
            this.tenthEndYear = year;
        }
        public TenthDetails(double percent, int startYear, int endYear) {
            this.tenthPercentage = percent;
            this.tenthStartYear = startYear;
            this.tenthEndYear = endYear;
        }
        public TenthDetails(String schoolName, String board) {
            this.tenthSchoolName = schoolName;
            this.tenthBoard = board;
        }
        public TenthDetails(AcademicDetails ad){};
    }
    public static class TwelfthDetails {
        private double twelfthPercentage;
        private String twelfthCollegeName;
        private String twelfthBoard;
        private int twelfthStartYear;
        private int twelfthEndYear;

        public double getTwelfthPercentage() {
            return twelfthPercentage;
        }
        public String getTwelfthCollegeName() {
            return twelfthCollegeName;
        }
        public String getTwelfthBoard() {
            return twelfthBoard;
        }
        public int getTwelfthStartYear() {
            return twelfthStartYear;
        }
        public int getTwelfthEndYear() {
            return twelfthEndYear;
        }

        public void setTwelfthPercentage(double percent) {
            this.twelfthPercentage = percent;
        }
        public void setTwelfthCollegeName(String college) {
            this.twelfthCollegeName = college;
        }
        public void setTwelfthBoard(String board) {
            this.twelfthBoard = board;
        }
        public void setTwelfthStartYear(int year) {
            this.twelfthStartYear = year;
        }
        public void setTwelfthEndYear(int year) {
            this.twelfthEndYear = year;
        }
        public TwelfthDetails(double percent, int startYear, int endYear) {
            this.twelfthPercentage = percent;
            this.twelfthStartYear = startYear;
            this.twelfthEndYear = endYear;
        }
        public TwelfthDetails(String collegeName, String board) {
            this.twelfthCollegeName = collegeName;
            this.twelfthBoard = board;
        }
        public TwelfthDetails(AcademicDetails ad){}
    }
    public static class BachelorDegreeDetails {
        private double bachelorDegreeGPA;
        private String bachelorDegreeCollegeName;
        private String bachelorDegreeCourse;
        private int bachelorDegreeStartYear;
        private int bachelorDegreeEndYear;
        public double getBachelorDegreeGPA() {
            return bachelorDegreeGPA;
        }
        public String getBachelorDegreeCollegeName() {
            return bachelorDegreeCollegeName;
        }
        public String getBachelorDegreeCourse() {
            return bachelorDegreeCourse;
        }
        public int getBachelorDegreeStartYear() {
            return bachelorDegreeStartYear;
        }
        public int getBachelorDegreeEndYear() {
            return bachelorDegreeEndYear;
        }
        public void setBachelorDegreeGPA(double gpa) {
            this.bachelorDegreeGPA = gpa;
        }
        public void setBachelorDegreeCollegeName(String college) {
            this.bachelorDegreeCollegeName = college;
        }
        public void setBachelorDegreeCourse(String course) {
            this.bachelorDegreeCourse = course;
        }
        public void setBachelorDegreeStartYear(int year) {
            this.bachelorDegreeStartYear = year;
        }
        public void setBachelorDegreeEndYear(int year) {
            this.bachelorDegreeEndYear = year;
        }
        public BachelorDegreeDetails(double gpa, int startYear, int endYear) {
            this.bachelorDegreeGPA = gpa;
            this.bachelorDegreeStartYear = startYear;
            this.bachelorDegreeEndYear = endYear;
        }
        public BachelorDegreeDetails(String college, String course) {
            this.bachelorDegreeCollegeName = college;
            this.bachelorDegreeCourse = course;
        }
        public BachelorDegreeDetails(AcademicDetails ad){}
    }
    public static class MasterDegreeDetails {
        private double masterDegreeGPA;
        private String masterDegreeCollegeName;
        private String masterDegreeCourse;
        private int masterDegreeStartYear;
        private int masterDegreeEndYear;

        public double getMasterDegreeGPA() {
            return masterDegreeGPA;
        }
        public String getMasterDegreeCollegeName() {
            return masterDegreeCollegeName;
        }
        public String getMasterDegreeCourse() {
            return masterDegreeCourse;
        }
        public int getMasterDegreeStartYear() {
            return masterDegreeStartYear;
        }
        public int getMasterDegreeEndYear() {
            return masterDegreeEndYear;
        }

        public void setMasterDegreeGPA(double gpa) {
            this.masterDegreeGPA = gpa;
        }
        public void setMasterDegreeCollegeName(String college) {
            this.masterDegreeCollegeName = college;
        }
        public void setMasterDegreeCourse(String course) {
            this.masterDegreeCourse = course;
        }
        public void setMasterDegreeStartYear(int year) {
            this.masterDegreeStartYear = year;
        }
        public void setMasterDegreeEndYear(int year) {
            this.masterDegreeEndYear = year;
        }

        public MasterDegreeDetails(double gpa, int startYear, int endYear) {
            this.masterDegreeGPA = gpa;
            this.masterDegreeStartYear = startYear;
            this.masterDegreeEndYear = endYear;
        }
        public MasterDegreeDetails(String college, String course) {
            this.masterDegreeCollegeName = college;
            this.masterDegreeCourse = course;
        }
        public MasterDegreeDetails(AcademicDetails ad){}
    }
    public AcademicDetails(){}
}
