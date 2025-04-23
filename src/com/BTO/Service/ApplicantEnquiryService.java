package src.com.BTO.Service;

import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.Applicant;
import src.com.BTO.View.ApplicantEnquiryView;
import src.com.BTO.View.ApplicantView;
import src.com.BTO.Service.UserEnquiryService;
import src.com.BTO.Controller.ApplicantEnquiryController;

import src.com.BTO.Model.Enquiry;

public class ApplicantEnquiryService {
    public static int enquiryID = 0;
    private UserEnquiryService callService;
    private ApplicantEnquiryController callController;

    public ApplicantEnquiryService(Applicant applicant) {
        this.callService = new UserEnquiryService();
    }

    public int generateEnquiryIDService() {
        return ++enquiryID;
    }

    public boolean createEnquiryService(Applicant applicant, String message, int projectID) {
        if (projectID != -1 && !validateUser(projectID, applicant)) {
            return false;
        }
        Enquiry enquiry = new Enquiry(generateEnquiryIDService(), applicant, message, projectID);
        applicant.getEnquiryList().add(enquiry);
        enquiry.getAllEnquiry().add(enquiry);
        return true;
    }

    public boolean validateUser(int projectID, Applicant applicant) {
        if (applicant.getProjectID() != projectID) {
            return false;
        }
        return true;
    }

    // view Enquiry
    public boolean viewProjectEnquiryService(Applicant applicant) {
        List<Enquiry> enquiries = applicant.getEnquiryList();
        if (enquiries == null) {
            return false;
        } else {
            for (Enquiry e : enquiries) {
                System.out.println(e.toString());
            }
        }
        return true;

    }

}
