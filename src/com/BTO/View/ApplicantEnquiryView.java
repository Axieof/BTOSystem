package src.com.BTO.View;

public class ApplicantEnquiryView {
    
    public void showdefaultEnquiryPrompt(){
        System.out.println("Choose your enquiry option?\n"
        + "1. Create an Enquiry\n"
        + "2. View Enquiry\n"
        + "3. Edit Enquiry\n"
        + "4. Delete Enquiry\n"
        + "5. View answered Enquiry"
        + "6. Return");
    }

    public void showCreateEnquiryPrompt(){
        System.out.println("Please key in your Enquiry");
    }

    public void showCreateEnquiryGetProject(String enquiryMessage){
        System.out.println("Please key in the related projectID");
		System.out.println("Key in 0 if not related to any projects");
    }

    public void showCreateEnquiryError(){
        System.out.println("Error Sending across message, please try again.")
    }

    public void showCreateEnquirySuccess(){
        System.out.println("Error Sending across message, please try again.")
    }   


    // viewProjectEnquiry
    public void viewProjectEnquiry(){
        System.out.println("Project Name \n"
        + "=============================\n");
    }

    // editEnquiry
    public void showEditEnquiryPrompt(){
        System.out.println("Please key in the EnquiryID you would like to edit");
    }

    public void showEditEnquiryGetEnquiry(){
        System.out.println("Please key in the edited text");
    }

    public void showEditEnquiryError(){
        System.out.println("Update failed, please try again");
    }

    public void showEditEnquirySuccess(){
        System.out.println("Successfully Updated!");
    }


    // viewAnswered
    public void viewAnsweredEnquiry(){
        System.out.println(" Question Answer \n"
        + "=============================\n");
    }

    // delete Enquiry
    public void showDeleteEnquiry() {
		System.out.println("Please key in the EnquiryID you would like to delete");
    }

    public void showDeleteEnquiryError(){
        System.out.println("Update failed, please try again");
    }

    public void showDeleteEnquirySuccess(){
        System.out.println("Successfully Updated!");
    }
}
