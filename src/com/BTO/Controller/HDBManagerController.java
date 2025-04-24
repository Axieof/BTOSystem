package src.com.BTO.Controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.*;
import src.com.BTO.Model.Enums.*;
import src.com.BTO.Service.Filter.FilterManager;
import src.com.BTO.View.*;

import java.time.LocalDate;
import java.util.*;


public class HDBManagerController {
    private final HDBManager manager;
    private final Scanner sc;
    private final HDBManagerView view = new HDBManagerView();
    private final ManagerEnquiryView enquiryView = new ManagerEnquiryView();
    private final ProjectView projectView = new ProjectView();
    private final UserView userView = new UserView();

    public HDBManagerController(HDBManager manager, Scanner sc) {
        this.manager = manager;
        this.sc = sc;
    }

    public static HDBManager findManager(List<User> users, String nric) {
        for (User u : users) {
            if (u instanceof HDBManager && u.getNric().equalsIgnoreCase(nric)) {
                return (HDBManager) u;
            }
        }
        return null;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.displayMainMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> manageProjects();
                case 2 -> handleOfficerRegistrations();
                case 3 -> handleApplicantApplications();
                case 4 -> handleWithdrawals();
                case 5 -> handleEnquiries();
                case 6 -> generateReports();
                case 0 -> running = false;
                default -> view.showInvalidOption();
            }
        }
    }

    private void manageProjects() {
        boolean back = false;
        while (!back) {
            view.displayProjectManagementMenu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> createProject();
                case 2 -> editProject();
                case 3 -> deleteProject();
                case 4 -> toggleVisibility();
                case 5 -> projectView.displayProjectList(manager.getOwnedProjects());
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
        System.out.print("How many unit types? ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.print("Room type (TWOROOM/THREEROOM): ");
            RoomType type = RoomType.valueOf(sc.nextLine().toUpperCase());
            System.out.print("Selling price: ");
            int price = Integer.parseInt(sc.nextLine());
            System.out.print("Unit count: ");
            int units = Integer.parseInt(sc.nextLine());
            p.addUnitType(new Unit(type, units, price));
        }

        manager.addOwnedProject(p);
        view.showProjectCreated(p);
    }

    private void editProject() {
        Project p = selectProject();
        if (p == null) return;
        System.out.print("New name: "); p.setProjectName(sc.nextLine());
        System.out.print("New neighbourhood: "); p.setNeighbourhood(sc.nextLine());
        System.out.print("New open date (YYYY-MM-DD): "); p.setAppOpenDate(LocalDate.parse(sc.nextLine()));
        System.out.print("New close date (YYYY-MM-DD): "); p.setAppCloseDate(LocalDate.parse(sc.nextLine()));
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

    private void viewMyProjects() {
        List<Project> filtered = new FilterManager<Project>().mgrFilterProjects(manager.getOwnedProjects(), manager);
        projectView.displayProjectList(filtered);
    }

    private Project selectProject() {
        List<Project> projects = manager.getOwnedProjects();
        if (projects.isEmpty()) {
            view.showNoProjects();
            return null;
        }

        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i + 1) + ". " + projects.get(i).getProjectName());
        }
        System.out.print("Select project #: ");
        int idx = Integer.parseInt(sc.nextLine());
        return (idx < 1 || idx > projects.size()) ? null : projects.get(idx - 1);
    }

    private void handleOfficerRegistrations() {
    boolean back = false;
        while (!back) {
            view.displayOfficerMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> viewAllPendingOfficers();
                case 2 -> approveOrRejectOfficers();
                case 0 -> back = true;
                default -> view.showInvalidOption();
            }
        }
    }

    // In HDBManagerController.java
    private void viewAllPendingOfficers() {
        boolean found = false;

        for (Project project : manager.getOwnedProjects()) {
            ArrayList<HDBOfficer> allOfficers = project.getOfficers();

            for (HDBOfficer officer : allOfficers) {
                Application reg = officer.getProjReg();

                if (reg != null &&
                    reg.getAppStatus() == ApplicationStatus.PENDING &&
                    reg.getProject() == project) {

                    found = true;
                    System.out.println("\nPending registration:");
                    System.out.println("- Officer: " + officer.getName());
                    System.out.println("- Project: " + project.getProjectName());
                }
            }
        }

        if (!found) {
            System.out.println("No pending officer registrations.");
        }
    }

    

    private void approveOrRejectOfficers() {
        for (Project project : manager.getOwnedProjects()) {
            ArrayList<HDBOfficer> allOfficers = project.getOfficers();
    
            List<HDBOfficer> pending = new ArrayList<>();
            for (HDBOfficer officer : allOfficers) {
                Application reg = officer.getProjReg();
                if (reg != null &&
                    reg.getAppStatus() == ApplicationStatus.PENDING &&
                    reg.getProject() == project) {
                    pending.add(officer);
                }
            }
    
            if (pending.isEmpty()) continue;
    
            System.out.println("\nPending officers for " + project.getProjectName() + ":");
            for (int i = 0; i < pending.size(); i++) {
                System.out.println((i + 1) + ". " + pending.get(i).getName());
            }
    
            System.out.print("Select officer # to review (0 to skip): ");
            int index = Integer.parseInt(sc.nextLine());
    
            if (index > 0 && index <= pending.size()) {
                HDBOfficer officer = pending.get(index - 1);
                System.out.print("Approve (a) / Reject (r): ");
                String input = sc.nextLine().toLowerCase();
    
                boolean approved = input.equals("a");
                manager.reviewOfficerRegistration(project, officer, approved);
    
                if (approved) {
                    System.out.println("Approved " + officer.getName());
                } else {
                    System.out.println("Rejected " + officer.getName());
                }
            }
        }
    }
    
    
    
    


    private void handleApplicantApplications() {
        for (Project project : manager.getOwnedProjects()) {
            List<Application> applications = project.getApplications();
            for (Application app : applications) {
                if (app.getAppStatus() == ApplicationStatus.PENDING) {
                    userView.displayUser(app.getApplicant());
                    projectView.displayUnit(app.getUnit());
                    System.out.print("Approve this application? (y/n): ");
                    String input = sc.nextLine();
                    manager.reviewApplication(app, input.equalsIgnoreCase("y"));
                }
            }
        }
    }

    private void handleWithdrawals() {
        for (Project project : manager.getOwnedProjects()) {
            List<Application> withdrawals = project.getWithdrawalApplications();
            for (Application withdrawal : withdrawals) {
                if (withdrawal.getApplicationStatus() == ApplicationStatus.REQWITHDRAWAL) {
                    userView.displayUser(withdrawal.getApplicant());
                    System.out.print("Approve withdrawal? (y/n): ");
                    String input = sc.nextLine();
                    manager.reviewWithdrawal(withdrawal, input.equalsIgnoreCase("y"));
                }
            }
        }
    }

    private void handleEnquiries() {
        for (Project project : manager.getOwnedProjects()) {
            System.out.println("Enquiries for project: " + project.getProjectName());
            List<Enquiry> all = project.getEnquiryList();
            for (Enquiry e : all) {
                System.out.println("Enquiry ID: " + e.getId());
                System.out.println("From: " + e.getSender().getName());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Reply: " + (e.getReply() == null ? "[Not yet answered]" : e.getReply()));
                if (e.getReply() == null) {
                    System.out.print("Reply now? (y/n): ");
                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        System.out.print("Enter reply: ");
                        e.setReply(sc.nextLine());
                        System.out.println("Reply submitted.");
                    }
                }
                System.out.println();
            }
        }
    }

    private void generateReports() {
        System.out.println("Filter by (marital/flat/all): ");
        String filterType = sc.nextLine();
        String filterValue = "ALL";
        if (!filterType.equalsIgnoreCase("all")) {
            System.out.print("Enter value: ");
            filterValue = sc.nextLine();
        }
        view.showReportHeader(filterType);
        manager.generateReport(filterType, filterValue);
    }
}