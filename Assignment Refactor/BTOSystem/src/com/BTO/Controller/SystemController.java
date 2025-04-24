package BTO.Controller;

import BTO.Enum.MaritalStatus;
import BTO.Enum.UserType;
import BTO.Model.Applicant;
import BTO.Model.HDBManager;
import BTO.Model.HDBOfficer;
import BTO.Model.Project;
import BTO.Model.SystemData;
import BTO.Model.Unit;
import BTO.Model.User;
import BTO.Service.AuthService;
import BTO.Service.CSVLoaderService;
import BTO.Service.UnitService;
import BTO.View.SystemView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemController {

    private static final String APPLICANT_CSV = "Data/ApplicantList.csv";
    private static final String OFFICER_CSV = "Data/OfficerList.csv";
    private static final String MANAGER_CSV = "Data/ManagerList.csv";
    private static final String PROJECT_CSV = "Data/ProjectList.csv";
    
    public static SystemData initializeData() {
        List<Applicant> applicants = loadApplicants();
        List<HDBOfficer> officers = loadHDBOfficers();
        List<HDBManager> managers = loadHDBManagers();
        List<Project> projects = loadProjects(managers, officers);

        return new SystemData(applicants, officers, managers, projects);
    }

    private static List<Applicant> loadApplicants() {
        CSVLoaderService loader = new CSVLoaderService();
        return loader.loadcsv(APPLICANT_CSV, columns ->
            new Applicant(columns[0], columns[1], Integer.parseInt(columns[2]),
                MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4], UserType.APPLICANT)
        );
    }

    private static List<HDBOfficer> loadHDBOfficers() {
        CSVLoaderService loader = new CSVLoaderService();
        return loader.loadcsv(OFFICER_CSV, columns ->
            new HDBOfficer(columns[0], columns[1], Integer.parseInt(columns[2]),
            MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4], UserType.HDBOFFICER)
        );
    }

    private static List<HDBManager> loadHDBManagers() {
        CSVLoaderService loader = new CSVLoaderService();
        return loader.loadcsv(MANAGER_CSV, columns ->
            new HDBManager(columns[0], columns[1], Integer.parseInt(columns[2]),
            MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4], UserType.HDBMANAGER)
        );
    }

    private static List<Project> loadProjects(List<HDBManager> managers, List<HDBOfficer> officers) {
        CSVLoaderService loader = new CSVLoaderService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        return loader.loadcsv(PROJECT_CSV, columns -> {
            String projectName = columns[0];
            String neighbourhood = columns[1];

            List<Unit> unitList = UnitService.createUnitList(columns, 2, 7); // 2 to 7 = unit info

            LocalDate openDate = LocalDate.parse(columns[8], formatter);
            LocalDate closeDate = LocalDate.parse(columns[9], formatter);

            HDBManager manager = HDBManagerController.findManager(managers, columns[10]);

            // Officer slots at index 11 (optional use)
            // Officer names start at index 12 to the end
            List<String> officerNameList = new ArrayList<>();
            for (int i = 12; i < columns.length; i++) {
                officerNameList.add(columns[i].trim());
            }

            Project project = new Project(projectName, neighbourhood, openDate, closeDate, manager);
            unitList.forEach(project::addUnitType);

            // Add officers by matching name
            for (String name : officerNameList) {
                officers.stream()
                    .filter(officer -> officer.getName().equalsIgnoreCase(name))    
                    .findFirst()
                    .ifPresent(o -> project.addOfficer((HDBOfficer) o));
            }

            return project;
        });
    }

    private static void landingMenu(SystemData systemData) {

        boolean running = true;

        while (running) {
            SystemView.displayMainMenu();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    SystemView.displayExitMessage();
                    running = false;
                    break;
                case "1":
                    User loggedInUser = AuthService.authenticate(systemData.getAllUsers(), scanner);
                    if (loggedInUser != null) {

                        switch (loggedInUser.getUserType().toString()) {
                            case "APPLICANT":
                                ArrayList<Project> arrProjs = new ArrayList<>(systemData.getProjects());
                                ArrayList<Application> arrAppls = new ArrayList<>(systemData.getApplications());
                                ApplicantController applicantController = new ApplicantController((Applicant) loggedInUser, arrProjs, arrAppls);
                                applicantController.viewLandingPage();
                                

                                //ApplicantController.run(systemData, loggedInUser, scanner);
                                break;
                            case "HDBOFFICER":
                                ArrayList<Project> arrProjs = new ArrayList<>(systemData.getProjects());
                                ArrayList<Application> arrAppls = new ArrayList<>(systemData.getApplications());
                                HDBOfficerController officerController = new HDBOfficerController((HDBOfficer) loggedInUser, arrProjs, arrAppls);
                                officerController.viewLandingPage();
                                //HDBOfficerController.run(systemData, loggedInUser, scanner);
                                break;
                            case "HDBMANAGER":
                                HDBManagerController.run(systemData, loggedInUser, scanner);
                                break;
                            default:
                                SystemView.displayInvalidUserType();
                        }
                    }
                    break;
                default:
                    SystemView.displayInvalidInput();
                    break;
            }
        }
    }

    public static void start(SystemData systemData) {
        SystemView.displayWelcomeMessage();
        landingMenu(systemData);
    }
    
}
