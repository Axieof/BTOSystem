package src.com.BTO.View;

public class ApplicantEnquiryView {
    
    public static void showdefaultEnquiryPrompt(){
        System.out.println("Choose your enquiry option?\n"
        + "1. Create an Enquiry\n"
        + "2. View Enquiry\n"
        + "3. Edit Enquiry\n"
        + "4. Delete Enquiry\n"
        + "5. View answered Enquir\n"
        + "6. Return\n");
    }

    public static void showCreateEnquiryPrompt(){
        System.out.println("Please key in your Enquiry\n");
    }

    public static void showCreateEnquiryGetProject(){
        System.out.println("Please key in the related projectID\n");
		System.out.println("Key in 0 if not related to any projects\n");
    }

    public static void showCreateEnquiryError(){
        System.out.println("Error Sending across message, please try again.\n");
    }

    public static void showCreateEnquirySuccess(){
        System.out.println("Your enquiry has been sent.\n");
    }   


    // viewProjectEnquiry
    public static void viewProjectEnquiry(){
        System.out.println("Project Name \n"
        + "=============================\n");
    }

    // editEnquiry
    public static void showEditEnquiryPrompt(){
        System.out.println("Please key in the EnquiryID you would like to edit\n");
    }

    public static void showEditEnquiryGetEnquiry(){
        System.out.println("Please key in the edited text\n");
    }

    public static void showEditEnquiryError(){
        System.out.println("Update failed, please try again\n");
    }

    public static void showEditEnquirySuccess(){
        System.out.println("Successfully Updated!\n");
    }


    // viewAnswered
    public static void viewAnsweredEnquiry(){
        System.out.println(" Question Answer \n"
        + "=============================\n");
    }

    // delete Enquiry
    public static void showDeleteEnquiry() {
		System.out.println("Please key in the EnquiryID you would like to delete\n");
    }

    public static void showDeleteEnquiryError(){
        System.out.println("Update failed, please try again\n");
    }

    public static void showDeleteEnquirySuccess(){
        System.out.println("Successfully Updated!\n");
    }
    public static void showDefaultEnquiry(){
        System.out.println("Invalid choose options 1-6");
    }
}
