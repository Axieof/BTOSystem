package BTO;

public class Enquiry {
	private String question;
	private String reply;
	
	private Applicant sender;
	private User respondent;
	
	private boolean answered;
	
	public Enquiry(String q, Applicant send) {
		question = q;
		sender = send;
		answered = false;
	}
	
	public String getEnquiry() { return question; }
	public Applicant getSender() { return sender; }
	
	public String getResponse() { return reply; }
	public User getRespondent() { return respondent; }
	public boolean isAnswered() { return answered; }
	
	public void editEnquiry(String edited) { 
		if (!answered) question = edited;
		else System.out.println("ERROR: Enquiry closed. Unable to edit.");
	}
	public void respondEnquiry(String repl, User resp) {
		reply = repl;
		respondent = resp;
		answered = true;
	}
}
