package src.com.BTO.Controller;

import java.util.ArrayList;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.HDBOfficer;
import src.com.BTO.Model.Project;
import src.com.BTO.Service.MenuInputService;
import src.com.BTO.View.HDBOfficerView;

public class HDBOfficerController extends ApplicantController{
    
    private HDBOfficer officer;
    private HDBOfficerView offView;

    public HDBOfficerController(HDBOfficer officer, ArrayList<Project> projs) {
    	super(officer, projs);
        this.officer = officer;
        offView = new HDBOfficerView();
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
	    	// case 3-> continue; // SHOULD LINK TO COMMON OFFICER-MANAGER INTERFACE
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
    		case 3-> genReceipts();
    		}

    		offView.displayOptions();
    		choice = MenuInputService.getMenuInput(sc);
    	}
    	
    	System.out.println("Exiting officer view...\n");
    }
    
    private void regJoinProj() {
    	System.out.println("Registering for project...");
    	Project currProj = officer.getCurrProj();
    	if (currProj != null) {
    		System.out.println("ERROR: Cannot register for multiple open projects!\n");
    		return;
    	}
    	
    	ArrayList<Project> filtered = super.filterProjects();
    	if (filtered.size() == 0) {
    		System.out.println("ERROR: No open projects!");
    		return;
    	}
    	System.out.println("Which would you like to register for?");
    	applView.displayProjectNames(filtered);
    	// continue
    }
    
    private void manageBookings() {
    	Project currProj = officer.getCurrProj();
    	
    	
    }
    
    private void genReceipts() {
    	
    }
}

