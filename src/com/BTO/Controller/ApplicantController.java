package src.com.BTO.Controller;

import src.com.BTO.Model.*;
import src.com.BTO.Model.Enums.*;

import src.com.BTO.Service.Filter.*;
import src.com.BTO.Service.MenuInputService;

import src.com.BTO.View.ApplicantView;
import src.com.BTO.View.ProjectView;

import src.com.BTO.Controller.ApplicantEnquiryController;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class ApplicantController {
    
	// General attributes
	private ArrayList<Project> projects = new ArrayList<Project>();
	private Applicant applicant;
	
	// Tools
	private UserSettingsController settings;
	private ApplicantEnquiryController callController;
	protected Scanner sc = new Scanner(System.in);
	protected ApplicantView applView;
	protected ProjectView projView;
	protected FilterManager filtMgr;

    // Constructor
    public ApplicantController(Applicant appl, ArrayList<Project> projs) {
    	applicant = appl;
    	projects = projs;
 
    	applView = new ApplicantView();
    	settings = new UserSettingsController(appl);
    	filtMgr = new FilterManager();
    	
    	callController = new ApplicantEnquiryController(applicant, projects);;
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

    		applView.displayOptions();
    		choice = MenuInputService.getMenuInput(sc);
    	}
    	
    	System.out.println("Exiting applicant view...\n");
    }

    protected ArrayList<Project> filterProjects() { return filterProjects(this.projects); }
    protected ArrayList<Project> filterProjects(ArrayList<Project> projs) {
    	return filtMgr.applFilterProjects(projs, applicant);
    }

    private void viewProjects() {
    	System.out.println("List of projects:");
    	
    	ArrayList<Project> filtered = filterProjects();
    	if (filtered.size() <= 0) {
    		System.out.println("No projects available.\n");
    	}
    	else {
    		for (Project proj : filtered) {
        		if (proj.getVisibility()) {
        			projView.displayProject(proj);
        		}
        	}
    	}
    }

    private void applyProject() {
    	Application applied = applicant.getApplied();
    	if (applied != null && applied.getAppStatus() != ApplicationStatus.UNSUCCESSFUL) {
        	if (applied.getReqBook()) {
        		System.out.println("Already Booked!");
        	}
        	else if (applied.getAppStatus() == ApplicationStatus.SUCCESSFUL && applied.getUnit() != null) {
        		System.out.println("Booking project...");
    			System.out.println("Would you like to make a booking? (YES = 1/ NO = 0)");
    			int choice = MenuInputService.getMenuInput(sc); 
    			
    			if (choice == 0) {
    				System.out.println("Terminating...");
    			}
    			else {
    				applied.requestBooking();
    				System.out.println("Booking requested!");
    			}
    		}
        	else {
        		System.out.println("Already applied for project!");
        	}
    	}
    	else {
    		System.out.println("Applying for project...");
        	
        	// Choose a project
        	ArrayList<Project> filtered = filterProjects();
        	
        	if (filtered.size() == 0) {
        		System.out.println("ERROR: No open projects!");
        		return;
        	}
        	
        	System.out.println("Which would you like to apply for?");
        	projView.displayProjectNames(filtered);
        	
        	int choice = MenuInputService.getMenuInput(sc);
        	Project proj = filtered.get(choice);
        	System.out.println();
        	
        	// Choose a unit
        	ArrayList<Unit> allUnits = proj.getUnitTypes();
        	
        	Unit u;
        	for (int i=0; i<allUnits.size(); i++) {
        		u = allUnits.get(i);
        		System.out.println(i + ". " + u.getRoomType());
        	}

        	choice = MenuInputService.getMenuInput(sc);
        	u = allUnits.get(choice);
        	System.out.println();
        	
        	// Create and send application
        	Application appl = new Application(proj, u, applicant);
        	// UPDATE APPLICATION IN DATABASE (CSV) YET TO DO
        	applicant.setApplied(appl);
        	System.out.println("Applied for project");
    	}
    	System.out.println();
    }

    private void viewAppliedProject() {
    	System.out.println("Viewing applied project...");
    	Application applied = applicant.getApplied();
    	if (applied == null || applied.getUnit() == null) {
    		System.out.println("ERROR: Yet to apply for project!");
    		return;
    	}

    	applView.displayAppliedProject(applied);
    }

    private void requestAppWithdrawal() {
    	System.out.println("Withdrawing from applied project...");
    	Application applied = applicant.getApplied();
    	if (applied == null || applied.getUnit() == null) {
    		System.out.println("ERROR: Yet to apply for project!\\n");
    		return;
    	}
    	
    	System.out.println("Are you sure? (YES = 1/ NO = 0)");
    	int choice = MenuInputService.getMenuInput(sc); 
    	
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
    	callController.displayOptionsController();
    }
}
