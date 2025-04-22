package src.com.BTO.Controller;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Service.MenuInputService;
import src.com.BTO.View.UserView;

public class UserSettingsController  {
	
	private Applicant applicant;
	
	public UserSettingsController(Applicant appl) {
    	applicant = appl;
    }
	
	public void viewLandingPage() {
		int choice = -1;
    	
    	while (choice != 0) {
    		switch (choice) {
    		case 1-> UserView.displayUser(applicant);
    		case 2-> changePassword();
    		case 3-> editFilter();
    		}

    		UserView.displayOptions();
    		choice = MenuInputService.getMenuInput();
    	}
    	
    	System.out.println("Exiting user settings...");
	}
	
	private void changePassword() {
		
	}
	
	private void editFilter() {
		
	}
}
