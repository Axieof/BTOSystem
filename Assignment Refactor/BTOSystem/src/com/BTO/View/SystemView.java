package BTO.View;

import java.util.List;

import BTO.Model.User;
import BTO.Model.Project;
import BTO.Model.HDBOfficer;
import BTO.Model.SystemData;

public class SystemView {
    public static void displayWelcomeMessage() {
        System.out.println("=================================================");
        System.out.println("===== Welcome to the BTO Management System! =====");
        System.out.println("=================================================");
    }

    public static void displayMainMenu() {
        System.out.println("\n----- Main Menu -----");
        System.out.println("0) Exit");
        System.out.println("1) Login");
        System.out.print("Enter your choice: ");
    }

    public static void displayInvalidInput() {
        System.out.println("Invalid input. Please try again.");
    }

    public static void displayExitMessage() {
        System.out.println("Thank you for using the BTO System. Goodbye!");
    }

    public static void displayInvalidUserType() {
        System.out.println("Invalid user type. Please contact the administrator.");
    }

    public static void displayAllusers(List<User> users) {
        for (User user: users) {
            System.out.println("Name: " + user.getName());
            System.out.println("NRIC: " + user.getMaskedNric());
            System.out.println("Age: " + user.getAge());
            System.out.println("Marital Status: " + user.getMaritalStatus());
            System.out.println("User Type: " + user.getUserType());
            System.out.println("-------------------------" );
        }
    }

    public static void displayProjects(List<Project> projects) {
        System.out.println("\n=== Available Projects ===\n");
        for (Project project : projects) {
            System.out.println("Name: " + project.getProjectName());
            System.out.println("Neighbourhood: " + project.getNeighbourhood());
            System.out.println("Application Open Date: " + project.getAppOpenDate());
            System.out.println("Application Close Date: " + project.getAppCloseDate());
            System.out.println("Manager Managing: " + project.getManager().getName());
            System.out.print("Officers Attached: ");
            if (project.getOfficers() != null && !project.getOfficers().isEmpty()) {
                for (HDBOfficer officer : project.getOfficers()) {
                    System.out.print(officer.getName() + " ");
                }
            } else {
                System.out.print("None");
            }
            System.out.println("\n-------------------------");
        }
    }

}
