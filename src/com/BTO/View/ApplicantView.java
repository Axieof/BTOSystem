package src.com.BTO.View;

import src.com.BTO.Model.Applicant;

public class ApplicantView {
    
     public static void printApplicantDetails(Applicant appli) {
    	 System.out.println("--- Applicant information ---\n"
  				+ "Name: \t\t" + appli.getName() + "\n"
 				+ "NRIC: \t\t" + appli.getMaskedNric() + "\n"
 				+ "Age: \t\t" + appli.getAge() + "\n"
 		 		+ "Marital Status: " + appli.getMaritalStatus() + "\n");
     }
	public static void displayOptions() {
		System.out.println("--- Applicant Options ---\n"
				+ "1) View projects\n"
				+ "2) Apply for project\n"
				+ "3) View your applied project\n"
				+ "4) Request application withdrawal\n"
				+ "5) Handle your enquiries\n"
				+ "0) LOGOUT\n");
	}
}
