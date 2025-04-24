package BTO.Controller;

import java.util.List;
import java.util.Scanner;

import BTO.Model.HDBManager;
import BTO.Model.SystemData;
import BTO.Model.User;
import BTO.View.HDBManagerView;

public class HDBManagerController {

    // Static utility for SystemController to call
    public static HDBManager findManager(List<HDBManager> users, String managerName) {
        return users.stream()
                .filter(manager -> manager.getName().equalsIgnoreCase(managerName.trim()))
                .findFirst()
                .orElse(null);
    }

    // Called by SystemController when manager logs in
    public static void run(SystemData data, User user, Scanner scanner) {

        HDBManager hdbManager = (HDBManager) user;
        HDBManagerView view = new HDBManagerView();

        boolean running = true;
        while (running) {
            System.out.println("\n=== HDB Manager Dashboard ===");
            System.out.println("Welcome, " + hdbManager.getName() + "!\n");
            view.displayOptions();

            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    running = false;
                    break;
                case "1":
                    // Personal settings logic
                    break;
                case "2":
                    // Manage BTO Projects
                    break;
                case "3":
                    // Handle HDB Officer Registrations
                    break;
                case "4":
                    // Handle Applicant Applications
                    break;
                case "5":
                    // Handle Withdrawal Requests
                    break;
                case "6":
                    // View & Respond to Enquiries
                    break;
                case "7":
                    // Generate Reports
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
