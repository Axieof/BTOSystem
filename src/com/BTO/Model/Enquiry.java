package Model;

public class Enquiry {
	private int enquiryID;
	private String message;
	private String response = null;
	private Applicant applicant;
	private User respondent;
	private int projectID;
	
	public Enquiry(int enquiryID, String message, Applicant applicant, int projectID) {
		this.enquiryID = enquiryID;
		this.message = message;
		this.applicant = applicant;
		this.projectID = projectID;
	}
	
	public Enquiry(int enquiryID, String response, User respondent) {
		this.enquiryID = enquiryID;
		this.response = response;
		this.respondent = respondent;
	}
	
	
	// getters
	public int getEnquiryID() {return enquiryID;}
	public String getMessage() {return message;}
	public String getResponse() {return response;}
	public User getRespondent() {return respondent;}
	public Applicant getApplicant() {return applicant;}
	public int getProjectID() {return projectID;}
	
	// setters
	public void setMessage(String message) {this.message = message;}
	public void setResponse(String response) {this.response = response;}
}