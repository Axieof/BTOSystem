package src.com.BTO.Controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.com.BTO.Model.Enums.RoomType;
import src.com.BTO.Model.HDBManager;
import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;
import src.com.BTO.Model.User;
import src.com.BTO.View.HDBManagerView;


public class HDBManagerController {

    private final HDBManager manager;
    private final Scanner sc;
    private final HDBManagerView view = new HDBManagerView();

    public HDBManagerController(HDBManager manager, Scanner sc) {
        this.manager = manager;
        this.sc = sc;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.displayMainMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> projectManagementMenu();
                case 2 -> officerMenu();
                case 3 -> applicantMenu();
                case 4 -> handleWithdrawals();
                case 5 -> enquiryMenu();
                case 6 -> generateReport();
                case 0 -> running = false;
                default -> view.showInvalidOption();
            }
        }
    }

    public static HDBManager findManager(List<User> users, String managerName) {
        
        HDBManager manager = null;

            for (User user : users) {
                if (user instanceof HDBManager && user.getName().equalsIgnoreCase(managerName.trim())) {
                    manager = (HDBManager) user;
                    return manager;
                }
            }

            return manager;
    }

    private void projectManagementMenu() {
        boolean back = false;
        while (!back) {
            view.displayProjectManagementMenu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> createProject();
                case 2 -> editProject();
                case 3 -> deleteProject();
                case 4 -> toggleVisibility();
                case 5 -> viewAllProjects();
                case 6 -> viewMyProjects();
                case 0 -> back = true;
                default -> view.showInvalidOption();
            }
        }
    }

    private void createProject() {
        System.out.print("Project name: ");
        String name = sc.nextLine();
        System.out.print("Neighbourhood: ");
        String hood = sc.nextLine();
        System.out.print("Open date (YYYY-MM-DD): ");
        LocalDate open = LocalDate.parse(sc.nextLine());
        System.out.print("Close date (YYYY-MM-DD): ");
        LocalDate close = LocalDate.parse(sc.nextLine());

        Project p = new Project(name, hood, open, close, manager);

        System.out.print("Number of unit types: ");
        int unitCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < unitCount; i++) {
            System.out.print("Room type (2 or 3): ");
            RoomType type = (Integer.parseInt(sc.nextLine()) == 2) ? RoomType.TWOROOM : RoomType.THREEROOM;
            System.out.print("Price: ");
            int price = Integer.parseInt(sc.nextLine());
            System.out.print("Units: ");
            int count = Integer.parseInt(sc.nextLine());
            p.addUnitType(new Unit(type, price, count));
        }

        manager.addOwnedProject(p);
        view.showProjectCreated(p);
    }

    private void editProject() {
        Project p = selectProject();
        if (p == null) return;
        System.out.print("New name: "); p.setProjectName(sc.nextLine());
        System.out.print("New hood: "); p.setNeighbourhood(sc.nextLine());
        System.out.print("New open (YYYY-MM-DD): "); p.setAppOpenDate(LocalDate.parse(sc.nextLine()));
        System.out.print("New close (YYYY-MM-DD): "); p.setAppCloseDate(LocalDate.parse(sc.nextLine()));
        view.showProjectEdited(p);
    }

    private void deleteProject() {
        Project p = selectProject();
        if (p == null) return;
        manager.getOwnedProjects().remove(p);
        view.showProjectDeleted(p);
    }

    private void toggleVisibility() {
        Project p = selectProject();
        if (p == null) return;
        p.setVisibility(!p.getVisibility());
        view.showToggleVisibility(p, p.getVisibility());
    }

    private void viewAllProjects() {
        ArrayList<Project> all = manager.getOwnedProjects();
        if (all.isEmpty()) view.showNoProjects();
        else all.forEach(System.out::println);
    }

    private void viewMyProjects() {
        viewAllProjects();
    }

    private Project selectProject() {
        ArrayList<Project> projects = manager.getOwnedProjects();
        if (projects.isEmpty()) {
            view.showNoProjects(); return null;
        }
        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i + 1) + ") " + projects.get(i).getProjectName());
        }
        System.out.print("Select project: ");
        int idx = Integer.parseInt(sc.nextLine());
        if (idx < 1 || idx > projects.size()) {
            view.showInvalidOption(); return null;
        }
        return projects.get(idx - 1);
    }

    private void officerMenu() {
        boolean back = false;
        while (!back) {
            view.displayOfficerMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> System.out.println("[TODO] Display pending officer registrations");
                case 2 -> System.out.println("[TODO] Approve/reject officer registration");
                case 0 -> back = true;
                default -> view.showInvalidOption();
            }
        }
    }
    
    private void applicantMenu() {
        boolean back = false;
        while (!back) {
            view.displayApplicantMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> System.out.println("[TODO] View applicant applications");
                case 2 -> System.out.println("[TODO] Approve/reject applicant applications");
                case 0 -> back = true;
                default -> view.showInvalidOption();
            }
        }
    }

    private void enquiryMenu() {
        boolean back = false;
        while (!back) {
            view.displayEnquiryMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> System.out.println("[TODO] View all enquiries");
                case 2 -> System.out.println("[TODO] Respond to enquiries for my projects");
                case 0 -> back = true;
                default -> view.showInvalidOption();
            }
        }
    }
    private void generateReport() {
        System.out.println("Filter by? (marital/flat/all): ");
        String filterType = sc.nextLine().toLowerCase();
        String value = "ALL";
        if (!filterType.equals("all")) {
            System.out.print("Enter value to filter: ");
            value = sc.nextLine();
        }
        view.showReportHeader(filterType);
        manager.generateReport(filterType, value);
    }

    private void handleWithdrawals() {
        System.out.println("[TODO] Handle withdrawal requests from applicants");
    }
}
