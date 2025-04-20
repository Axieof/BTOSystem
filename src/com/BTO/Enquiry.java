package src.com.BTO;

public class Enquiry {
	// variables
	private int enquiryID; 

	private String message;
	private String reply;
	
	private Applicant applicantName;
	private User respondent;
	private Applicant projectName;
	
	//need date and time?

	private boolean answered;
	
	public Enquiry(String message, Applicant applicantName) {
		this.message = message;
		this.applicantName = applicantName;
		this.answered = false;
	}
	
	// getters
	public String getEnquiry() { return message; }
	public Applicant getSender() { return applicantName; }
	
	public String getResponse() { return reply; }
	public User getRespondent() { return respondent; }


	public boolean isAnswered() { return answered; }
	

}
