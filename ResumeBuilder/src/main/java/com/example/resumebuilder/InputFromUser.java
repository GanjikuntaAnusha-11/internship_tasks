package com.example.resumebuilder;
import java.util.*;

public class InputFromUser {
    public void personalDetailsInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String name = sc.nextLine();
        System.out.println("Enter your DateOfBirth: ");
        String dateOfBirth = sc.nextLine();
        System.out.println("Enter your mobileNo: ");
        String mobileNo = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Enter gmail id:");
        System.out.println("Do you have github account?");
        String ans1 = sc.nextLine();
        String githubLink = "";
        if(ans1.equalsIgnoreCase("Yes")) {
            System.out.println("Enter you github link:");
            githubLink = sc.nextLine();
        }
        System.out.println("Do you have linkedIn account?");
        String linkedInLink = "";
        String ans2 = sc.nextLine();
        if(ans2.equalsIgnoreCase("Yes")) {
            System.out.println("Enter your linkedin Link:");
            linkedInLink = sc.nextLine();
        }
        System.out.println("Enter your interests and hobbies: ");
        String interests = sc.nextLine();
        System.out.println("Enter your extracurricular activities:");
        String extracurricular = sc.nextLine();
        System.out.println("Enter your Career Objective: ");
        String objective = sc.nextLine();
    }
}
