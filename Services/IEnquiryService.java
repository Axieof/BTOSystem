package Services;

public interface IEnquiryService{
	public boolean createEnquiry();
    public boolean deleteEnquiry();
    public boolean editEnquiry();
    public boolean respondEnquiry();


    // filtering enquiry 
    
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