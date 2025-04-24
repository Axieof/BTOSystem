package src.com.BTO;

// Imports
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.com.BTO.Controller.*;
import src.com.BTO.Model.*;
import src.com.BTO.Model.Enums.*;
import src.com.BTO.Service.*;
import src.com.BTO.View.*;

public class Main {
    public static void main(String[] args) {

        // Initialize central scanner to pass to core functions
        Scanner mainScanner = new Scanner(System.in);

        // Step [1] - Load all data from csv
        CSVLoaderService csvLoader = new CSVLoaderService();
        List<User> users = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        List<Application> applications = new ArrayList<>();

        // Load from csv files into a central list
        users.addAll(csvLoader.loadcsv("Data/ApplicantList.csv", columns -> new Applicant(columns[0], columns[1], Integer.parseInt(columns[2]), MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4])));
        users.addAll(csvLoader.loadcsv("Data/OfficerList.csv", columns -> new HDBOfficer(columns[0], columns[1], Integer.parseInt(columns[2]), MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4])));
        users.addAll(csvLoader.loadcsv("Data/ManagerList.csv", columns -> new HDBManager(columns[0], columns[1], Integer.parseInt(columns[2]), MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4])));
        
        // INCOMPLETE LOAD APPLICATION
//    	List<Application> l = csvloader.loadcsv("Data/ApplicationList.csv", 
//      			columns -> {
//      				int ID = Integer.parseInt(columns[0]);
//    			int projID = Integer.parseInt(columns[1]); 
//    			RoomType rt = RoomType.valueOf(columns[2]);
//    			ApplicationStatus stat = ApplicationStatus.valueOf(columns[3]); 
//    			int applID = Integer.parseInt(columns[4]);
//    			boolean book = Boolean.valueOf(columns[5]);
//      				
//    			if (stat == ApplicationStatus.SUCCESSFUL) {
//    				
//    				
//    			}
//    			//Application a = new Application();
//      				
//      				return a;
//      			});

        
        projects.addAll(csvLoader.loadcsv("Data/ProjectList.csv", columns -> {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

            String projectName = columns[0];
            String neighbourhood = columns[1];
            List<Unit> unitList = UnitService.createUnitList(columns, 2, 7);
            LocalDate openDate = LocalDate.parse(columns[8], formatter);
            LocalDate closeDate = LocalDate.parse(columns[9], formatter);
            HDBManager manager = HDBManagerController.findManager(users, columns[10]);
            //int officerSlots = Integer.parseInt(columns[unitEndIndex + 3]);
            String[] officerNames = columns[12].split(",");

            Project project = new Project(projectName, neighbourhood, openDate, closeDate, manager);
            for (Unit unit : unitList) {
                project.addUnitType(unit);
            }

            for (String officerName : officerNames) {
                for (User user : users) {
                    if (user instanceof HDBOfficer && user.getName().equalsIgnoreCase(officerName.trim())) {
                        project.addOfficer((HDBOfficer) user);
                        break;
                    }
                }
            }

            return project;
        } ));

        ProjectView projectView = new ProjectView();
        //projectView.displayProjectList(projects);


        // Step [2] - Show landing page
        LandingPageController landingController = new LandingPageController(users);
        User loggedInUser = landingController.run(mainScanner);

        // Step [3] - Dispatch accordingly
        //ApplicantController applicantController = new ApplicantController();
        //HDBOfficerController hdbOfficerController = new HDBofficerController();
        //HDBManagerController hdbManagerController = new HDBManagerController();

        if (loggedInUser instanceof HDBOfficer) {
            System.out.println("\nRedirecting to HDB Officer Dashboard...");
            // new OfficerController((HDBOfficer) loggedInUser).run();
            ArrayList<Project> arrProjs = new ArrayList<>(projects);
            ArrayList<Application> arrAppls = new ArrayList<>(applications);
            HDBOfficerController officerController = new HDBOfficerController((HDBOfficer) loggedInUser, arrProjs, arrAppls);
            officerController.viewLandingPage();
            
        } else if (loggedInUser instanceof Applicant) {
            System.out.println("\nRedirecting to Applicant Dashboard...");
            // new ApplicantController((Applicant) loggedInUser).run();
            ArrayList<Project> arrProjs = new ArrayList<>(projects);
            ArrayList<Application> arrAppls = new ArrayList<>(applications);
            ApplicantController applicantController = new ApplicantController((Applicant) loggedInUser, arrProjs, arrAppls);
            applicantController.viewLandingPage();
            
        } else if (loggedInUser instanceof HDBManager) {
            System.out.println("\nRedirecting to HDB Manager Dashboard...");
            HDBManagerController hdbManagerController = new HDBManagerController((HDBManager) loggedInUser, mainScanner);
            hdbManagerController.run();
        } else {
            System.out.println("No User has logged in. Exiting program");
        }


        // Step [4] - Write Everything back to file
        List<String> userHeaders = List.of("Name", "NRIC", "Age", "Marital Status", "Password");
        List<ICSVWritable> finalApplicants = new ArrayList<>();
        List<ICSVWritable> finalHDBOfficers = new ArrayList<>();
        List<ICSVWritable> finalHDBManagers = new ArrayList<>();

        for (User user : users) {
            if (user instanceof HDBOfficer) {
                finalHDBOfficers.add((HDBOfficer) user);
            } else if (user instanceof Applicant) {
                finalApplicants.add((Applicant) user);
            } else if (user instanceof HDBManager) {
                finalHDBManagers.add((HDBManager) user);
            }
        }

        CSVWriterService csvWriter = new CSVWriterService();
        csvWriter.writeCSV(finalApplicants, "Data/ApplicantList.csv", userHeaders);
        csvWriter.writeCSV(finalHDBOfficers, "Data/OfficerList.csv", userHeaders);
        csvWriter.writeCSV(finalHDBManagers, "Data/ManagerList.csv", userHeaders);

        //List<String> projectHeaders = List.of("Project Name", "Neighbourhood", "Type 1", "Units 1", "Price 1", "Type 2", "Units 2", "Price 2", "Open Date", "Close Date", "Manager", "Officer Slots", "Officers");
        //CSVWriterService.writeCSV(projectList, "Data/ProjectList.csv", projectHeaders);

        
    }
}
