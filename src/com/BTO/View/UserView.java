package src.com.BTO.View;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.HDBOfficer;
import src.com.BTO.Model.User;

import java.util.HashMap;

public class UserView {
	public void displayUser(User user) {
		if (user instanceof HDBOfficer)  System.out.println("--- Officer information ---");
		else if (user instanceof Applicant) System.out.println("--- Applicant information ---");
		else System.out.println("--- user information ---");

		System.out.println("Name: \t\t" + user.getName() + "\n"
				+ "NRIC: \t\t" + user.getMaskedNric() + "\n"
				+ "Age: \t\t" + user.getAge() + "\n"
		 		+ "Marital Status: " + user.getMaritalStatus()); 
		
		if (user instanceof HDBOfficer) displayOfficer((HDBOfficer)user);
		else if (user instanceof Applicant) displayApplicant((Applicant)user);
	   	
		System.out.println();
    }
	
	public void displayOfficer(HDBOfficer user) {
		displayApplicant(user);
		if (user.getBookedProject() != null) {
			System.out.println("Registered project: " 
					+ user.getCurrProj().getProjectName());
		}
		else {
			System.out.println("Registered project: NULL");
		}
		
	}
	public void displayApplicant(Applicant user) {
		if (user.getBookedProject() != null) {
			System.out.println("Booked project: " 
					+ user.getBookedProject().getProjectName());
		}
		else {
			System.out.println("Booked project: NULL");
		}
	}
	
	public void displayOptions() {
		System.out.println("--- Personal Settings Options ---\n"
				+ "1) View personal information\n"
				+ "2) Change password\n"
				+ "3) Edit filter\n"
				+ "0) RETURN\n");
	}
	
	public void displayFilters(String[] all) {
		System.out.println("Which filter to edit?");
		for (int i=0; i<all.length; i++) {
			System.out.print(i + ". " + all[i]);
			if (all[i] == "FilterFlatType") System.out.println(" (TWOROOM/ THREEROOM)");
			else System.out.println();
		}
	}
}
