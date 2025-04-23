package src.com.BTO.Controller;

import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.Service.ApplicantEnquiryService;
import src.com.BTO.Service.UserEnquiryService;
import src.com.BTO.Model.Enquiry;

public class ApplicantEnquiryController{
    private Enquiry enquiry;

    ApplicantEnquiryView callView = new ApplicantEnquiryView();
    ApplicantEnquiryService useService = new ApplicantEnquiryService();
    UserEnquiryService useUserService = new UserEnquiryService();

    public void displayOptionsController(){
        callView.showdefaultEnquiryPrompt();
        int enquiryChoice = useUserService.getInteger();
        useService.selectOptionsService(enquiryChoice);
    }

    public void createEnquiryController(){
        callView.showCreateEnquiryPrompt();
        String message = useUserService.getString();
        callView.showCreateEnquiryGetProject();
        int projectID = useUserService.getInteger();
        if(useService.createEnquiryService(useService.generateEnquiryIDService(), message , projectID)){callView.showCreateEnquiryError();}
        else{callView.showCreateEnquirySuccess();}
    }

    public void viewProjectEnquiryController(){
        callView.viewProjectEnquiry();
        useService.viewProjectEnquiryService();
    }

    public void editEnquiryController(){
        callView.showEditEnquiryPrompt();
        int enquiryID = useUserService.getInteger();
        callView.showEditEnquiryGetEnquiry();
        String message = useUserService.getString();
        if (useService.editEnquiryService(enquiryID, message)){callView.showEditEnquirySuccess();}
        else{callView.showEditEnquiryError();}
    }

    public void deleteEnquiryController(){
        callView.showDeleteEnquiry();
        int enquiryID = useUserService.getInteger();
        if (useService.deleteEnquiryService(enquiryID, enquiry.getAllEnquiry() )) {callView.showDeleteEnquirySuccess();}
        else{callView.showDeleteEnquiryError();}        
    }

    public void viewAnsweredController(){
        callView.viewAnsweredEnquiry();
        useService.viewAnsweredService();
    }

    public void returnLandingPageController(){
        useService.returnLandingPageService();
    }

    public void defaultEnquiryMessageController(){
        displayOptionsController();
    }




}




