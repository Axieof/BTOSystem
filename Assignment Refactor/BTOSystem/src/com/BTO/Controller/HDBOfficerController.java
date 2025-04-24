package BTO.Controller;

import java.util.Scanner;

import BTO.Model.HDBOfficer;
import BTO.Model.SystemData;
import BTO.Model.User;
import BTO.View.HDBOfficerView;

public class HDBOfficerController {

    public static void run(SystemData systemData, User user,Scanner scanner) {
        boolean running = true;
        while (running) {
            HDBOfficerView.displayMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    running = false;
                    break;
                case "1":
                    // Change password logic
                    break;
                case "2":
                    // View open projects logic
                    break;
                case "3":
                    // Apply for a project logic
                    break;
                case "4":
                    // View application status logic
                    break;
                case "5":
                    // Request withdrawal logic
                    break;
                case "6":
                    // Submit enquiry logic
                    break;
                case "7":
                    // View/Edit/Delete enquiries logic
                    break;
                case "8":
                    // Register for a project logic
                    break;
                case "9":
                    // View registration status logic
                    break;
                case "10":
                    // View project details logic
                    break;
                case "11":
                    // Reply to enquiries logic
                    break;
                case "12":
                    // Update flat booking details logic
                    break;
                case "13":
                    // Generate booking receipt logic
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
