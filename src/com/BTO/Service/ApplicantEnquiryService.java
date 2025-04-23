package src.com.BTO.Service;

import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.Applicant;
import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.View.ApplicantView;
import src.com.BTO.Service.UserEnquiryService;
import src.com.BTO.Controller.ApplicantEnquiryController;

import src.com.BTO.Model.Enquiry;

public class ApplicantEnquiryService{
    private Applicant applicant;
    private Enquiry enquiry;
    UserEnquiryService callService = new UserEnquiryService();
    ApplicantEnquiryController callController = new ApplicantEnquiryController();

    public void selectOptionsService(int enquiryChoice){
        
        switch(enquiryChoice){
            case 0 -> callController.returnLandingPageController();
			case 1 -> callController.createEnquiryController();
			case 2 -> callController.viewProjectEnquiryController();
			case 3 -> callController.editEnquiryController();
			case 4 -> callController.deleteEnquiryController();
			case 5 -> callController.viewAnsweredController();
			default -> callController.defaultEnquiryMessageController();
			}
			
		while (enquiryChoice !=0);}
    
 
    // creating enquiry
    public boolean createEnquiryService(int enquiryID, String message, int projectID){
        //checking Applicant with given details
        if (!validateEnquiry(enquiryID, projectID)){return false;}
        // creating new enquiry 
        Enquiry enquiry = new Enquiry(generateEnquiryIDService(), applicant, message, projectID);
        applicant.getEnquiryList().add(enquiry);
        enquiry.getAllEnquiry().add(enquiry);
        return true;
    }

    public boolean validateEnquiry(int enquiryID, int projectID){
        if (applicant.getProjectID() != projectID){return false;}
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getEnquiryID() == enquiryID){return true;}
        }
        return false;
    }

    // view project enquiry service
    public boolean viewProjectEnquiryService(){
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            System.out.println(enquiry.toString());
        }
        return true;
    }

    public boolean editEnquiryService(int enquiryID, String message){
        
        if(!validateEnquiry(enquiryID, applicant.getProjectID())){return false;}
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getEnquiryID() == enquiryID){
                enquiry.setMessage(message);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEnquiryService(int enquiryID, List<Enquiry> enquiryList){
        if(!validateEnquiry(enquiryID, applicant.getProjectID())){return false;}
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getEnquiryID() == enquiryID){
                enquiry.setMessage(null);
                return true;
            }
        }
        return false;
    }

    public boolean viewAnsweredService(){
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getResponse() != null){
            System.out.println(enquiry.toString());
            }
        }
        return true;
    }

    

    public void returnLandingPageService(){
        ApplicantView.displayOptions();
        // get input num -> carry out new function
    }

    public int generateEnquiryIDService(){
        int index = 0;
        return ++index ;
    }


}




