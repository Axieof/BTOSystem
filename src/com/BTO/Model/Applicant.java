package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;

import java.util.HashMap;

public class Applicant extends User {

    private Application appliedProject = null; // Project user has applied for
    private HashMap<String, String> filters = new HashMap<>();
    
    public Applicant(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }
    
    public Application getApplied() { return appliedProject; }
    public void setApplied(Application app) { appliedProject = app; }
    
    public HashMap<String, String> getFilters() { return filters; }
    public void setFilter(String filterType, String key) {
    	filters.put(filterType, key);
    }
}
