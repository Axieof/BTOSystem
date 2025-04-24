package BTO.View;

import BTO.Model.User;
import BTO.Enum.UserType;

public abstract class UserView {

    public void displayCommonOptions() {
        System.out.println("0) Logout");
        System.out.println("1) Personal Settings");
    }

    public static void displayPersonalOptions() {
        System.out.println("\n=== User Settings ===");
        System.out.println("0) Exit");
        System.out.println("1) View Personal Details");
        System.out.println("2) Change Password");
        System.out.println("3) Edit Filters");
        System.out.print("Enter your choice: ");
    }

    public static void displayUser(User user) {
        System.out.println("\n=== Personal Details ===");
        System.out.println("Name: " + user.getName());
        System.out.println("NRIC: " + user.getMaskedNric());
        System.out.println("Age: " + user.getAge());
        System.out.println("Marital Status: " + user.getMaritalStatus());
        System.out.println("User Role: " + user.getUserType().toString());
        System.out.println("-------------------------");
    }

    public static void displayChangePasswordPrompt() {
        System.out.println("Changing password...");
        System.out.println("Enter current password to confirm:");
    }

    public static void displayNewPasswordPrompt() {
        System.out.println("Enter new password:");
    }

    public static void displayPasswordChanged() {
        System.out.println("Password changed successfully!\n");
    }

    public static void displayIncorrectPassword() {
        System.out.println("ERROR: Incorrect password!");
    }

    public static void displayFilters(String[] filters) {
        System.out.println("\n=== Available Filters ===");
        for (int i = 0; i < filters.length; i++) {
            System.out.println(i + ") " + filters[i]);
        }
        System.out.print("Select a filter to edit: ");
    }

    public static void displayInvalidFilterSelection() {
        System.out.println("Invalid filter selection.");
    }

    public static void displayCurrentFilter(String filterName, String filterValue) {
        System.out.println("Currently filter key set to: " + filterValue + " for " + filterName);
    }

    public static void displayFilterChangePrompt() {
        System.out.println("What to change key to? (set NULL for none)");
    }

    public static void displayFilterUpdated() {
        System.out.println("Filter updated successfully!\n");
    }

    public static void displayExitMessage() {
        System.out.println("Exiting user settings...\n");
    }

    public static void displayInvalidOption() {
        System.out.println("Invalid option. Please try again.");
    }

    public abstract void displayOptions();
}