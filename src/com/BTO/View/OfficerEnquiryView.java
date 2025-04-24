package src.com.BTO.View;

public class OfficerEnquiryView extends ApplicantEnquiryView{
    public void showdefaultEnquiryPrompt() {
		super.showdefaultEnquiryPrompt();
        System.out.println("6) Answer Project Enquiry\n");
	}

	
	public void choiceOutOfIndexView() {
        System.out.println("Invalid! choose options between 0-8");
    }
}
