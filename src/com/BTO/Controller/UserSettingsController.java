package src.com.BTO.Controller;

import java.util.Scanner;
import java.util.HashMap;

import src.com.BTO.Model.User;
import src.com.BTO.Model.Applicant;
import src.com.BTO.Service.MenuInputService;
import src.com.BTO.View.UserView;

public class UserSettingsController  {
	
	private User user;
	private Scanner sc = new Scanner(System.in);
	
	public UserSettingsController(User u) {
		user = u;
    }
	
	public void viewLandingPage() {
		int choice = -1;
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> UserView.displayUser(user);
    		case 2-> changePassword();
    		case 3-> editFilter();
    		}

    		UserView.displayOptions();
    		choice = MenuInputService.getMenuInput();
    	}
    	
    	System.out.println("Exiting user settings...\n");
	}
	
	private void changePassword() {
		System.out.println("Changing password...");
		System.out.println("Enter current password to confirm:");
		
		String password = sc.next();
		boolean correct = user.checkPassword(password);
		
		if (correct) {
			System.out.println("Enter new password:");
			password = sc.next();
			user.changePassword(password);
			System.out.println("Password changed!\n");
			// SHOULD SAVE UPDATED TO CSV FILE
		}
		else {
			System.out.println("ERROR: Incorrect password!");
			System.out.println("Terminating...\n");
		}
	}
	
	private void editFilter() {
		if (user instanceof Applicant) {
			Scanner sc = new Scanner(System.in);
			
			Applicant appl = (Applicant) user;
			HashMap<String, String> filters = appl.getFilters();
			UserView.displayFilters(filters);
			
			String key = sc.next();
			System.out.println();
			
			System.out.println("Currently filter key set to: " + filters.get(key));
			
			System.out.println("What to change key to? (set NULL for none)");
			String newKey = sc.next();
			
			appl.setFilter(key, newKey);
			System.out.println("Filter added!");
			
			System.out.println();
		}
		else {
			System.out.println("Not applicant so i havent added functionality");
			// HAVENT ADDED FOR NON APPLICANTS, WILL GIVE THEM LATER
		}
	}
}
