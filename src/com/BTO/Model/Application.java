package src.com.BTO.Model;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Enums.ApplicationStatus;
import src.com.BTO.Model.Enums.RoomType;

import java.util.ArrayList;

public class Application {
	// variables
	private int id; // ID SHOULD BE SET WHEN SAVING/ LOADING
	private static int applCount = 0;
	
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
	
	// getters
	public int getID() { return id; }
	public static int getApplCount() { return applCount; }
	
	public Project getProject() { return project; }
	public Unit getUnit() { return unit; }
	public ApplicationStatus getAppStatus() { return appStatus; }
	public Applicant getApplicant() { return applicant; }
	public boolean getReqBook() { return reqBooking; }
	
	// setters
	public void setID() { setID(-1); }
	public void setID(int id) { 
		if (id == -1) this.id = applCount++;
		else this.id = id;
	}
	
	public void setProject(Project projListing) { project = projListing; }
	public void setUnit(Unit u) { unit = u;}
	public void setAppStatus(ApplicationStatus appStat) { appStatus = appStat; }
	public void requestBooking() { reqBooking = true; } 
} 	
