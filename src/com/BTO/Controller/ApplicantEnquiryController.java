package src.com.BTO.Controller;

import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.Service.ApplicantEnquiryService;
import src.com.BTO.Service.UserEnquiryService;
import src.com.BTO.Model.Enquiry;
import src.com.BTO.Model.Applicant;

public class ApplicantEnquiryController {
    private Applicant applicant;
    private ApplicantEnquiryService callService;
    private ApplicantEnquiryView callView;
    private UserEnquiryService callUserService;

    public ApplicantEnquiryController(Applicant applicant) {
        this.applicant = applicant;
        this.callService = new ApplicantEnquiryService(applicant);
        this.callView = new ApplicantEnquiryView();
        this.callUserService = new UserEnquiryService();
    }

    public void displayOptionsController() {
        callView.showdefaultEnquiryPrompt();
        int enquiryChoice = callUserService.getInteger();

        switch (enquiryChoice) {
            case 1 -> createEnquiryController();
            case 2 -> viewEnquiryController();
            case 3 -> System.out.println("3");
            case 4 -> System.out.println("4");
            case 5 -> System.out.println("5");
            default -> choiceOutOfIndexController();

        }
    }

    public void choiceOutOfIndexController() {
        callView.choiceOutOfIndexView();
        displayOptionsController();
    }

    public void createEnquiryController() {
        callView.createEnquiryProjectView();
        int projectID = callUserService.getInteger();
        callView.createEnquiryMessageView();
        String message = callUserService.getString();
        if (callService.createEnquiryService(applicant, message, projectID)) {
            callView.createEnquirySuccessView();
        } else {
            callView.createEnquiryErrorView();
        }

    }

    public void viewEnquiryController() {
        callView.viewProjectEnquiryView();
        if (!callService.viewProjectEnquiryService(applicant)) {
            callView.viewProjectEnquiryErrorView();
        }

    }

}
