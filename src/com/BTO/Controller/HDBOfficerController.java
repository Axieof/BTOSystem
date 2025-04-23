package src.com.BTO.Controller;

import java.util.ArrayList;
import java.util.List;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Application;
import src.com.BTO.Model.HDBOfficer;
import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;
import src.com.BTO.Model.Enums.*;

import src.com.BTO.Service.MenuInputService;
import src.com.BTO.Service.CSVLoaderService;

import src.com.BTO.View.HDBOfficerView;

public class HDBOfficerController extends ApplicantController{
    
	// attributes
    private HDBOfficer officer;
    private ArrayList<Application> applications;
    
    // tools
    private HDBOfficerView offView;
    private CSVLoaderService csvloader;

    public HDBOfficerController(HDBOfficer officer, ArrayList<Project> projs, ArrayList<Application> appls) {
    	super(officer, projs);
        this.officer = officer;
        applications = appls;
        offView = new HDBOfficerView();
        csvloader = new CSVLoaderService();
    }
    
    public void viewLandingPage() {
    	int choice = -1;
    	
    	while (choice != 0) {
    		offView.displayStarter();
	    	choice = MenuInputService.getMenuInput(sc);
	    	
	    	System.out.println("Redirecting...\n");
	    	switch(choice) {
	    	case 1-> super.viewLandingPage();
	    	case 2-> viewOfficerPage();
	    	}
    	}
    	
    	System.out.println("Exiting officer menu...\n");
    }
    	
    private void viewOfficerPage() {
    	int choice = -1;
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> regJoinProj();
    		case 2-> manageBookings();
    		// case 3-> continue; // SHOULD LINK TO COMMON OFFICER-MANAGER INTERFACE
    		}

    		offView.displayOptions();
    		choice = MenuInputService.getMenuInput(sc);
    	}
    	
    	System.out.println("Exiting officer view...\n");
    }
    
    @Override
    protected ArrayList<Project> filterProjects(ArrayList<Project> projs) {
    	return filtMgr.offFilterProjects(projs, officer);
    }
    
    private void regJoinProj() {
    	Application applied = officer.getApplied();
    	if (applied != null) {
        	if (applied.getReqBook()) {
        		System.out.println("Already Booked!");
        	}
        	else if (applied.getAppStatus() == ApplicationStatus.SUCCESSFUL) {
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
    		System.out.println("Registering for project...");
        	
        	if (officer.getCurrProj() != null || officer.getApplied() != null) {
        		System.out.println("ERROR: Cannot register/ apply for multiple open projects!\n");
        		return;
        	}
        	
        	ArrayList<Project> filtered = super.filterProjects();
        	if (filtered.size() == 0) {
        		System.out.println("ERROR: No open projects!\n");
        		return;
        	}
        	System.out.println("Which would you like to register for?");
        	projView.displayProjectNames(filtered);
        	int choice = MenuInputService.getMenuInput(sc);
        	
        	Application appl = new Application(filtered.get(choice), null, officer); // Create and send application
        	// UPDATE APPLICATION IN DATABASE (CSV) YET TO DO
        	officer.setApplied(appl);
        	
        	System.out.println("Registered for project\n");
    	}
    }
    
    private void manageBookings() {
    	Project currProj = officer.getCurrProj();
    	if (currProj == null) {
    		System.out.println("ERROR: No registered project!");
    		//return;
    	}
    	
    	// filter applications
    	ArrayList<Application> appls = filtMgr.offManageApplication(applications);
    	
    	// display applications
    	offView.displayApplications(appls);
    	int choice = MenuInputService.getMenuInput(sc);
    	Application curr = appls.get(choice); 
    	
    	System.out.println("Confirm booking? (YES = 1/ NO = 0)");
    	choice = MenuInputService.getMenuInput(sc);
    	
    	if (choice == 0) {
    		System.out.println("Exiting...\n");
    		return;
    	}
    	
    	ArrayList<Unit> units = curr.getProject().getUnitTypes();
    	Unit chosen = null;
    	for (Unit u : units) {
    		if (u.getRoomType() == curr.getUnit().getRoomType()) {
    			chosen = u;
    			
    			if (chosen.getUnitCount() <= 0) {
    				System.out.println("ERROR: No flats remaining!");
    				return;
    			}
    			chosen.setUnitCount(u.getUnitCount()-1);
    			break;
    		}
    	}
    	
    	if (chosen != null) {
    		curr.setAppStatus(ApplicationStatus.BOOKED);
        	curr.getApplicant().setBookedProject(currProj, chosen);
    		System.out.println("Booked successfully!\n");
    		
    		System.out.println("Generate receipt? (YES = 1/ NO = 0)");
        	choice = MenuInputService.getMenuInput(sc);
        	
        	if (choice == 1) genReceipts(curr);
        	else System.out.println("Exiting...\n");
    	}
    	else {
    		System.out.println("ERROR: Invalid unit?");
    	}
    	
    }
    
    private void genReceipts(Application appl) {
    	offView.displayReceipt(appl.getApplicant(), appl.getProject(), appl.getUnit());
    }
}

