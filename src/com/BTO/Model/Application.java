package src.com.BTO.Model;
import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Enums.ApplicationStatus;

public class Application {
	// variables
	private Project project;
	private Unit unit;
	private ApplicationStatus appStatus;
	private Applicant applicant;
	
	public Application(Project proj, Unit u, Applicant appl) {
		project = proj;
		unit = u;
		applicant = appl;
		appStatus = ApplicationStatus.PENDING;
	}
	
	// setters
	public Project getProject() { return project; }
	public Unit getUnit() { return unit; }
	public ApplicationStatus getAppStatus() { return appStatus; }
	public Applicant getApplicant() { return applicant; }
	
	// getters
	public void setProject(Project projListing) { project = projListing; }
	public void setUnit(Unit u) { unit = u;}
	public void setAppStatus(ApplicationStatus appStat) { appStatus = appStat; }
	// not sure if need a getter for applicant (which should be unchanged)
} 	
