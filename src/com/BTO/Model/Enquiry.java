package src.com.BTO.Model;

import java.util.ArrayList;
import java.util.List;

import src.com.BTO.Model.Applicant;

public class Enquiry {
	// variables
	private int enquiryID;
	private String message;
	private String response = null;
	private Applicant applicant;
	private User respondent;
	private int projectID = -1;
	
	private static List<Enquiry> allEnquiry = new ArrayList<>();

	
	public Enquiry(int enquiryID, Applicant applicant, String message, int projectID) {
		if (enquiryID < 0) enquiryID = allEnquiry.size() + 1;
		this.enquiryID = enquiryID;
		this.message = message;
		this.applicant = applicant;
		this.projectID = projectID;
	}
	
	// getters
	public int getEnquiryID() {return enquiryID;}
	public String getMessage() {return message;}
	public String getResponse() {return response;}
	public User getRespondent() {return respondent;}
	public Applicant getApplicant() {return applicant;}
	public int getProjectID() {return projectID;}
	public List<Enquiry> getAllEnquiry(){return allEnquiry;}

	// setters
	public void setMessage(String message) {this.message = message;}
	public void setResponse(String response) {this.response = response;}
	
	public static void addEnquiry(Enquiry enq) { allEnquiry.add(enq); }
	public void clearEnquiries() { allEnquiry = new ArrayList<Enquiry>(); }
	
	public String toString(){
		return "Enquiry{Enquiry: '" + message + "', Response:" + response + "}";
	}
}
