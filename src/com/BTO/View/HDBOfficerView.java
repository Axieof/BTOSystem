package src.com.BTO.View;

import src.com.BTO.Model.Application;
import java.util.ArrayList;

public class HDBOfficerView extends ApplicantView{
	public void displayStarter() {
		System.out.println("--- Which menu? ---\n"
							+ "0) LOGOUT\n"
							+ "1) Applicant features\n"
							+ "2) Officer features\n"
							+ "3) View Project and Enquiries\n");
	}
	public void displayOptions() {
		System.out.println("--- Officer Options ---\n"
				+ "0) LOGOUT\n"
				+ "1) Register to join project\n"
				+ "2) Manage bookings\n");
	}
	
	public void displayApplications(ArrayList<Application> appls) {
		System.out.println("Which to edit?");
		int count = 0;
    	for (Application appl: appls) {
    		System.out.println("Application " + count);
    		System.out.println("Project: " + appl.getProject().getProjectName() + "\n"
    						+ "Room: " + appl.getUnit().getRoomType() + "\n"
    						+ "Applicant: " + appl.getApplicant().getName() + ", "
    						+ appl.getApplicant().getAge() + ", "
    						+ appl.getApplicant().getMaritalStatus() + "\n");
			count += 1;
    	}
	}
}
