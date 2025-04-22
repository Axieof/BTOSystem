package src.com.BTO.View;

import src.com.BTO.Model.User;

import java.util.HashMap;

public class UserView {
	public static void displayUser(User user) {
	   	 System.out.println("--- Applicant information ---\n"
	 				+ "Name: \t\t" + user.getName() + "\n"
					+ "NRIC: \t\t" + user.getMaskedNric() + "\n"
					+ "Age: \t\t" + user.getAge() + "\n"
			 		+ "Marital Status: " + user.getMaritalStatus() + "\n");  	 
    }
	
	public static void displayOptions() {
		System.out.println("--- Personal Settings Options ---\n"
				+ "1) View personal information\n"
				+ "2) Change password\n"
				+ "3) Edit filter\n"
				+ "0) RETURN\n");
	}
	
	public static void displayFilters(String[] all) {
		System.out.println("Which filter to edit?");
		for (int i=0; i<all.length; i++) {
			System.out.println(i + ". " + all[i]);
		}
	}
}
