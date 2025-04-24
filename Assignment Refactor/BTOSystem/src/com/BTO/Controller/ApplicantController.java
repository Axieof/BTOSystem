package BTO.Controller;

import java.util.Scanner;

import BTO.Model.Applicant;
import BTO.Model.SystemData;
import BTO.Model.User;
import BTO.View.ApplicantView;

public class ApplicantController {

    public static void run(SystemData data, User user) {
        if (!(user instanceof Applicant)) {
            System.out.println("Invalid user type for ApplicantController.");
            return;
        }

        Applicant applicant = (Applicant) user;
        ApplicantView view = new ApplicantView();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Applicant Dashboard ===");
            System.out.println("Welcome, " + applicant.getName() + "!");
            view.displayOptions();

            Scanner scanner = new Scanner(System.in);
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
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
