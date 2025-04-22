package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;

public class Applicant extends User {

    private Application appliedProject = null; // Project user has applied for
    
    public Applicant(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }
    
    public Application getApplied() { return appliedProject; }
    public void setApplied(Application app) { appliedProject = app; }
}
