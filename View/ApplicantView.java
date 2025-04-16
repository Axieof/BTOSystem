package View;
import BTO.*;
import Enums.RoomType;
import Services.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicantView implements ILandingPageView{
	// General attributes
	private ArrayList<ProjectListing> projects = new ArrayList<ProjectListing>();
	private Applicant applicant;
	
	// Tools
	Scanner sc = new Scanner(System.in);
	
	// Constructor
	public ApplicantView(Applicant appl, ArrayList<ProjectListing> projs){
		applicant = appl;
		projects = projs;
	}
	
	public void viewLandingPage() {
		int choice = getChoice();
		System.out.println();
		
		while (choice != 0) {
			switch (choice) {
			case 1-> viewProjects();
			case 2-> applyProject();
			case 3-> viewAppliedProject();
			case 4-> requestAppWithdrawal();
			case 5-> handleEnquiry();
			}
			
			choice = getChoice();
			System.out.println();
		}
		
		// SOMETHING HERE TO DEAL WITH EXITING VIEW
	}
	
	private int getChoice() {
		int choice = -1;

		System.out.println("What would you like to do?\n"
							+ "1. View projects\n"
							+ "2. Apply for project\n"
							+ "3. View your applied project\n"
							+ "4. Request application withdrawal\n"
							+ "5. Handle your enquiries\n"
							+ "0. EXIT/ LOGOUT IDK");
		choice = sc.nextInt();
		
		if (0 <= choice && choice <= 5) return choice;
		else {
			System.out.println("ERROR: Invalid choice.");
			return -1;
		}
	}
	
	private ArrayList<ProjectListing> filterProjects() { return filterProjects(this.projects); }
	private ArrayList<ProjectListing> filterProjects(ArrayList<ProjectListing> projs) {
		ArrayList<ProjectListing> filtered;
		
		// FILTER THE COMPULSORY STUFF
		
		// THIS IS A GENERAL VISIBILITY FILTER:
		FilterVisibility filterVis = new FilterVisibility(); 
		filtered = filterVis.filter(projects);
		
		// FILTER APPLICANT'S GROUP:
		FilterFlatType filterFlat = new FilterFlatType();
		if (applicant.maritalStatus == "SINGLE") {
			filterFlat.setFlatType(RoomType.TWOROOM); // only gets two room
			filtered = filterFlat.filter(filtered);
		}
		
		
		// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
		// INCOMPLETE
		
		return filtered;
	}
	
	public void viewProjects() {
		System.out.println("List of projects:");
		
		ArrayList<ProjectListing> filtered = filterProjects();
		
		for (ProjectListing proj : filtered) {
			if (proj.getVisibility()) {
				System.out.println(proj);
				System.out.println();
			}
		}
	}
	
	public void applyProject() {
		System.out.println("Applying for project...");

		System.out.println("Which would you like to apply for?");
		
		// FILTER PROJECTS INTO filteredProjs
		
		ProjectListing proj;
		for (int i=0; i<projects.size(); i++) {
			proj = projects.get(i);
			if (proj.getVisibility()) {
				System.out.println(i + ". " + proj.getProjectName());
			}
		}
		
		int choice = sc.nextInt();
		proj = projects.get(choice);
		
		ArrayList<Unit> allUnits = proj.getUnitTypes();
		// THEN CHOOSE UNIT TYPE (FILTER)
		// CREATE AND SEND APPLICATION
	}
	
	public void viewAppliedProject() {
		// IF PROJECTAPPLICATION EXISTS
		// GET PROJECTAPPLICATION FROM APPLICANT
		// THEN VIEW
		// ELSE RETURN HAVE NOT APPLIED FOR PROJECT
	}
	
	public void requestAppWithdrawal() {
		// IF PROJECTAPPLICATION EXISTS
		// GET PROJECTAPPLICATION FROM APPLICANT
		// SEND WITHDRAWAL REQUEST
		// ELSE RETURN HAVE NOT APPLIED FOR PROJECT
	}
	
	public void handleEnquiry() {
		// Possible things to do
		// SEND ENQUIRY
		// EDIT ENQUIRY
		// DELETE ENQUIRY
		// GET RESPONSE TO ENQURIY
		// MIGHT NEED FILTER TOO (answered/ unanswered)
	}
}
