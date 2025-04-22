package src.com.BTO.Controller;

import src.com.BTO.Model.*;
import src.com.BTO.Service.Filter.*;

import src.com.BTO.Model.Applicant;
import src.com.BTO.View.ApplicantView;
import src.com.BTO.View.ProjectView;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicantController {
    
	// General attributes
	private ArrayList<Project> projects = new ArrayList<Project>();
	private Applicant applicant;
	
    // Tools
    Scanner sc = new Scanner(System.in);

    // Constructor
    public ApplicantController(Applicant appl, ArrayList<Project> projs) {
    	applicant = appl;
    	projects = projs;
    }

    public void viewLandingPage() {
    	int choice = getChoice();
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> ApplicantView.displayApplicant(applicant);
    		case 2-> viewProjects();
    		case 3-> applyProject();
    		case 4-> viewAppliedProject();
    		case 5-> requestAppWithdrawal();
    		case 6-> handleEnquiry();
    		}
    		
    		choice = getChoice();
    	}
    	
    	System.out.println("Exiting applicant view...");
    	// RETURN SOMEWHERE IF NEEDED?
    }

    private int getChoice() {
    	int choice = -1;

    	ApplicantView.displayOptions();
    	choice = sc.nextInt();
    	
    	if (0 <= choice && choice <= 5) return choice;
    	else {
    		System.out.println("ERROR: Invalid choice.");
    		return -1;
    	}
    }

    private ArrayList<Project> filterProjects() { return filterProjects(this.projects); }
    private ArrayList<Project> filterProjects(ArrayList<Project> projs) {
    	ArrayList<Project> filtered;
    	
    	// FILTER THE COMPULSORY STUFF
    	
    	// THIS IS A GENERAL VISIBILITY FILTER:
    	FilterVisibility filterVis = new FilterVisibility(); 
    	filtered = filterVis.filter(projects);
    	
    	// FILTER APPLICANT'S GROUP:
    	FilterUserGroup filterGrp = new FilterUserGroup(); 
    	filterGrp.setApplicant(applicant);
    	filtered = filterGrp.filter(filtered);
    	
    	
    	// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
    	// INCOMPLETE
    	
    	return filtered;
    }

    public void viewProjects() {
    	System.out.println("List of projects:");
    	
    	ArrayList<Project> filtered = filterProjects();
    	if (filtered.size() <= 0) {
    		System.out.println("No projects available.");
    	}
    	else {
    		for (Project proj : filtered) {
        		if (proj.getVisibility()) {
        			ProjectView.displayProject(proj);
        		}
        	}
    	}
    }

    public void applyProject() {
    	System.out.println("Applying for project...");
    	
    	// CHECK IF APPLICANT ALREADY APPLIED BEFORE
    	// IF YES: RETURN ERROR MESSAGE, CAN ONLY APPLY FOR ONE
    	
    	System.out.println("Which would you like to apply for?");
    	
    	// Choose a project
    	ArrayList<Project> filtered = filterProjects();
    	
    	Project proj;
    	for (int i=0; i<filtered.size(); i++) {
    		proj = projects.get(i);
    		if (proj.getVisibility()) {
    			System.out.println(i + ". " + proj.getProjectName());
    		}
    	}
    	
    	int choice = sc.nextInt();
    	proj = filtered.get(choice);
    	System.out.println();
    	
    	// Choose a unit
    	ArrayList<Unit> allUnits = proj.getUnitTypes();
    	
    	Unit u;
    	for (int i=0; i<allUnits.size(); i++) {
    		u = allUnits.get(i);
    		System.out.println(i + ". " + u.getRoomType());
    	}

    	choice = sc.nextInt();
    	u = allUnits.get(choice);
    	System.out.println();
    	
    	// Create and send application
    	Application appl = new Application(proj, u, applicant);
    	// STORE APPLICATION IN DATABASE (CSV)
    	// STORE APPLICATION IN APPLICANT ATTRIBUTE
    }

    public void viewAppliedProject() {
    	// IF PROJECTAPPLICATION EXISTS
    	// GET PROJECTAPPLICATION FROM APPLICANT
    	// THEN VIEW
    	// ELSE RETURN HAVE NOT APPLIED FOR PROJECT
    }

    public void requestAppWithdrawal() {
    	// IF PROJECTAPPLICATION EXISTS
    	// GET PROJECTAPPLICATION FROM APPLICANT
    	// SEND WITHDRAWAL REQUEST
    	// ELSE RETURN HAVE NOT APPLIED FOR PROJECT
    }

    public void handleEnquiry() {
    	// Possible things to do 
    	// SEND ENQUIRY
    	// EDIT ENQUIRY
    	// DELETE ENQUIRY
    	// GET RESPONSE TO ENQURIY
    	// MIGHT NEED FILTER TOO (answered/ unanswered)
    	
    	// MIGHT WANT TO HAVE A NEW CLASS TO HANDLE ENQUIRY
    }
}
