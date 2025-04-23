package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;

import java.util.ArrayList;

public class HDBOfficer extends Applicant {

	private ArrayList<Project> closedProjs;
	private Project currProj;
	
    public HDBOfficer(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
        closedProjs = new ArrayList<>();
        currProj = null;
    }
    
    public ArrayList<Project> getClosedProjs() { return closedProjs; }
    public Project getCurrProj() { return currProj; }
    
    public void addClosedProj(Project proj) { closedProjs.add(proj); }
    public void setCurrProj(Project proj) { currProj = proj; }
}
