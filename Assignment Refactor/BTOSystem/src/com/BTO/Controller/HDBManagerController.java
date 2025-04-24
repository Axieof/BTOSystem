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
    public static void run(SystemData systemData, User user,Scanner scanner) {
        boolean running = true;
        while (running) {
            HDBManagerView.displayMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    running = false;
                    break;
                case "1":
                    // Change password logic
                    break;
                case "2":
                    // View all projects logic
                    break;
                case "3":
                    // Create new project logic
                    break;
                case "4":
                    // Edit project logic
                    break;
                case "5":
                    // Delete project logic
                    break;
                case "6":
                    // Toggle project visibility logic
                    break;
                case "7":
                    // View pending/approved officer registrations logic
                    break;
                case "8":
                    // Approve/reject officer registration logic
                    break;
                case "9":
                    // Approve/reject applicant application logic
                    break;
                case "10":
                    // Approve/reject withdrawal requests logic
                    break;
                case "11":
                    // Generate applicant report logic
                    break;
                case "12":
                    // View/reply to enquiries logic
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
