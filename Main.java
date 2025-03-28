package BTOSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    // Function: Main
    // To contain code for main program flow
    public static void main(String[] args) {

        // Step 1 - Initialize users
        try {
            // Initialize lists for 3 user types
            List<Applicant> applicants = new ArrayList<>();
            List<HDBOfficer> hdbOfficers = new ArrayList<>();
            List<HDBManager> hdbManagers = new ArrayList<>();

            // Read the CSV files and assign to appropriate list
            readCSV("ApplicantList.csv", applicants);
            readCSV("OfficerList.csv", hdbOfficers);
            readCSV("ManagerList.csv", hdbManagers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function: Read csv files
    // To initialize the users from the provided data files
    private static void readCSV(String fileName, List<?> list) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
            // Initialize variable
            String line;

            // Skip header line
            br.readLine();

            // Read the CSV file line by line
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                
                // Create a user based on the role
                if (list instanceof List<Applicant>) {

                    Applicant applicant = new Applicant(columns[0], columns[1], Integer.parseInt(columns[2]), columns[3], columns[4]);
                    ((List<Applicant>) list).add(applicant);

                } else if (list instanceof List<HDBOfficer>) {

                    HDBOfficer officer = new HDBOfficer(columns[0], columns[1], Integer.parseInt(columns[2]), columns[3], columns[4]);
                    ((List<HDBOfficer>) list).add(officer);

                } else if (list instanceof List<HDBManager>) {

                    HDBManager manager = new HDBManager(columns[0], columns[1], Integer.parseInt(columns[2]), columns[3], columns[4]);
                    ((List<HDBManager>) list).add(manager);
                    
                }
            }
        }
    }
}