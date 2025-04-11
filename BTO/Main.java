package BTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface UserProcessor<T> {
    void process(String[] columns, List<T> list);
}

public class Main {
    
    // Function: Main
    // To contain code for main program flow
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        System.out.print("===== Welcome to the BTO Management System! =====");
        
        while (programRunning) {
            System.out.println(null);
            System.out.println(null);
            System.out.println(null);
            System.out.println(null);
            System.out.println(null);
            System.out.println(null);
        }

    }

    // Function: Load Users
    private static void loadUsers() {
        // Step 1 - Initialize lists for 3 user types
        try {
            // Create empty lists
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function: Read CSV Files
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

    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome User!");
        System.out.print("---LOGIN---");

        System.out.print("Enter NRIC: ");
        String nricInput = scanner.nextLine();

        System.out.print("Enter Password: ");
        String passwordInput = scanner.nextLine();


    }
}