package src.com.BTO.View;

public class OfficerEnquiryView extends ApplicantEnquiryView{
    public void showdefaultEnquiryPrompt() {
		super.showdefaultEnquiryPrompt();
        System.out.println("6) View Unanswered Project Enquiry\n"
						+ "7) Answer Project Enquiry\n"
						+ "8) Delete Answer\n");
	}

	public void defaultEnquiryMessageView(){
		System.out.println("Invalid! choose options between 0-8");
	}
}
