package src.com.BTO.Controller;

import java.util.ArrayList;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.HDBOfficer;
import src.com.BTO.Model.Project;
import src.com.BTO.Service.MenuInputService;
import src.com.BTO.View.HDBOfficerView;

public class HDBOfficerController extends ApplicantController{
    
    private HDBOfficer officer;
    private HDBOfficerView offview;

    public HDBOfficerController(HDBOfficer officer, ArrayList<Project> projs) {
    	super(officer, projs);
        this.officer = officer;
    }
    
    public void viewLandingPage() {
    	int choice = -1;
    	
    	while (choice != 0) {
	    	offview.displayStarter();
	    	choice = MenuInputService.getMenuInput(sc);
	    	
	    	System.out.println("Redirecting...");
	    	switch(choice) {
	    	case 1-> super.viewLandingPage();
	    	case 2-> viewOfficerPage();
	    	// case 3-> continue; // SHOULD LINK TO COMMON OFFICER-MANAGER INTERFACE
	    	}
    	}
    	
    	System.out.println("Exiting officer menu...");
    }
    	
    private void viewOfficerPage() {
    	int choice = -1;
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> regJoinProj();
    		case 2-> menageBookings();
    		case 3-> genReceipts();
    		}

    		applView.displayOptions();
    		choice = MenuInputService.getMenuInput(sc);
    	}
    	
    	System.out.println("Exiting officer view...");
    }
    
    private void regJoinProj() {
    	
    }
    
    private void menageBookings() {
    	
    }
    
    private void genReceipts() {
    	
    }
}

