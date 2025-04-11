package BTO;

public class Application {
	// variables
	private ProjectListing project;
	private ApplicationStatus appStatus;
	private Applicant applicant;
	
	// setters
	public ProjectListing getProject() { return project; }
	public ApplicationStatus getAppStatus() { return appStatus; }
	public Applicant getApplicant() { return applicant; }
	
	// getters
	public void setProject(ProjectListing projListing) { project = projListing; }
	public void setAppStatus(ApplicationStatus appStat) { appStatus = appStat; }
	// not sure if need a getter for applicant (which should be unchanged)
} 	
