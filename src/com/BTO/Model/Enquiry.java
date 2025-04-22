package src.com.BTO.Model;

import src.com.BTO.Model.Applicant;

public class Enquiry {
	// variables
	private int enquiryID;
	private String message;
	private String response = null;
	private Applicant applicant;
	private User respondent;
	private int projectID;
	
	//need date and time?

	private boolean answered;
	
	public Enquiry(String message, Applicant applicant) {
		this.message = message;
		this.applicant = applicant;
		this.answered = false;
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
