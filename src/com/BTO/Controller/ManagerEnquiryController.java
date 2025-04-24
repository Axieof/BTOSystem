package src.com.BTO.Controller;

import src.com.BTO.View.ManagerEnquiryView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Enquiry;
import src.com.BTO.Model.HDBManager;
import src.com.BTO.Service.MenuInputService;


public class ManagerEnquiryController{
    private ManagerEnquiryView callView;
    private Applicant applicant;

    List<Enquiry> allEnquiries = new ArrayList<>();
    List<Applicant> appls = Applicant.getAllApplicants();

    private HDBManager manager;

    private Scanner sc = new Scanner(System.in);

    public ManagerEnquiryController(HDBManager manager){
        this.callView = new ManagerEnquiryView();
        this.manager = manager;
    }

    public void displayOptionsController() {
    	int enquiryChoice = -1;
    	
    	while (enquiryChoice != 0) {
    		callView.showdefaultEnquiryPrompt();
            System.out.println();
            
            enquiryChoice = MenuInputService.getMenuInput(sc);

            switch (enquiryChoice) {
                case 1 -> viewProjectEnquiry();
                case 2 -> answerProjectEnquiry();
                case 3 -> viewAllEnquiry();
                default -> { if (enquiryChoice != 0) choiceOutOfIndexController(); }
            }
    	}
        
    }
    public List<Enquiry> getEnquiryList(){
        for (Applicant a : appls) {
            allEnquiries.addAll(a.getEnquiryList()); // add their enquiries directly
        }
    
        return allEnquiries;
    }

    public void viewProjectEnquiry(){
		System.out.println("Key in the projectID of project you would like to view?");
    	int enquiryID = MenuInputService.getMenuInput(sc);

        List<Enquiry> enquiries = getEnquiryList();
        if (enquiries.size() == 0) {
        	System.out.println("ERROR: No enquiries!");
        	return;
        }
        callView.showAllEnquiry();

        for (Enquiry enquiry: enquiries){
            if (enquiry.getEnquiryID() == enquiryID){
            System.out.println(enquiry.toString());}
        }
    }

    public void answerProjectEnquiry(){
        List<Enquiry> enquiries = getEnquiryList();
        if (enquiries.size() == 0) {
        	System.out.println("ERROR: No enquiries created!");
        	return;
        }

        System.out.println("Which enquiry to answer?");
        callView.viewEnquiries(enquiries);
    	int choice = MenuInputService.getMenuInput(sc);

        if (0 > choice || choice >= enquiries.size()) {
    		System.out.println("ERROR: Index out of range!");
    		System.out.println("Terminating...\n");
    		return;
    	}

        Enquiry chosen = enquiries.get(choice);
		System.out.println("Editing:" + chosen.toString());
		System.out.println("Enter the response: ");
		String message = sc.nextLine();
		
		chosen.setResponse(message);
		System.out.println("Response updated!\n");
    }

    public void viewAllEnquiry(){
        List<Enquiry> enquiries = getEnquiryList();
        if (enquiries.size() == 0) {
        	System.out.println("ERROR: No enquiries!");
        	return;
        }
        callView.showAllEnquiry();

        for (Enquiry enquiry: enquiries){
            System.out.println(enquiry.toString());
        }

    }

    public void choiceOutOfIndexController(){
        callView.defaultEnquiryMessageView();
    }


}
