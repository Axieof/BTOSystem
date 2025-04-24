package src.com.BTO.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Enquiry;
import src.com.BTO.Model.Project;
import src.com.BTO.Model.HDBOfficer;

import src.com.BTO.Service.MenuInputService;
import src.com.BTO.View.OfficerEnquiryView;
import src.com.BTO.Controller.ApplicantEnquiryController;

public class OfficerEnquiryController{
    private OfficerEnquiryView callView;
    private HDBOfficer officer;
    private ApplicantEnquiryController callService;
    private ArrayList<Project> projs = new ArrayList<Project>();

    private Scanner sc = new Scanner(System.in);


    public OfficerEnquiryController(HDBOfficer officer, ArrayList<Project> projs){
        this.callView = new OfficerEnquiryView();
        this.officer = officer;
        this.projs = projs;
        this.callService = new ApplicantEnquiryController(officer, projs);
    }

    public void displayOptionsController() {
    	int enquiryChoice = -1;
    	
    	while (enquiryChoice != 0) {
    		callView.showdefaultEnquiryPrompt();
            System.out.println();
            
            enquiryChoice = MenuInputService.getMenuInput(sc);

            switch (enquiryChoice) {
                case 1 -> callService.createEnquiryController();
                case 2 -> callService.viewEnquiryController();
                case 3 -> callService.editEnquiry();
                case 4 -> callService.deleteEnquiry();
                case 5 -> callService.viewAnswered();
                case 6 -> answerProjectEnquiry();
                default -> { if (enquiryChoice != 0) choiceOutOfIndexController(); }
            }
    	}
        
    }

    public void choiceOutOfIndexController() {
        callView.choiceOutOfIndexView();
    }

    public void answerProjectEnquiry(){
        List<Enquiry> enquiries = officer.getEnquiryList();
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


}
    

