package src.com.BTO.Services;

public class CSVLoaderService {
    
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
}
