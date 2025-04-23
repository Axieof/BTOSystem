package src.com.BTO.View;

public class ApplicantEnquiryView {

    public void showdefaultEnquiryPrompt() {
        System.out.println("===Choose your enquiry option===\n"
                + "0) Return\n"
                + "1) Create an Enquiry\n"
                + "2) View Enquiry\n"
                + "3) Edit Enquiry\n"
                + "4) Delete Enquiry\n"
                + "5) View answered Enquiry\n"
                + "Please key in your option: ");
    }

    public void choiceOutOfIndexView() {
        {
            System.out.println("Please choose a number from 0-5");
        }
    }

    public void createEnquiryProjectView() {
        System.out.println("Please key in the project ID you would like to enquire about. Else please type -1");
    }

    public void createEnquiryMessageView() {
        System.out.println("Please key in the enquiry: ");
    }

    public void createEnquiryErrorView() {
        System.out.println("Unsuccessful, please check your projectID and try again");
    }

    public void createEnquirySuccessView() {
        System.out.println("Enquiry Sucessfully Created!");
    }

    public void viewProjectEnquiryView() {
        System.out.println("All your past enquiries: ");
    }

    public void viewProjectEnquiryErrorView() {
        System.out.println("No enquiries found");
    }
}
