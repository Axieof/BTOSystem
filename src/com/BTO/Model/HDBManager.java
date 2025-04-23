package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;
import src.com.BTO.Model.Enums.ApplicationStatus;
import src.com.BTO.Model.Enums.RoomType;
import src.com.BTO.Service.*;
import java.util.ArrayList;
import java.util.List;

public class HDBManager extends User implements ICSVWritable {

    private ArrayList<Project> ownedProjects = new ArrayList<>();

    public HDBManager(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }

    public void addOwnedProject(Project p) {
        if (!ownedProjects.contains(p)) ownedProjects.add(p);
    }

    public ArrayList<Project> getOwnedProjects() {
        return ownedProjects;
    }

    // Toggle project visibility
    public void toggleProjectVisibility(Project project, boolean visible) {
        if (ownedProjects.contains(project)) {
            project.setVisibility(visible);
        }
    }

    // Approve or reject HDBOfficer registration
    public void reviewOfficerRegistration(Project project, HDBOfficer officer, boolean approve) {
        if (ownedProjects.contains(project)) {
            if (approve) {
                project.addOfficer(officer);
            } else {
                // handle rejected logic (if needed)
            }
        }
    }

    // Approve or reject applicant’s BTO application
    public void reviewApplication(Application application, boolean approve) {
        if (!ownedProjects.contains(application.getProject())) return;

        if (approve) {
            RoomType room = application.getUnit().getRoomType();
            for (Unit u : application.getProject().getUnitTypes()) {
                if (u.getRoomType() == room && u.getUnitCount() > 0) {
                    u.setUnitCount(u.getUnitCount() - 1);
                    application.setAppStatus(ApplicationStatus.SUCCESSFUL);
                    return;
                }
            }
            application.setAppStatus(ApplicationStatus.UNSUCCESSFUL);
        } else {
            application.setAppStatus(ApplicationStatus.UNSUCCESSFUL);
        }
    }

    // Approve or reject withdrawal requests
    public void reviewWithdrawal(WithdrawalApplication withdrawal, boolean approve) {
        if (!ownedProjects.contains(withdrawal.withdrawing.getProject())) return;

        if (approve) {
            withdrawal.setApplicationStatus(ApplicationStatus.UNSUCCESSFUL);
            // restore flat count
            Unit u = withdrawal.withdrawing.getUnit();
            u.setUnitCount(u.getUnitCount() + 1);
        } else {
            withdrawal.setApplicationStatus(ApplicationStatus.SUCCESSFUL);
        }
    }

    // Generate report of booked applicants with filters
    public void generateReport(String filterType, String filterValue) {
        for (Project project : ownedProjects) {
            for (HDBOfficer officer : project.getOfficers()) {
                Application app = officer.getApplied();
                if (app != null && app.getAppStatus() == ApplicationStatus.BOOKED) {
                    boolean matches = switch (filterType) {
                        case "marital" -> officer.getMaritalStatus().toString().equalsIgnoreCase(filterValue);
                        case "flat" -> app.getUnit().getRoomType().toString().equalsIgnoreCase(filterValue);
                        default -> true;
                    };
                    if (matches) {
                        System.out.println("Name: " + officer.getName()
                                + ", NRIC: " + officer.getMaskedNric()
                                + ", Age: " + officer.getAge()
                                + ", Marital Status: " + officer.getMaritalStatus()
                                + ", Project: " + project.getProjectName()
                                + ", Flat Type: " + app.getUnit().getRoomType());
                    }
                }
            }
        }
    }

    @Override
    public String toCSV() {
        return String.join(",",
            getName(),
            getNric(),
            String.valueOf(getAge()),
            String.valueOf(getMaritalStatus()),
            getPassword()
        );
    }
}
