package src.com.BTO.Controller;

import src.com.BTO.View.ManagerEnquiryView;
import src.com.BTO.Service.ManagerEnquiryService;
import src.com.BTO.Service.UserEnquiryService;

public class ManagerEnquiryController {

    ManagerEnquiryView callView = new ManagerEnquiryView();
    ManagerEnquiryService callService = new ManagerEnquiryService();
    UserEnquiryService callUserService = new UserEnquiryService();

    public void displayOptionsController(){
        callView.showdefaultEnquiryPrompt();
        int enquiryChoice = callUserService.getInteger();
        callService.selectOptionsService(enquiryChoice);
    }

    public void defaultEnquiryMessageController(){
        displayOptionsController();
    }

    public void returnLandingPageController(){
        // class not made
    }
    
    public void viewAllEnquiryController(){
        callService.viewAllEnquiryService();
    }

}
