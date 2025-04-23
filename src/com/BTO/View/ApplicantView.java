package src.com.BTO.View;

import src.com.BTO.Model.Application;
import src.com.BTO.Model.Project;

import java.util.ArrayList;

public class ApplicantView extends UserView{
	@Override
	public void displayOptions() {
		System.out.println("--- Applicant Options ---\n"
				+ "0) LOGOUT\n"
				+ "1) Personal settings\n"
				+ "2) View projects\n"
				+ "3) Apply/ Book project\n"
				+ "4) View your applied project\n"
				+ "5) Request application withdrawal\n"
				+ "6) Handle your enquiries\n");
	}
	
	public void displayAppliedProject(Application applied) {
		System.out.println("--- Application information ---");
		Project proj = applied.getProject();
		System.out.println("Project Name: " + proj.getProjectName());
		System.out.println(applied.getUnit());
    	System.out.println("Application Status: " + applied.getAppStatus());
    	System.out.println();
	}
}
