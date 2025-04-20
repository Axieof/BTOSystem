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

    // Function: Load Users
    // Initialization process to load users from csv files
    private static void loadUsers() {

        try {
            // Step 1 - Create empty lists
            List<Applicant> applicants = new ArrayList<>();
            List<HDBOfficer> hdbOfficers = new ArrayList<>();
            List<HDBManager> hdbManagers = new ArrayList<>();

            // Step 2 - Read CSV files and populate lists
            readCSV("Data/ApplicantList.csv", applicants, (columns, list) -> {
                Applicant applicant = new Applicant(columns[0], columns[1], Integer.parseInt(columns[2]), columns[3], columns[4]);
                list.add(applicant);
            });
            
            readCSV("Data/OfficerList.csv", hdbOfficers, (columns, list) -> {
                HDBOfficer officer = new HDBOfficer(columns[0], columns[1], Integer.parseInt(columns[2]), columns[3], columns[4]);
                list.add(officer);
            });
            
            readCSV("Data/ManagerList.csv", hdbManagers, (columns, list) -> {
                HDBManager manager = new HDBManager(columns[0], columns[1], Integer.parseInt(columns[2]), columns[3], columns[4]);
                list.add(manager);
            });

            // Step 3 - Print out the lists to verify their contents
            /*
            System.out.println("Applicants List:");
            for (Applicant applicant : applicants) {
                System.out.println(applicant);
            }

            System.out.println("\nHDB Officers List:");
            for (HDBOfficer officer : hdbOfficers) {
                System.out.println(officer);
            }

            System.out.println("\nHDB Managers List:");
            for (HDBManager manager : hdbManagers) {
                System.out.println(manager);
            }
            */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function: Read CSV Files
    // To read from provided csv files and populate user lists
    private static <T> void readCSV(String fileName, List<T> list, UserProcessor<T> processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Skip header line
            br.readLine();

            // Read each line of the CSV
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                processor.process(columns, list);
            }
        }
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