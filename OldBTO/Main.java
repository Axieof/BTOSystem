package src.com.BTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.com.BTO.Model.Applicant;

interface UserProcessor<T> {
    void process(String[] columns, List<T> list);
}

public class Main {
    
    // Function: Main
    // To contain code for main program flow
    public static void main(String[] args) {

        // TODO: REFACTOR INTO Landing Page
        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        String userType = null;
        System.out.println("===== Welcome to the BTO Management System! =====");
        
        // TODO: REFACTOR INTO CSVLOADER
        System.out.println("\nLoading Users...");
        loadUsers();
        System.out.println("Users Loaded!");

        // TODO: REFACTOR? OR REDO IN AUTHSERVICE
        while (programRunning) {
            System.out.println("\n----- Main Menu -----");
            System.out.println("1) Login");
            System.out.println("2) Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userType = loginUser(scanner);
                    break;
                case 2:
                    programRunning = false;
                    break;
            
                default:
                    System.out.println("Invalid Option. Please try again!");
                    break;
            }

            switch (userType) {
                case "Applicant":
                    break;

                case "HDBOfficer":
                    break;

                case "HDBManager":
                    break;
            
                default:
                    break;
            }
        }

        // Initialization
        //List<User> users = CSVLoader.loadusers("../../../data/users.csv")
        //List<ProjectListing> projects = CSVLoader.loadProjects("../../../data/projects.csv")

        //AuthService authSvc = new AuthService

        // Login 
        //AuthController authC = new AuthController(AuthService?...)
        //User authorisedUser = authc.login();

        // Dispatch according to role

        //if (currentUser instanceof HDBManager) {
        // TODO: CALL HDBManager Controller
        //} else if (currentUser instanceof HDBOfficer) {
        // TODO: CALL HDBOfficer Controller
        //} else {
        // TODO: CALL Applicant Controller
        //}

    }

    

    // Function: LoginUser
    // To provide the user with an interface to login with credentials
    // as well as verify and let the system know the user's type
    private static String loginUser(Scanner scanner) {

        // Step 1 - Provide Interface
        System.out.println("\nWelcome User!");
        System.out.println("---LOGIN---");

        // Step 2 - Get Input
        System.out.println("Enter NRIC: ");
        String nricInput = scanner.nextLine();

        System.out.println("Enter Password: ");
        String passwordInput = scanner.nextLine();

        // Step 3 - Verify

        // Step 4 - Return User Type
        return "Applicant"; // Temporary

    }
}