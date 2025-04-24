package BTO.Controller;

import java.util.Scanner;

import BTO.Model.Applicant;
import BTO.Model.SystemData;
import BTO.Model.User;
import BTO.View.ApplicantView;
import BTO.View.SystemView;

public class ApplicantController {

    public static void run(SystemData data, User user, Scanner scanner) {

        Applicant applicant = (Applicant) user;
        ApplicantView view = new ApplicantView();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Applicant Dashboard ===");
            System.out.println("Welcome, " + applicant.getName() + "!\n");
            view.displayOptions();

            System.out.println("\nPlease enter your choice: ");
            String input = scanner.nextLine();
            System.out.println("DEBUG: User entered: " + input);

            switch (input) {
                case "0":
                    running = false;
                    break;
                case "1":
                    // Personal settings logic
                    break;
                case "2":
                    SystemView.displayProjects(data.getProjects());
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
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
