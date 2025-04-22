package src.com.BTO.Model;
import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Enums.ApplicationStatus;

public class Application {
	// variables
	private Project project;
	private Unit unit;
	private ApplicationStatus appStatus;
	private Applicant applicant;
	
	private boolean reqBooking;
	
	public Application(Project proj, Unit u, Applicant appl) {
		project = proj;
		unit = u;
		applicant = appl;
		appStatus = ApplicationStatus.PENDING;
		reqBooking = false;
	}
	
	// setters
	public Project getProject() { return project; }
	public Unit getUnit() { return unit; }
	public ApplicationStatus getAppStatus() { return appStatus; }
	public Applicant getApplicant() { return applicant; }
	public boolean getReqBook() { return reqBooking; }
	
	// getters
	public void setProject(Project projListing) { project = projListing; }
	public void setUnit(Unit u) { unit = u;}
	public void setAppStatus(ApplicationStatus appStat) { appStatus = appStat; }
	public void requestBooking() { reqBooking = true; } 
} 	
