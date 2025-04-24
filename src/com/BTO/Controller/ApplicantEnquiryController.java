package src.com.BTO.Controller;

import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.View.ProjectView;

import src.com.BTO.Service.ApplicantEnquiryService;
import src.com.BTO.Service.MenuInputService;

import src.com.BTO.Model.Enquiry;
import src.com.BTO.Model.Project;
import src.com.BTO.Model.Applicant;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicantEnquiryController {
	
	// Attributes
    private Applicant applicant;
    private ArrayList<Project> projects;
    
    // Tools
    private ApplicantEnquiryView callView;
    private ProjectView projView;
    private ApplicantEnquiryService callService;
   
    private Scanner sc = new Scanner(System.in);
    

    public ApplicantEnquiryController(Applicant applicant, ArrayList<Project> projs) {
        this.applicant = applicant;
        this.callService = new ApplicantEnquiryService(applicant);
        
        projects = projs;
        
        callView = new ApplicantEnquiryView();
        projView = new ProjectView();
    }

    public void displayOptionsController() {
    	int enquiryChoice = -1;
    	
    	while (enquiryChoice != 0) {
    		callView.showdefaultEnquiryPrompt();
            System.out.println();
            
            enquiryChoice = MenuInputService.getMenuInput(sc);

            switch (enquiryChoice) {
                case 1 -> createEnquiryController();
                case 2 -> viewEnquiryController();
                case 3 -> editEnquiry();
                case 4 -> deleteEnquiry();
                case 5 -> viewAnswered();
                default -> { if (enquiryChoice != 0) choiceOutOfIndexController(); }
            }
    	}
        
    }

    public void choiceOutOfIndexController() {
        callView.choiceOutOfIndexView();
    }

    public void createEnquiryController() {
        callView.createEnquiryProjectView();
        
        projView.displayProjectNames(projects); // show list of project names
        
        int projectID = MenuInputService.getMenuInput(sc);
        if (projectID != -1) projectID = projects.get(projectID).getID();
        
        callView.createEnquiryMessageView();
        
        String message = sc.nextLine();
        
        if (callService.createEnquiryService(applicant, message, projects.get(projectID).getID())) {
        	callView.createEnquirySuccessView();
        }
        else {
        	callView.createEnquiryErrorView();
        }
        System.out.println();
    }

    public void viewEnquiryController() {
        callView.viewProjectEnquiryView();
        
        if (!callService.viewProjectEnquiryService(applicant)) {
            callView.viewProjectEnquiryErrorView();
        }
        else {
            List<Enquiry> enquiries = applicant.getEnquiryList();
        	callView.viewEnquiries(enquiries);
        }
        System.out.println();
    }
    
    public void editEnquiry() {
        List<Enquiry> enquiries = applicant.getEnquiryList();
        
        if (enquiries.size() == 0) {
        	System.out.println("ERROR: No enquiries created!");
        	return;
        }
        
		System.out.println("Which enquiry to edit?");
        callView.viewEnquiries(enquiries);
    	int choice = MenuInputService.getMenuInput(sc);
        
    	if (0 > choice || choice >= enquiries.size()) {
    		System.out.println("ERROR: Index out of range!");
    		System.out.println("Terminating...\n");
    		return;
    	}
    	
    	Enquiry chosen = enquiries.get(choice);
		System.out.println("Editing:" + chosen.toString());
		System.out.println("Enter the new message: ");
		String message = sc.nextLine();
		
		chosen.setMessage(message);
		System.out.println("Enquiry updated!\n");
    }
    
    public void deleteEnquiry() {
    	List<Enquiry> enquiries = applicant.getEnquiryList();
    	
    	if (enquiries.size() == 0) {
    		System.out.println("ERROR: No enquiries created!");
        	return;
    	}
    	
		System.out.println("Which enquiry to delete?");
        callView.viewEnquiries(enquiries);
    	int choice = MenuInputService.getMenuInput(sc);
        
    	if (0 > choice || choice >= enquiries.size()) {
    		System.out.println("ERROR: Index out of range!");
    		System.out.println("Terminating...\n");
    		return;
    	}
    	
    	Enquiry chosen = enquiries.get(choice);
    	System.out.println("Are you sure you want to delete: " + chosen.toString());
    	System.out.println("(YES = 1/ NO = 0)");
    	choice = MenuInputService.getMenuInput(sc);
		
    	if (choice == 1) {
    		// ALSO DELETE FROM CSV
    		Enquiry e = new Enquiry(-1,applicant,"",-1);
    		
    		if (e.getAllEnquiry().size() <= 1) e.clearEnquiries();
    		else e.getAllEnquiry().remove(enquiries.get(choice));
    		
    		if (enquiries.size() <= 1) applicant.setEnquiryList(new ArrayList<Enquiry>());
    		else enquiries.remove(enquiries.get(choice)); 
    		
        	System.out.println("Deleted enquiry!\n");
    	}
    	else {
    		System.out.println("Terminating...\n");
    	}
    }
    
    public void viewAnswered() {
    	List<Enquiry> enquiries = applicant.getEnquiryList();
    	
    	if (enquiries.size() == 0) {
    		System.out.println("No answered enquiries.");
    	}
    	else {
    		System.out.println("All answered enquiries:");
    		ArrayList<Enquiry> filtered = new ArrayList<>();
        	
        	for (Enquiry e : enquiries) {
        		if (e.getResponse() != null) filtered.add(e);
        	}
        	
        	callView.viewEnquiries(filtered);
    	}
        System.out.println();
    }

}
