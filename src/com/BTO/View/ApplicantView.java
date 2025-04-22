package src.com.BTO.View;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Application;
import src.com.BTO.Model.Project;

public class ApplicantView {
    
	public static void displayOptions() {
		System.out.println("--- Applicant Options ---\n"
				+ "1) Personal settings\n"
				+ "2) View projects\n"
				+ "3) Apply for project\n"
				+ "4) View your applied project\n"
				+ "5) Request application withdrawal\n"
				+ "6) Handle your enquiries\n"
				+ "0) LOGOUT\n");
	}
	
	public static void displayAppliedProject(Application applied) {
		System.out.println("--- Applicaiton information ---");
		Project proj = applied.getProject();
		System.out.println("Project Name: " + proj.getProjectName());
		System.out.println(applied.getUnit());
    	System.out.println("Application Status: " + applied.getAppStatus());
    	System.out.println();
	}
}
