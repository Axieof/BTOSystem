package src.com.BTO.View;

public class ManagerEnquiryView {
    public void showdefaultEnquiryPrompt(){
        System.out.println("===Choose your enquiry option===\n"
        + "0) Return\n"
        + "1) View Project Enquiry\n"
        + "2) View Unanswered Project Enquiry\n"
        + "3) Answer Project Enquiry\n"
        + "4) Delete Answer\n"
        + "5) View All Projects Enquiry\n");
    }

    public void showAllEnquiry(){
        System.out.println("All Enquiries:");
    }

    public void defaultEnquiryMessageView(){
        System.out.println("Invalid! choose options between 0-5");
    }
    
    
}
