package src.com.BTO.Controller;

import java.util.List;
import java.util.Scanner;

import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.Service.ApplicantEnquiryService;
import src.com.BTO.Service.UserEnquiryService;
import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.Model.User; 

public class ApplicantEnquiryController{
    ApplicantEnquiryService useService = new ApplicantEnquiryService();
    UserEnquiryService useUserService = new UserEnquiryService();

    public void displayOptions(){
        ApplicantEnquiryView.showdefaultEnquiryPrompt();
        int enquiryChoice = useService.getEnquiryChoiceInput();
        useService.selectOptionsService(enquiryChoice);
    }

    public void createEnquiryController(){
        ApplicantEnquiryView.showCreateEnquiryPrompt();
        useUserService.getString();
        ApplicantEnquiryView.showCreateEnquiryGetProject();
        useUserService.getInteger();
        ApplicantEnquiryView.showCreateEnquiryError();
        ApplicantEnquiryView.showCreateEnquirySuccess();

    }

    public void viewProjectEnquiryController(){}
    public void editEnquiryController(){}
    public void deleteEnquiryController(){}
    public void viewAnsweredController(){}
    public void returnLandingController(){}
    public void defaultEnquiryMessageController(){}




}




