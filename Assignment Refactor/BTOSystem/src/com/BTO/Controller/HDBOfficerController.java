package BTO.Controller;

import java.util.Scanner;

import BTO.Model.Applicant;
import BTO.Model.HDBOfficer;
import BTO.Model.SystemData;
import BTO.Model.User;
import BTO.View.HDBOfficerView;

public class HDBOfficerController {

    public static void run(SystemData data, User user, Scanner scanner) {

        HDBOfficer hdbOfficer = (HDBOfficer) user;
        HDBOfficerView view = new HDBOfficerView();

        boolean running = true;
        while (running) {
            System.out.println("\n=== HDB Officer Dashboard ===");
            System.out.println("Welcome, " + hdbOfficer.getName() + "!");
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
                    // View projects logic
                    break;
                case "3":
                    // Apply/Book project logic
                    break;
                case "4":
                    // View applied project logic
                    break;
                case "5":
                    // Request withdrawal logic
                    break;
                case "6":
                    // Handle enquiries logic
                    break;
                case "7":
                    // Register to join project
                    break;
                case "8":
                    // Manage bookings
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}