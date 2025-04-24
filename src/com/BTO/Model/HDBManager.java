package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;
import src.com.BTO.Model.Enums.ApplicationStatus;
import src.com.BTO.Model.Enums.RoomType;
import src.com.BTO.Service.*;
import java.util.ArrayList;


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

    public void toggleProjectVisibility(Project project, boolean visible) {
        if (ownedProjects.contains(project)) project.setVisibility(visible);
    }

    public void reviewOfficerRegistration(Project project, HDBOfficer officer, boolean approve) {
        if (!ownedProjects.contains(project)) return;
    
        Application reg = officer.getProjReg();
        if (reg == null || reg.getProject() != project) return;
    
        if (approve) {
            project.addOfficer(officer);
            officer.setCurrProj(project);
            officer.setProjReg(null);
            reg.setAppStatus(ApplicationStatus.SUCCESSFUL);
            System.out.println("Officer " + officer.getName() + " approved and added to project: " + project.getProjectName());
        } else {
            officer.setProjReg(null);
            reg.setAppStatus(ApplicationStatus.UNSUCCESSFUL);
            System.out.println("Officer " + officer.getName() + " rejected for project: " + project.getProjectName());
        }
    }

    public void reviewApplication(Application application, boolean approve) {
        if (!ownedProjects.contains(application.getProject())) return;

        if (approve) {
            Unit selected = application.getUnit();
            if (selected.getUnitCount() > 0) {
                selected.setUnitCount(selected.getUnitCount() - 1);
                application.setAppStatus(ApplicationStatus.SUCCESSFUL);
            } else {
                application.setAppStatus(ApplicationStatus.UNSUCCESSFUL);
            }
        } else {
            application.setAppStatus(ApplicationStatus.UNSUCCESSFUL);
        }
    }

    public void reviewWithdrawal(WithdrawalApplication withdrawal, boolean approve) {
        Application app = withdrawal;
    
        if (!ownedProjects.contains(app.getProject())) return;
    
        if (approve) {
            withdrawal.setApplicationStatus(ApplicationStatus.SUCWITHDRAWAL);
            Unit unit = app.getUnit();
            if (unit != null) {
                unit.setUnitCount(unit.getUnitCount() + 1);
            }
        } else {
            if (app.getApplicant().getBookedUnit() != null) {
                withdrawal.setApplicationStatus(ApplicationStatus.BOOKED);
            } else {
                withdrawal.setApplicationStatus(ApplicationStatus.PENDING);
            }
        }
    }
    

    public void generateReport(String filterType, String filterValue) {
        for (Project project : ownedProjects) {
            for (HDBOfficer officer : project.getOfficers()) {
                Application app = officer.getApplied();
                if (app != null && app.getAppStatus() == ApplicationStatus.BOOKED) {
                    boolean match = switch (filterType.toLowerCase()) {
                        case "marital" -> officer.getMaritalStatus().toString().equalsIgnoreCase(filterValue);
                        case "flat" -> app.getUnit().getRoomType().toString().equalsIgnoreCase(filterValue);
                        default -> true;
                    };
                    if (match) {
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