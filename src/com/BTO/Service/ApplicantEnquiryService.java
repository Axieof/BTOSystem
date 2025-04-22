package src.com.BTO.Service;

import java.util.Scanner;
import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.View.ApplicantView;
import src.com.BTO.Service.UserEnquiryService;
import src.com.BTO.Controller.ApplicantEnquiryController;


public class ApplicantEnquiryService{
    UserEnquiryService callService = new UserEnquiryService();
    ApplicantEnquiryController callController = new ApplicantEnquiryController();

    public int getEnquiryChoiceInput(){
        return callService.getInteger();
    }

    public String getCreateMessage(){
        return callService.getString();
    }

    public void selectOptionsService(int enquiryChoice){
        switch(enquiryChoice){
			case 1 -> callController.createEnquiryController();
			case 2 -> callController.viewProjectEnquiryController();
			case 3 -> callController.editEnquiryController();
			case 4 -> callController.deleteEnquiryController();
			case 5 -> callController.viewAnsweredController();
			case 6 -> callController.returnLandingController();
			default -> callController.defaultEnquiryMessageController();
			}
			
		while (enquiryChoice !=6);}
    
    public boolean defaultEnquiryMessageService(){
        ApplicantEnquiryView callView = new ApplicantEnquiryView();
        callView.showdefaultEnquiryPrompt(); 
        return true;
    }

    public void createEnquiryService(){
        // get message

    }
    public void viewProjectEnquiryService(){}

    public void editEnquiryService(){}

    public void deleteEnquiryService(){}

    public void viewAnsweredService(){

    }

    public void returnLandingPageService(){
        ApplicantView.displayOptions();
        // get input num -> carry out new function
    }

}




