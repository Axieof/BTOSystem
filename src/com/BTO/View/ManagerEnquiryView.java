package src.com.BTO.View;

import java.util.List;

import src.com.BTO.Model.Enquiry;
 
public class ManagerEnquiryView {
    private Enquiry enquiry;

    public void showdefaultEnquiryPrompt(){
        System.out.println("===Choose your enquiry option===\n"
        + "0) Return\n"
        + "1) View Project Enquiry\n"
        + "2) Answer Project Enquiry\n"
        + "3) View All Projects Enquiry\n");
    }

    public void showAllEnquiry(){
        System.out.println("All Enquiries:");
    }

    public void defaultEnquiryMessageView(){
        System.out.println("Invalid! choose options between 0-5");
    }
    
    public void viewEnquiries(List<Enquiry> enqs) {
    	int count = 0;
    	for (Enquiry e : enqs) {
            System.out.println(count++ + ". " + e.toString());
        }
    }
}
