package BTO.Model;

import java.util.ArrayList;
import java.util.List;

public class SystemData {
    
    // Attributes
    private List<Applicant> applicantList = new ArrayList<>();
    private List<HDBOfficer> hdbOfficerList = new ArrayList<>();
    private List<HDBManager> hdbmanagerList = new ArrayList<>();
    private List<Project> projectList = new ArrayList<>();

    public SystemData(List<Applicant> applicantList, List<HDBOfficer> hdbOfficerList, List<HDBManager> hdbmanagerList, List<Project> projectList) {
        this.applicantList = applicantList;
        this.hdbOfficerList = hdbOfficerList;
        this.hdbmanagerList = hdbmanagerList;
        this.projectList = projectList;
    }

    // Getters
    public List<Applicant> getApplicants() { return applicantList; }
    public List<HDBOfficer> getOfficers() { return hdbOfficerList; }
    public List<HDBManager> getManagers() { return hdbmanagerList; }
    public List<Project> getProjects() { return projectList; }

    // Setters
    public void setApplicants(List<Applicant> applicantList) { this.applicantList = applicantList; }
    public void setOfficers(List<HDBOfficer> hdbOfficerList) { this.hdbOfficerList = hdbOfficerList; }
    public void setManagers(List<HDBManager> hdbmanagerList) { this.hdbmanagerList = hdbmanagerList; }
    public void setProjects(List<Project> projectList) { this.projectList = projectList; }

    // Methods
    public List<User> getAllUsers() {
        List<User> all = new java.util.ArrayList<>();
        all.addAll(applicantList);
        all.addAll(hdbOfficerList);
        all.addAll(hdbmanagerList);
        return all;
    }

    public List<Project> getAllProjects() {
        return projectList;
    }
}
