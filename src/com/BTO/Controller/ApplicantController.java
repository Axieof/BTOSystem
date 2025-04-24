package src.com.BTO.Controller;

import src.com.BTO.Model.*;
import src.com.BTO.Model.Enums.*;

import src.com.BTO.Service.Filter.*;
import src.com.BTO.Service.MenuInputService;

import src.com.BTO.View.ApplicantView;
import src.com.BTO.View.ProjectView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ApplicantController {
    
	// General attributes
	private ArrayList<Project> projects = new ArrayList<Project>();
	private Applicant applicant;
	protected ArrayList<Application> applications;
	
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
    	applications = new ArrayList<>(); // SHOULD BE PASSED IN FROM CALLER
 
    	applView = new ApplicantView();
    	projView = new ProjectView();
    	settings = new UserSettingsController(appl);
    	filtMgr = new FilterManager();
    	
    	callController = new ApplicantEnquiryController(applicant, projects);;
    }

    public void viewLandingPage() {
		applView.displayOptions();
    	int choice = MenuInputService.getMenuInput(sc);;
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> settings.viewLandingPage();
    		case 2-> viewProjects();
    		case 3-> applyProject();
    		case 4-> viewAppliedProject();
    		case 5-> requestAppWithdrawal();
    		case 6-> handleEnquiry();
    		default -> System.out.println("ERROR: Choice out of range!");
    		}

    		applView.displayOptions();
    		choice = MenuInputService.getMenuInput(sc);
    	}
    	
    	System.out.println("Exiting applicant view...\n");
    	// SHOULD RETURN ALL NECESSARY ITEMS? UNLESS ALREADY MUTABLE ITEMS
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
    		for (Project proj : filtered) projView.displayProject(proj);
    	}
    }

    private void applyProject() {
    	Application applied = applicant.getApplied();
    	if (applied != null && applied.getAppStatus() != ApplicationStatus.UNSUCCESSFUL) {
    		
    		if (applied.getAppStatus() == ApplicationStatus.BOOKED) System.out.println("Already Booked!");
    		else if (applied.getAppStatus() == ApplicationStatus.REQBOOKING) System.out.println("Already requested booking!");
    		else if (applied.getAppStatus() == ApplicationStatus.REQWITHDRAWAL) System.out.println("Wait for withdrawal approval!");
    		else if (applied.getAppStatus() == ApplicationStatus.SUCWITHDRAWAL) System.out.println("Withdrawal approved! Go to 'withdraw application' function.");
        	
    		else if (applied.getAppStatus() == ApplicationStatus.SUCCESSFUL) {
        		System.out.println("Booking project...");
        		
        		if (applicant instanceof HDBOfficer) {
        			if (((HDBOfficer) applicant).getCurrProj().getID() == applied.getProject().getID()) {
        				System.out.println("ERROR: Cannot apply for project as officer of project!");
        				System.out.println("Terminating...\n");
        				return;
        			}
        		}
    			System.out.println("Would you like to make a booking? (YES = 1/ NO = 0)");
    			int choice = MenuInputService.getMenuInput(sc); 
    			
    			if (choice == 1) {
    				applied.setAppStatus(ApplicationStatus.REQBOOKING);
    				System.out.println("Booking requested!");
    			}
    			else System.out.println("Terminating...\n");
    		}
        	else System.out.println("Already applied for project!\n");
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
        	
        	Project proj = null;
        	try {
        		proj = filtered.get(choice);
        	}
        	catch(Exception e) {
        		System.out.println("ERROR: Invalid value!\n");
        		return;
        	}
        	System.out.println();
        	
        	if (applicant instanceof HDBOfficer) {
    			if (((HDBOfficer) applicant).getCurrProj().getID() == proj.getID()) {
    				System.out.println("ERROR: Cannot apply for project as officer of project!");
    				System.out.println("Terminating...\n");
    				return;
    			}
    		}
        	
        	// Choose a unit
        	ArrayList<Unit> allUnits = proj.getUnitTypes();
        	
        	Unit u;
        	for (int i=0; i<allUnits.size(); i++) {
        		u = allUnits.get(i);
        		System.out.println(i + ". " + u.getRoomType());
        	}

        	choice = MenuInputService.getMenuInput(sc);
        	
        	try {
        		u = allUnits.get(choice);
        	}
        	catch(Exception e) {
        		System.out.println("ERROR: Invalid value!");
        		return;
        	}
        	
        	System.out.println();
        	
        	// Create and send application
        	Application appl = new Application(proj, u, applicant);
        	
        	applications.add(appl);
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
    	if (applied == null) {
    		System.out.println("ERROR: Yet to apply for project!\n");
    	}
    	else if (applied.getAppStatus() == ApplicationStatus.REQWITHDRAWAL) {
    		System.out.println("ERROR: Already requested withdrawal!\n");
    	}
    	else if (applied.getAppStatus() == ApplicationStatus.SUCWITHDRAWAL) {
    		System.out.println("Successful withdrawal!");
    		
    		Iterator<Application> it = applications.iterator();
        	while(it.hasNext()) {
        		Application a = it.next();
        		if (a.getID() == applied.getID()) it.remove();
        	}
    		applicant.setApplied(null);
        	
    		System.out.println("Deleted original application!\n");
    	}
    	else {
    		System.out.println("Are you sure? (YES = 1/ NO = 0)");
        	int choice = MenuInputService.getMenuInput(sc); 
        	
        	if (choice == 0) System.out.println("Terminating...\n");
        	else {
        		applied.setAppStatus(ApplicationStatus.REQWITHDRAWAL);
            	System.out.println("Sent withdrawal application!\\n");
        	}
    	}
    }

    private void handleEnquiry() {
    	callController.displayOptionsController();
    }
}
