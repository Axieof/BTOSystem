package src.com.BTO.Controller;

import src.com.BTO.Model.*;

import src.com.BTO.Service.Filter.*;
import src.com.BTO.Service.MenuInputService;

import src.com.BTO.View.ApplicantView;
import src.com.BTO.View.ProjectView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class ApplicantController {
    
	// General attributes
	private ArrayList<Project> projects = new ArrayList<Project>();
	private Applicant applicant;
	
	// Tools
	private UserSettingsController settings;

    // Constructor
    public ApplicantController(Applicant appl, ArrayList<Project> projs) {
    	applicant = appl;
    	projects = projs;
    	settings = new UserSettingsController(appl);
    }

    public void viewLandingPage() {
    	int choice = -1;
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> settings.viewLandingPage();
    		case 2-> viewProjects();
    		case 3-> applyProject();
    		case 4-> viewAppliedProject();
    		case 5-> requestAppWithdrawal();
    		case 6-> handleEnquiry();
    		}

    		ApplicantView.displayOptions();
    		choice = MenuInputService.getMenuInput();
    	}
    	
    	System.out.println("Exiting applicant view...");
    	// RETURN SOMEWHERE IF NEEDED?
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
    	HashMap<String, String> filters = applicant.getFilters();
    	// DEAL WITH FILTERS
    	
    	return filtered;
    }

    private void viewProjects() {
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

    private void applyProject() {
    	System.out.println("Applying for project...");
    	
    	Application applied = applicant.getApplied();
    	if (applied != null) {
    		System.out.println("ERROR: Can only apply for one project!");
    		return;
    	}
    	
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
    	
    	int choice = MenuInputService.getMenuInput();
    	proj = filtered.get(choice);
    	System.out.println();
    	
    	// Choose a unit
    	ArrayList<Unit> allUnits = proj.getUnitTypes();
    	
    	Unit u;
    	for (int i=0; i<allUnits.size(); i++) {
    		u = allUnits.get(i);
    		System.out.println(i + ". " + u.getRoomType());
    	}

    	choice = MenuInputService.getMenuInput();
    	u = allUnits.get(choice);
    	System.out.println();
    	
    	// Create and send application
    	Application appl = new Application(proj, u, applicant);
    	// UPDATE APPLICATION IN DATABASE (CSV) YET TO DO
    	applicant.setApplied(appl);
    	System.out.println("Applied for project!\n");
    }

    private void viewAppliedProject() {
    	System.out.println("Viewing applied project...");
    	Application applied = applicant.getApplied();
    	if (applied == null) {
    		System.out.println("ERROR: Yet to apply for project!");
    		return;
    	}

    	ApplicantView.displayAppliedProject(applied);
    }

    private void requestAppWithdrawal() {
    	System.out.println("Withdrawing from applied project...");
    	Application applied = applicant.getApplied();
    	if (applied == null) {
    		System.out.println("ERROR: Yet to apply for project!\\n");
    		return;
    	}
    	
    	System.out.println("Are you sure? (YES = 1/ NO = 0)");
    	int choice = MenuInputService.getMenuInput(); 
    	
    	if (choice == 0) {
    		System.out.println("Terminating...\n");
    	}
    	else {
    		WithdrawalApplication w = new WithdrawalApplication(applied);
    		// SAVE APPLICATION WITHDRAWAL SOMEWHERE
        	System.out.println("Sent withdrawal application!\\n");
    	}
    }

    private void handleEnquiry() {
    	// Possible things to do 
    	// SEND ENQUIRY
    	// EDIT ENQUIRY
    	// DELETE ENQUIRY
    	// GET RESPONSE TO ENQURIY
    	// MIGHT NEED FILTER TOO (answered/ unanswered)
    	
    	// MIGHT WANT TO HAVE A NEW CLASS TO HANDLE ENQUIRY
    }
}
