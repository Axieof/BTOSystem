package src.com.BTO.Controller;

import java.util.ArrayList;
import java.util.Iterator;
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
    	Application register = officer.getProjReg();
    	if (register != null) {
        	if (register.getAppStatus() == ApplicationStatus.SUCCESSFUL) {
        		System.out.println("Project registration successful!");

        		Project proj = register.getProject();
        		proj.addOfficer(officer);
        		officer.setCurrProj(proj);
        		officer.setProjReg(null);
        		
        		System.out.println("Completed registration!");
    		}
        	else System.out.println("Already registered for project!");
    	}
    	else {
    		System.out.println("Registering for project...");
        	
        	if (officer.getCurrProj() != null) {
        		System.out.println("ERROR: Cannot register for multiple open projects!\n");
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
        	
        	// null unit marks difference between officer registration application and normal application
        	Application appl = new Application(filtered.get(choice), null, officer); // Create and send application

        	Iterator<Application> it = applications.iterator();
        	while(it.hasNext()) {
        		Application a = it.next();
        		if (a.getID() == appl.getID()) it.remove();
        	}
        	
        	officer.setProjReg(appl);
        	
        	System.out.println("Registered for project\n");
    	}
    }
    
    private void manageBookings() {
    	Project currProj = officer.getCurrProj();
    	if (currProj == null) {
    		System.out.println("ERROR: No registered project!");
    		return; 
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

