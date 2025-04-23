package src.com.BTO.View;

public class ApplicantEnquiryView {
    
    public void showdefaultEnquiryPrompt(){
        System.out.println("===Choose your enquiry option===\n"
        + "0) Return\n"
        + "1) Create an Enquiry\n"
        + "2) View Enquiry\n"
        + "3) Edit Enquiry\n"
        + "4) Delete Enquiry\n"
        + "5) View answered Enquir\n");
    }

    public void showCreateEnquiryPrompt(){
        System.out.println("Please key in your Enquiry\n");
    }

    public void showCreateEnquiryGetProject(){
        System.out.println("Please key in the related projectID\n");
		System.out.println("Key in 0 if not related to any projects\n");
    }

    public void showCreateEnquiryError(){
        System.out.println("Error Sending across message, please try again.\n");
    }

    public void showCreateEnquirySuccess(){
        System.out.println("Your enquiry has been sent.\n");
    }   


    // viewProjectEnquiry
    public void viewProjectEnquiry(){
        System.out.println("Project Name \n"
        + "=============================\n");
    }

    // editEnquiry
    public void showEditEnquiryPrompt(){
        System.out.println("Please key in the EnquiryID you would like to edit\n");
    }

    public void showEditEnquiryGetEnquiry(){
        System.out.println("Please key in the edited text\n");
    }

    public void showEditEnquiryError(){
        System.out.println("Update failed, please try again\n");
    }

    public void showEditEnquirySuccess(){
        System.out.println("Successfully Updated!\n");
    }


    // viewAnswered
    public void viewAnsweredEnquiry(){
        System.out.println(" Question Answer \n"
        + "=============================\n");
    }

    // delete Enquiry
    public void showDeleteEnquiry() {
		System.out.println("Please key in the EnquiryID you would like to delete\n");
    }

    public void showDeleteEnquiryError(){
        System.out.println("Update failed, please try again\n");
    }

    public void showDeleteEnquirySuccess(){
        System.out.println("Successfully Updated!\n");
    }

    
    //Default Enquiry
    public void showDefaultEnquiry(){
        System.out.println("Invalid! choose options between 0-5");
    }
}
